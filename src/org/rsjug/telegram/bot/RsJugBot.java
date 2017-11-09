package org.rsjug.telegram.bot;

public class RsJugBot {

	public static final String PARECEQUE_MESSAGE = "Parece que você pediu ";
	//Commands
	public static final String COMMAND_SITE = "site";
	public static final String COMMAND_FB = "fb";
	public static final String COMMAND_TWITTER = "twitter";
	public static final String COMMAND_TDC = "tdc";
	public static final String COMMAND_EMAIL = "email";
	
	//Defaults
	public static final String RSJUG_WEBSITE = "http://www.rsjug.org";
	public static final String RSJUG_TWITTER = "http://twitter.com/rsjug";
	public static final String RSJUG_FB      = "http://fb.com/groups/rsjug";
	public static final String RSJUG_TDC     = "http://www.thedevelopersconference.com.br/tdc/2017/portoalegre/trilha-java";
	public static final String RSJUG_EMAIL  = "https://groups.google.com/group/rsjug";
	

	public static final String START_MESSAGE = "Opções para teste: \n - site \n - fb \n - twitter \n - tdc \n - email";
	public static final String NO_COMMAND_AVAILABLE = "Comando não reconhecido. \nTem alguma sugestão?\n";

	public String execute(String cmd) {
		
		if(cmd!= null)
			cmd = cmd.toLowerCase().trim();

		if (cmd.equals("/start")) {
			return START_MESSAGE; 
		}
		
		if (cmd.contains(COMMAND_SITE)) {
			return getWebSite();
		}
		
		if (cmd.contains(COMMAND_TDC)) {
			return getTdc();
		}

		if (cmd.contains(COMMAND_FB)) {
			return getFb();
		}

		if (cmd.contains(COMMAND_TWITTER)) {
			if(cmd.equals(COMMAND_TWITTER)) return getTwitter();
			return PARECEQUE_MESSAGE + COMMAND_TWITTER + " " + getTwitter();   
		}

		if (cmd.contains(COMMAND_EMAIL)) {
			if(cmd.equals(COMMAND_EMAIL)) return getEmail();
			return PARECEQUE_MESSAGE + COMMAND_EMAIL + " " + getEmail();   
		}

		return NO_COMMAND_AVAILABLE+START_MESSAGE;
	}

	private String getEmail() {
		return RSJUG_EMAIL;
	}

	public String getTwitter() {
		return RSJUG_TWITTER;
	}

	public String getFb() {
		return RSJUG_FB;
	}

	public String getWebSite() {
		return RSJUG_WEBSITE;
	}

	public String getTdc() {
		return RSJUG_TDC;
	}

}
