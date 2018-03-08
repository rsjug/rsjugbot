package org.rsjug.telegram.bot;

import java.util.Calendar;

import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;


public class RsJugBotRunner extends TelegramLongPollingBot{

	public static final String LOGTAG = "RSJUGBOTHANDLERS";
	public BotInfo botInfo = new BotInfo();

	public RsJugBotRunner() {
		try {
			if(botInfo.getBotFatherId() != null)
		      this.sendMessage(new SendMessage().setChatId(botInfo.getBotFatherId()).setText("Fizeram deploy do RSJUGBOT. Se liga."));			
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	

	
	public static void main(String[] args) {
	    TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
	    try {
	        telegramBotsApi.registerBot(new RsJugBotRunner());
	    } catch (TelegramApiException e) {
	        BotLogger.error(LOGTAG, e);
	    }
	}
	
	@Override
	public void onUpdateReceived(Update update) {
		StringBuilder sb = new StringBuilder(); 
		//check if the update has a message
	    if(update.hasMessage()){
	        Message message = update.getMessage();

	        //check if the message has text. it could also contain for example a location ( message.hasLocation() )
	        if(message.hasText()){
	            //create an object that contains the information to send back the message
	            SendMessage sendMessageRequest = new SendMessage();
	            //who should get from the message the sender that sent it.
	            sendMessageRequest.setChatId(message.getChatId().toString()); 

	            log(message.getFrom().getUserName()+ ";"+ message.getFrom().getFirstName()+ ";"+ message.getFrom().getLastName()+ ";"+ message.getChatId().toString() + ";" + message.getText());
	            if(message.getContact() != null)
	              log(message.getContact().getPhoneNumber());

	            RsJugBot conteudo = new RsJugBot();
	            if(null!= message.getFrom().getUserName()) 
	            	sb.append("@").append(message.getFrom().getUserName()).append(":\n");
	            sb.append(conteudo.execute(message.getText()));
	            sendMessageRequest.setText(sb.toString());
	            
	            try {
	            	//at the end, so some magic and send the message ;)
	                sendMessage(sendMessageRequest); 
	            } catch (TelegramApiException e) {
	              log(e.toString());
	            }
	        }
	    }
		
	}

	@Override
	public String getBotUsername() {
		return botInfo.getBotUsername();
	}

	@Override
	public String getBotToken() {
		return botInfo.getBotToken();
	}
	
	private void log(String text)
	{
		System.out.print(Calendar.getInstance().getTime());
		System.out.print(";");
		System.out.println(text);
	}


}
