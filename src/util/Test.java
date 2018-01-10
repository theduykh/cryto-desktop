package util;

public class Test {
	public static String botToken = "509227301:AAElZW7GVOXiLWbRgpRFvMs2XkSy9gCPz5A";
	
	
	
	public static void main(String[] args) throws Exception {
		String data = HttpGet.call_me("https://api.binance.com/api/v1/klines?symbol=BTCUSDT&interval=30m&limit=50");
		
//		System.out.println(data);
		
		String[] arrayData = data.split("],");
		for (String string : arrayData) {
			string = string.replaceAll("\\[", "").replaceAll("]", "");
			System.out.println(string);
		}
	}

}
