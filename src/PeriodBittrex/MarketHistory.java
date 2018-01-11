package PeriodBittrex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class MarketHistory {

	public static final int TYPE_BUY = 1;
	public static final int TYPE_SELL = 2;
	public static final int FILL = 1;
	public static final int PARTIAL_FILL = 2;

	public static final SimpleDateFormat TIMESTAMP = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss");

	protected long id;
	protected long timeStamp;
	protected double price;
	protected double quantity;
	protected double total;
	int type;
	int fillType;
	
	

	public MarketHistory(JSONObject json) throws JSONException {
		id = json.getLong("Id");
		price = json.getDouble("Price");
		quantity = json.getDouble("Quantity");
		total = json.getDouble("Total");

		String timeString = json.getString("TimeStamp");
		try {
			timeStamp = TIMESTAMP.parse(timeString).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String typeString = json.getString("OrderType");
		if (typeString.equals("SELL")) {
			type = TYPE_SELL;
		} else if (typeString.equals("BUY")) {
			type = TYPE_BUY;
		}

		String fillString = json.getString("FillType");
		if (fillString.equals("FILL")) {
			fillType = FILL;
		} else if (fillString.equals("PARTIAL_FILL")) {
			fillType = PARTIAL_FILL;
		}
	}
	
	public String toString() {
		String rString = "";
		rString = rString.concat("P:"+price+"T:"+timeStamp);
		
		return rString;
	}

}
