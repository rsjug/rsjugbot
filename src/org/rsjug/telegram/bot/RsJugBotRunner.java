package org.rsjug.telegram.bot;

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
		 //check if the update has a message
		
		//update.getMessage().i
	    if(update.hasMessage()){
	        Message message = update.getMessage();

	        //check if the message has text. it could also contain for example a location ( message.hasLocation() )
	        if(message.hasText()){
	            //create an object that contains the information to send back the message
	            SendMessage sendMessageRequest = new SendMessage();
	            
	            System.out.println(message.getFrom().getUserName()+ ";"+ message.getFrom().getFirstName()+ ";"+ message.getFrom().getLastName()+ ";"+ message.getChatId().toString() + ";" + message.getText());
	            if(message.getContact() != null)
	              System.out.println(message.getContact().getPhoneNumber());
	            sendMessageRequest.setChatId(message.getChatId().toString()); //who should get from the message the sender that sent it.
	            
	            RsJugBot conteudo = new RsJugBot();
	            
	            sendMessageRequest.setText(conteudo.execute(message.getText()));
	            
	            try {
	                sendMessage(sendMessageRequest); //at the end, so some magic and send the message ;)
	            } catch (TelegramApiException e) {
	            //do some error handling
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


}
