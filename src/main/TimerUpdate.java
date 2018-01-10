package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.JTextArea;

import util.BittrexGetMarket;
import util.Bot;

public class TimerUpdate extends TimerTask {
	JTextArea textArea;
	boolean flag = true;
	Bot bot;
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	static SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
	Object chatID = "";

	FileWriter writerTxt;
	BufferedWriter buffTxt = null;

	public TimerUpdate(JTextArea textArea) {
		// TODO Auto-generated constructor stub
		this.textArea = textArea;
		try {
			writerTxt = new FileWriter(fileDateFormat.format(new Date(System.currentTimeMillis())) + ".txt", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buffTxt = new BufferedWriter(writerTxt);
	}

	public TimerUpdate setBotToken(String token) {
		bot = new Bot(token);
		return this;
	}
	
	public TimerUpdate setChatID(Object chatID) {
		this.chatID = chatID;
		return this;
	}

	public void stopRunning() {
		flag = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("running...");
		String resultTxt = "";

		try {
			if (MainScreen.btc_top_check) {
				resultTxt = BittrexGetMarket.getUSDTMarkets() + System.lineSeparator()
						+ BittrexGetMarket.getBTCMarkets();
			} else {
				resultTxt = BittrexGetMarket.getUSDTMarkets();
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			textArea.append("There is an error. Please start again");
			stopRunning();
		}
		try {
			textArea.append(resultTxt);
			textArea.append("--------------" + simpleDateFormat.format(new Date(System.currentTimeMillis()).getTime())
					+ "------------------");
			textArea.append(System.lineSeparator());
			textArea.setCaretPosition(textArea.getDocument().getLength());

			buffTxt.write(resultTxt);
			buffTxt.write("--------------" + simpleDateFormat.format(new Date(System.currentTimeMillis()).getTime())
					+ "------------------");
			buffTxt.newLine();
			buffTxt.flush();

			bot.sendPrice(this.chatID, resultTxt);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			stopRunning();
			e.printStackTrace();
			try {
				buffTxt.flush();
				buffTxt.close();

				// buffCsv.flush();
				// buffCsv.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

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
