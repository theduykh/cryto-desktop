package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;

import util.BittrexGetMarket;
import util.Bot;

public class UpdateAreaText implements Runnable {
	JTextArea textArea;
	boolean flag = true;
	Bot bot;
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	static SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
	
	public UpdateAreaText(JTextArea textArea) {
		// TODO Auto-generated constructor stub
		this.textArea = textArea;
	}
	
	public UpdateAreaText setBotToken(String token) {
		bot = new Bot(token);
		return this;
	}
	
    public void stopRunning()
    {
        flag = false;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String result = "";
		 BufferedWriter bufferedWriter = null;
        try {
            FileWriter writer = new FileWriter(fileDateFormat.format(new Date(System.currentTimeMillis()))+".txt", true);
            bufferedWriter = new BufferedWriter(writer);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		 while (flag)
	        {
			 try {
				 if (MainScreen.btc_top_check) {
					 result = BittrexGetMarket.getUSDTMarkets() + System.lineSeparator() + BittrexGetMarket.getBTCMarkets();
				} else {
					result = BittrexGetMarket.getUSDTMarkets();
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				textArea.append("There is an error. Please start again");
				stopRunning();
			}
			try {
				textArea.append(result);
				textArea.append("--------------"+simpleDateFormat.format(new Date(System.currentTimeMillis()).getTime())+"------------------");
				textArea.append(System.lineSeparator());
				textArea.setCaretPosition(textArea.getDocument().getLength());
				
	            bufferedWriter.write(result);
	            bufferedWriter.write("--------------"+simpleDateFormat.format(new Date(System.currentTimeMillis()).getTime())+"------------------");
	            bufferedWriter.newLine();
	            bufferedWriter.flush();
	            
				bot.sendPrice(MainScreen.chatID, result);
				System.out.println("running...");
//				Thread.sleep(MainScreen.interval);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				stopRunning();
				try {
					bufferedWriter.flush();
					bufferedWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		 System.out.println("Stopped.");

	}
	
	public void file() {
        try {
            FileWriter writer = new FileWriter(fileDateFormat.format(new Date(System.currentTimeMillis())), true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write("Hello World");
            bufferedWriter.newLine();
            bufferedWriter.write("See You Again!");
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
	

}
