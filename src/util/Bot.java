package util;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class Bot extends TelegramBot{

	public Bot(String botToken) {
		super(botToken);
		// TODO Auto-generated constructor stub
	}
	
	public boolean sendPrice(Object groupID, String message) {
		
		message = "<pre>".concat(message).concat("</pre>");
		
		SendMessage request = new SendMessage(groupID, message)
		        .parseMode(ParseMode.HTML)
		        .disableWebPagePreview(true)
		        .disableNotification(true);
//		        .replyToMessageId(1)
//		        .replyMarkup(new ForceReply());

		// sync
		SendResponse sendResponse = this.execute(request);
		return false;
	}
	
	public boolean sendMessage(Object groupID, String message) {
		
//		message = "<pre>".concat(message).concat("</pre>");
		
		SendMessage request = new SendMessage(groupID, message)
		        .parseMode(ParseMode.HTML)
		        .disableWebPagePreview(true)
		        .disableNotification(true);
//		        .replyToMessageId(1)
//		        .replyMarkup(new ForceReply());

		// sync
		SendResponse sendResponse = this.execute(request);
		return false;
	}
	
public boolean sendAlert(Object groupID, String message) {
		
		message = "`".concat(message).concat("`");
		
		SendMessage request = new SendMessage(groupID, message)
		        .parseMode(ParseMode.Markdown)
		        .disableWebPagePreview(true)
		        .disableNotification(true);
//		        .replyToMessageId(1)
//		        .replyMarkup(new ForceReply());

		// sync
		SendResponse sendResponse = this.execute(request);
		return false;
	}
}
