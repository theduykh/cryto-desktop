package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPost {
	 
	public static void call_me() throws Exception {
		URL url = new URL("https://bittrex.com/api/v1.1/public/getticker ");
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.setConnectTimeout(5000);//5 secs
	    connection.setReadTimeout(5000);//5 secs

	    connection.setRequestMethod("POST");
	    connection.setDoOutput(true);
	    connection.setRequestProperty("Content-Type", "application/json");
	    
	    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());  
	    out.write(
	            "[ " +
	            "\"market\"," +
	            "\"USDT-BTC\" " +
	            "]");
	    out.flush();
	    out.close();

	    int res = connection.getResponseCode();

	    System.out.println(res);


	    InputStream is = connection.getInputStream();
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	    String line = null;
	    while((line = br.readLine() ) != null) {
	        System.out.println(line);
	    }
	    connection.disconnect();
	}
}
