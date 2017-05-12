package org.rsjug.telegram.bot;

public class RsJugBot {

	//Commands
	public static final String COMMAND_SITE = "site";
	public static final String COMMAND_FB = "fb";
	public static final String COMMAND_TWITTER = "twitter";
	
	//Defaults
	private static final String RSJUG_WEBSITE = "http://www.rsjug.org";

	public String getWebSite() {
		return RSJUG_WEBSITE;
	}

	public String execute(String cmd) {
		
		if(cmd!= null)
			cmd = cmd.toLowerCase().trim();

		if (cmd.contains("/start")) {
			return "Opções: \n site \n fb \n twitter"; 
		}
		
		if (cmd.contains(COMMAND_SITE)) {
			return getWebSite();
		}
		
		if (cmd.contains(COMMAND_FB)) {
			return "http://fb.com/groups/rsjug";
		}

		if (cmd.contains(COMMAND_TWITTER)) {
			return "http://twitter.com/rsjug";
		}

		return null;
	}

}
