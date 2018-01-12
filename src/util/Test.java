package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import PeriodBittrex.AutoUpdatePeriod;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("Start");
		AutoUpdatePeriod update = new AutoUpdatePeriod();
		Timer timer = new Timer(false);
		timer.scheduleAtFixedRate(update, 0, 20000);
		
//		System.out.println(new Date().getTime());
	}
	
	public void hih() throws Exception {
		String data = HttpGet.call_me("https://api.binance.com/api/v1/klines?symbol=BTCUSDT&interval=30m&limit=50");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss");
		SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
		
		String time = "2018-01-09T16:44:48.673";
		Date d = sdf.parse(time);
		String formattedTime = output.format(d);
		System.out.println(formattedTime);
	}

}
