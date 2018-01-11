package PeriodBittrex;

import java.util.ArrayList;
import java.util.Date;

public class PeriodBittrex implements Period {
	protected long idStart;
	protected long idEnd;
	protected long startTime = 0;
	protected long endTime = 0;
	protected double high = 0;
	protected double low = 1000000;
	protected double open = 0;
	protected double close = 0;
	protected double average = 0;
	protected double volumn = 0;
	protected double total = 0;
	protected double volumnBuy = 0;
	protected double volumnSell = 0;

	protected ArrayList<MarketHistory> data = new ArrayList<>();

	// public static Date startTime;



	public void setStart(long start) {
		this.startTime = start;
	}
	


	public void fill(ArrayList<MarketHistory> data) {
		if (startTime == 0) {
			this.startTime = data.get(0).timeStamp;
		}
		for (MarketHistory marketHistory : data) {
			if (marketHistory.timeStamp >= this.startTime) {
				this.data.add(marketHistory);
				this.endTime = marketHistory.timeStamp;
			}
		}
		calculator();
	}

	public void calculator() {
		this.startTime = data.get(0).timeStamp;
		this.open = data.get(0).price;
		this.endTime = data.get(data.size() - 1).timeStamp;
		this.close = data.get(data.size() - 1).price;

		for (MarketHistory marketHistory : data) {
			if (data.size() == 0) {
				return;
			}
			if (marketHistory.price > this.high) {
				this.high = marketHistory.price;
			}
			if (marketHistory.price < this.low) {
				this.low = marketHistory.price;
			}
			if (marketHistory.type == MarketHistory.TYPE_BUY) {
				this.volumnBuy += marketHistory.quantity;
			} else if (marketHistory.type == MarketHistory.TYPE_SELL) {
				this.volumnSell += marketHistory.quantity;
			}
			this.volumn += marketHistory.quantity;
			this.total += marketHistory.total;
		}

		this.average = total / volumn;

	}

	public double getHigh() {
		return high;
	}

	public double getLow() {
		return low;
	}

	public double getAverage() {
		return low;
	}

	public double getOpen() {
		return low;
	}

	public double getClose() {
		return low;
	}

	public double getVolumn() {
		return low;
	}

	public double getTotal() {
		return low;
	}

}
