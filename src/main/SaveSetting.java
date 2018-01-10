package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class SaveSetting {
	static SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
	
	
	public static void save(String bot, String chatID) {
		 BufferedWriter bufferedWriter = null;;
	    try {
	        FileWriter writer = new FileWriter("conf.ini", false);
	        writer.write("");
	        writer.flush();
	        bufferedWriter = new BufferedWriter(writer);
	        bufferedWriter.append("BotToken="+bot).append(System.lineSeparator());
	        bufferedWriter.append("chatID="+chatID);
	        
	        bufferedWriter.flush();
	        bufferedWriter.close();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static String[] load() {
		String[] rs = new String[2];
		String text = "";
		try {
			text = readfile();
		} catch (IOException e) {
			rs[0]= "";
			rs[1]= "";
		}
		try {
			String[] strings = text.split("\n");
			String[] row = strings[0].split("=");
			rs[0] = row[1];
			row = strings[1].split("=");
			rs[1] = row[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			rs[0]= "";
			rs[1]= "";
		}
		return rs;
	}
	
	private static String readfile() throws IOException {
		StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("conf.ini"));
            String line;
            while ((line = br.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String contents = sb.toString();
        System.out.println(contents);
        return contents;
	}
	
}
