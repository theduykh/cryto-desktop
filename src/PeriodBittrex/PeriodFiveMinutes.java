package PeriodBittrex;

import java.util.ArrayList;

public class PeriodFiveMinutes extends PeriodBittrex {

	protected PeriodBittrex[] data;

	protected double alertValue = 0;

	public PeriodFiveMinutes(long start) {
		this.startTime = start;
	}

	public PeriodFiveMinutes setNumData(int num) {
		data = new PeriodBittrex[num];
		return this;
	}

	public boolean checking() {
		System.out.println("high:"+high+", low:"+low);
		if ((high - low) >= alertValue) {
			return true;
		}
		return false;
	}

	public PeriodFiveMinutes setAlert(double value) {
		this.alertValue = value;
		return this;
	}

	public void fillPeriod(ArrayList<PeriodBittrex> datas) {
		boolean checkOpen = true;
		for (int i = datas.size() - 1; i >= 0; i--) {
			if (datas.get(i) == null) {
				continue;
			}
			if (checkOpen) {
				open = datas.get(i).open;
			}

			checkOpen = false;
			this.data[i] = datas.get(i);
			if (high < datas.get(i).high) {
				high = datas.get(i).high;
			}
			if (low > datas.get(i).low) {
				low = datas.get(i).low;
			}

			endTime = datas.get(i).endTime;
			total += datas.get(i).total;
			volumn += datas.get(i).volumn;
			volumnBuy += datas.get(i).volumnBuy;
			volumnSell += datas.get(i).volumnSell;
			close = datas.get(i).close;

		}
	}

}
