package PeriodBittrex;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.TimerTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import main.TestAlert;
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
	long id = 0;

	PeriodBittrex periodBittrex;

	FileWriter writerTxt;
	BufferedWriter buffTxt = null;
	static SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
	int interval = 0;
	boolean muoilamphut;
	boolean bamuoiphut;
	boolean mottieng;

	public AutoUpdatePeriod() {
		muoilamphut = TestAlert.MUOILAM;
		bamuoiphut = TestAlert.BAMUOI;
		mottieng = TestAlert.MOTTIENG;
		data = new ArrayList<>();
	}

	public AutoUpdatePeriod(int interval) {
		data = new ArrayList<>();
		this.interval = interval;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		long start = 0;

		System.out.println(index + " - " + MarketHistory.TIMESTAMP.format(new Date()));
		if (index == 0) {
			try {
				writerTxt = new FileWriter(
						"data" + fileDateFormat.format(new Date(System.currentTimeMillis())) + ".txt", true);
				buffTxt = new BufferedWriter(writerTxt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(index);
			for (int i = 0; i < 36; i++) {
				data.add(null);
			}
			start = new Date().getTime();
			five = new PeriodFiveMinutes(start);
			five.setAlert(100).setNumData(1);
			fifteen = new PeriodFifteenMinutes(start);
			fifteen.setAlert(TestAlert.dif_muoilam).setNumData(3);
			thirty = new PeriodThirtyMinutes(start);
			thirty.setAlert(TestAlert.dif_bamuoi).setNumData(6);
			oneHour = new PeriodOneHour(start);
			oneHour.setAlert(TestAlert.dif_mottieng).setNumData(12);
			threeHour = new PeriodThreeHours(start);
			threeHour.setAlert(50).setNumData(36);
			index++;
			return;
		}
		if (index == 1) {
			periodBittrex = new PeriodBittrex();
		}
		MarketHistory[] dataAr = null;
		try {
			dataAr = getMarketHistory(id);
			if (dataAr == null) {
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		if (dataAr.length != 0) {
			id = dataAr[0].id;
			periodBittrex.fill(dataAr);
			for (MarketHistory marketHistory : dataAr) {
				try {
					buffTxt.write(marketHistory.toString());
					buffTxt.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			buffTxt.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (index % 5 == 0) {
			index = 0;
			data.add(0, periodBittrex);
			data.remove(36);
			indexData++;

			fill();

			// if (five.checking()) {
			// System.err.println("5m check: " + five.getHigh() + ", " + five.getLow() + " =
			// "
			// + (five.getHigh() - five.getLow()));
			// }
			if (muoilamphut) {
				System.out.println("Check muoi lam phut");
				if (fifteen.checking()) {
					// System.err.println(fifteen.getHigh() + ", " + fifteen.getLow());
					String pump = "";
					if (fifteen.pump) {
						pump = "UP";
						TestAlert.textArea.append("Period 15min " + pump + ": " + fifteen.getLow() + " -> "
								+ fifteen.getHigh() + ", Dif: " + (fifteen.getHigh() - fifteen.getLow()));
						TestAlert.textArea.append(System.lineSeparator());
					} else {
						pump = "DOWN";
						TestAlert.textArea.append("Period 15min " + pump + ": " + fifteen.getHigh() + " -> "
								+ fifteen.getLow() + ", Dif: " + (fifteen.getHigh() - fifteen.getLow()));
						TestAlert.textArea.append(System.lineSeparator());
					}
					System.err.println("15m check " + pump + ": " + fifteen.getHigh() + " - " + fifteen.getLow() + " = "
							+ (fifteen.getHigh() - fifteen.getLow()));

				}
			}
			if (bamuoiphut) {
				System.out.println("Check ba muoi phut");
				if (thirty.checking()) {
					// System.err.println(five.getHigh() + ", " + five.getLow());

					String pump = "";
					if (fifteen.pump) {
						pump = "UP";
						TestAlert.textArea.append("Period 30min " + pump + ": " + fifteen.getLow() + " -> "
								+ fifteen.getHigh() + ", Dif: " + (fifteen.getHigh() - fifteen.getLow()));
						TestAlert.textArea.append(System.lineSeparator());
					} else {
						pump = "DOWN";
						TestAlert.textArea.append("Period 30min " + pump + ": " + fifteen.getHigh() + " -> "
								+ fifteen.getLow() + ", Dif: " + (fifteen.getHigh() - fifteen.getLow()));
						TestAlert.textArea.append(System.lineSeparator());
					}
					System.err.println("Period 30min " + pump + ": " + thirty.getHigh() + ", " + thirty.getLow() + " = "
							+ (thirty.getHigh() - thirty.getLow()));
				}
			}

			if (mottieng) {
				System.out.println("Check mot tieng");
				if (oneHour.checking()) {
					// System.err.println(fifteen.getHigh() + ", " + fifteen.getLow());

					String pump = "";
					if (fifteen.pump) {
						pump = "UP";
						TestAlert.textArea.append("Period 1hour " + pump + ": " + fifteen.getLow() + " -> "
								+ fifteen.getHigh() + ", Dif: " + (fifteen.getHigh() - fifteen.getLow()));
						TestAlert.textArea.append(System.lineSeparator());
					} else {
						pump = "DOWN";
						TestAlert.textArea.append("Period 1hour " + pump + ": " + fifteen.getHigh() + " -> "
								+ fifteen.getLow() + ", Dif: " + (fifteen.getHigh() - fifteen.getLow()));
						TestAlert.textArea.append(System.lineSeparator());
					}

					System.err.println("Period 1hour" + pump + ": " + oneHour.getHigh() + ", " + oneHour.getLow()
							+ " = " + (oneHour.getHigh() - oneHour.getLow()));
				}
			}

			TestAlert.textArea.setCaretPosition(TestAlert.textArea.getDocument().getLength());

		}
		index++;
	}

	private void fill() {
		// five.fillPeriod(new ArrayList<>(data.subList(0, 1)));
		fifteen.fillPeriod(new ArrayList<>(data.subList(0, 3)));
		thirty.fillPeriod(new ArrayList<>(data.subList(0, 6)));
		oneHour.fillPeriod(new ArrayList<>(data.subList(0, 12)));
		// threeHour.fillPeriod(data);

	}

	private MarketHistory[] getMarketHistory(long id) throws Exception {
		JSONObject[] dataAll = getAllMarketHistory();
		if (dataAll == null) {
			return null;
		}
		ArrayList<MarketHistory> data = new ArrayList<>();
		for (int i = 0; i < dataAll.length; i++) {
			MarketHistory temp = new MarketHistory(dataAll[i]);
			if (temp.id > id) {
				data.add(temp);
			}
		}
		MarketHistory[] rs = new MarketHistory[data.size()];
		rs = data.toArray(rs);
		return rs;
	}

	private JSONObject[] getAllMarketHistory() throws IOException, JSONException {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no internet");
			throw e;
		}

		return dataAr;
	}

}
