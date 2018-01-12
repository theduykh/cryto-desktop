package PeriodBittrex;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.TimerTask;

import org.json.JSONArray;
import org.json.JSONObject;

import util.HttpGet;

public class AutoUpdatePeriod extends TimerTask {

	String url = "https://bittrex.com/api/v1.1/public/getmarkethistory?market=USDT-BTC";
	int index = 0;
	PeriodBittrex period;
	PeriodFiveMinutes five;
	PeriodFifteenMinutes fifteen;
	PeriodThirtyMinutes thirty;
	PeriodOneHour oneHour;
	PeriodThreeHours threeHour;
	// PeriodBittrex[] data = new PeriodBittrex[36];
	ArrayList<PeriodBittrex> data;
	int indexData = 0;
	
	PeriodBittrex periodBittrex;

	public AutoUpdatePeriod() {
		data = new ArrayList<>();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		long start = 0;
		long moc = new Date().getTime();
		System.out.println(index);
		if (index == 0) {
			
			// System.out.println(index);
			for (int i = 0; i < 36; i++) {
				data.add(null);
			}
			start = new Date().getTime();
			five = new PeriodFiveMinutes(start);
			five.setAlert(20).setNumData(1);
			fifteen = new PeriodFifteenMinutes(start);
			fifteen.setAlert(30).setNumData(3);
			thirty = new PeriodThirtyMinutes(start);
			thirty.setAlert(40).setNumData(6);
			oneHour = new PeriodOneHour(start);
			oneHour.setAlert(50).setNumData(12);
			threeHour = new PeriodThreeHours(start);
			threeHour.setAlert(50).setNumData(36);
			index++;
			return;
		}
		if (index == 1) {
			periodBittrex = new PeriodBittrex();
		}
		ArrayList<MarketHistory> dataAr = null;
		try {
			dataAr = getMarketHistory(moc-30000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		periodBittrex.fill(dataAr);
		// data.add(periodBittrex);

		if (index % 5 == 0) {
			index = 0;
			data.add(0, periodBittrex);
			data.remove(36);
			indexData++;

			fill();

			if (five.checking()) {
				System.err.println("5m check: "+five.getHigh() + ", " + five.getLow()+" = "+(five.getHigh()-five.getLow()));
			}
			if (fifteen.checking()) {
//				System.err.println(fifteen.getHigh() + ", " + fifteen.getLow());
				System.err.println("15m check: "+fifteen.getHigh() + ", " + fifteen.getLow()+" = "+(fifteen.getHigh()-fifteen.getLow()));
			}
			if (thirty.checking()) {
//				System.err.println(five.getHigh() + ", " + five.getLow());
				System.err.println("30m check: "+thirty.getHigh() + ", " + thirty.getLow()+" = "+(thirty.getHigh()-thirty.getLow()));
			}
			if (oneHour.checking()) {
//				System.err.println(fifteen.getHigh() + ", " + fifteen.getLow());
				System.err.println("1h check: "+oneHour.getHigh() + ", " + oneHour.getLow()+" = "+(oneHour.getHigh()-oneHour.getLow()));
			}
		}

		index++;
	}

	private void fill() {
		five.fillPeriod(new ArrayList<>(data.subList(0, 1)));
		fifteen.fillPeriod(new ArrayList<>(data.subList(0, 3)));
		thirty.fillPeriod(new ArrayList<>(data.subList(0, 6)));
		oneHour.fillPeriod(new ArrayList<>(data.subList(0, 12)));
		threeHour.fillPeriod(data);

	}

	private ArrayList<MarketHistory> getMarketHistory(long time) throws Exception {
		JSONObject[] dataAll = getAllMarketHistory();
		MarketHistory[] dataRS = new MarketHistory[dataAll.length];
		ArrayList<MarketHistory> histories = new ArrayList<>();

		for (int i = 0; i < dataAll.length; i++) {
			dataRS[i] = new MarketHistory(dataAll[i]);
		}

		// String[] yourArray = Arrays.copyOfRange(oldArr, 1, oldArr.length);

		for (int i = 0; i < dataRS.length; i++) {
			if (dataRS[i].timeStamp > time) {
				continue;
			} else {
				// System.out.println(dataRS[i].toString());
				histories.add(dataRS[i]);
			}
		}

		return histories;
	}

	private JSONObject[] getAllMarketHistory() {
		String data = "";
		JSONObject jsonObject;
		JSONArray jsonArray = null;
		JSONObject[] dataAr = null;
		try {
			data = HttpGet.call_me(url);
			jsonObject = new JSONObject(data);
			jsonArray = jsonObject.getJSONArray("result");
			dataAr = new JSONObject[jsonArray.length()];

			for (int i = 0; i < jsonArray.length(); i++) {
				dataAr[i] = jsonArray.getJSONObject(i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no internet");
		}

		return dataAr;
	}

}
