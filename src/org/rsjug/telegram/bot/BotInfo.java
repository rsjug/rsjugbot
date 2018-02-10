package org.rsjug.telegram.bot;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BotInfo {

	private Properties prop = null;
	private InputStream input = null;
	private String botUsername;
	private String botToken;
	private String botFatherId;
	private String botQnASubscription;
	private String botQnAKnowledgebaseId;

	public BotInfo() {
		prop = new Properties();

		try {

			input = getClass().getResourceAsStream("telegram.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			setBotUsername(prop.getProperty("botUsername"));
			setBotToken(prop.getProperty("botToken"));
			setBotFatherId(prop.getProperty("botFatherId"));
			setBotQnASubscription(prop.getProperty("botQnASubscription"));
			setBotQnAKnowledgebaseId(prop.getProperty("botQnAKnowledgebaseId"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public String getBotUsername() {
		return botUsername;
	}

	public void setBotUsername(String botUsername) {
		this.botUsername = botUsername;
	}

	public String getBotToken() {
		return botToken;
	}

	public void setBotToken(String botToken) {
		this.botToken = botToken;
	}

	public String getBotFatherId() {
		return botFatherId;
	}

	public void setBotFatherId(String botFatherId) {
		this.botFatherId = botFatherId;
	}

	public String getBotQnASubscription() {
		return botQnASubscription;
	}

	public void setBotQnASubscription(String botQnASubscription) {
		this.botQnASubscription = botQnASubscription;
	}

	public String getBotQnAKnowledgebaseId() {
		return botQnAKnowledgebaseId;
	}

	public void setBotQnAKnowledgebaseId(String botQnAKnowledgebaseId) {
		this.botQnAKnowledgebaseId = botQnAKnowledgebaseId;
	}

}
