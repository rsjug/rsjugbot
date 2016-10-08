package org.rsjug.telegram.bot;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.rsjug.telegram.bot.RsJugBot;

public class RsJugBotTest {

	private static final String RSJUG_WEBSITE = "http://www.rsjug.org";
	private RsJugBot rsbot = new RsJugBot();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deveRetornarSiteRSJUG() {
		assertEquals(RSJUG_WEBSITE, rsbot.getWebSite());
	}
	
	@Test
	public void retornaOSiteQuandoEscreve_SITE() {
		assertEquals(RSJUG_WEBSITE, rsbot.execute(RsJugBot.COMMAND_SITE));
		assertEquals(RSJUG_WEBSITE, rsbot.execute("sIte"));
		assertEquals(RSJUG_WEBSITE, rsbot.execute("  site  "));
	}
	
	@Test
	public void retornaStringVaziaCaseNaoExistaOComando() {
		assertNull(rsbot.execute("outrocomando"));
	}

}
