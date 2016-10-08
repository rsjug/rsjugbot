package org.rsjug.telegram.bot;

public class RsJugBot {

	//Commands
	public static final String COMMAND_SITE = "site";
	
	//Defaults
	private static final String RSJUG_WEBSITE = "http://www.rsjug.org";

	public String getWebSite() {
		return RSJUG_WEBSITE;
	}

	public String execute(String cmd) {
		
		if(cmd!= null)
			cmd = cmd.toLowerCase().trim();
		
		if (cmd.equals(COMMAND_SITE)) {
			return getWebSite();
		}
		return null;
	}

}
