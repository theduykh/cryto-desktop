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
		System.out.println("high:" + high + ", low:" + low);
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
		for (int i = datas.size() - 1; i >= 0; i--) {
			if (datas.get(i) == null) {
				continue;
			}
			this.data[i] = datas.get(i);
		}

		calculatePeriod();
	}

	public void calculatePeriod() {
		reset();
		boolean checkOpen = true;
		for (PeriodBittrex periodBittrex : data) {

			if (periodBittrex == null) {
				break;
			}

			if (checkOpen) {
				open = periodBittrex.open;
				checkOpen = false;
			}

			if (high < periodBittrex.high) {
				high = periodBittrex.high;
				timeHigh = periodBittrex.timeHigh;

			}
			if (low > periodBittrex.low) {
				low = periodBittrex.low;
				timeLow = periodBittrex.timeLow;

			}
			System.out.println("Update high:" + high + ", low:" + low);
			if (timeHigh > timeLow) {
				pump = true;
			} else {
				pump = false;
			}
			endTime = periodBittrex.endTime;
			total += periodBittrex.total;
			volumn += periodBittrex.volumn;
			volumnBuy += periodBittrex.volumnBuy;
			volumnSell += periodBittrex.volumnSell;
			close = periodBittrex.close;

		}
	}

}
