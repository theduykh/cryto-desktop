package util;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetPrice {
	static String url_summaries = "https://bittrex.com/api/v1.1/public/getmarketsummaries";

	public static void main(String[] args) throws JSONException, Exception {
		// TODO Auto-generated method stub
		// System.out.println("data"+args[0]+args[1]);
		String[] data = new String[args.length - 1];
		for (int i = 1; i < args.length; i++) {
			data[i - 1] = args[i];
//			System.out.println(args[i]);
		}
		if (args[0].equals("1")) {
			boolean a = true;
			while (a) {
				price(data);
				Thread.sleep(60*1000);
				
			}

		} else {
			price(data);
		}

	}


	public static void price(String[] args) throws JSONException, Exception {
		JSONObject dataJson = new JSONObject(HttpGet.call_me(url_summaries));
		JSONArray array = dataJson.getJSONArray("result");
		ArrayList<BittrexMarket> markets = new ArrayList<>();
		for (int i = 0; i < array.length(); i++) {
			markets.add(new BittrexMarket(array.getJSONObject(i)));
		}

		for (BittrexMarket bittrexMarket : markets) {
			for (String market : args) {
				if (bittrexMarket.getMarket().equals(market)) {
					if (bittrexMarket.getType() == 1) {
						System.out.println(bittrexMarket.toStringBTC());
					}
					if (bittrexMarket.getType() == 0) {
						System.out.println(bittrexMarket.toStringUSDT());
					}

				}
			}
		}
	}

}
