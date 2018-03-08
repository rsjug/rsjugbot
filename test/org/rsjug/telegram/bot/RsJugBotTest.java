package org.rsjug.telegram.bot;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.rsjug.telegram.bot.RsJugBot;

public class RsJugBotTest {

	private RsJugBot rsbot;
	
	@Before
	public void setUp() throws Exception {
		rsbot = new RsJugBot();
	}

	@After
	public void tearDown() throws Exception {
		rsbot = null;
	}
	
	@Test
	public void retornaOSiteQuandoEscreve_SITE() {
		assertEquals(RsJugBot.RSJUG_WEBSITE, rsbot.execute(RsJugBot.COMMAND_SITE));
		assertEquals(RsJugBot.RSJUG_WEBSITE, rsbot.execute("sIte"));
		assertEquals(RsJugBot.RSJUG_WEBSITE, rsbot.execute("  site  "));
	}

	@Test
	public void retornaOTwitterQuandoEscreve_TWITTER() {
		assertEquals(RsJugBot.RSJUG_TWITTER, rsbot.execute(RsJugBot.COMMAND_TWITTER));
		assertEquals(RsJugBot.RSJUG_TWITTER, rsbot.execute("TWiTteR"));
		assertEquals(RsJugBot.RSJUG_TWITTER, rsbot.execute("  twitteR  "));
	}

	@Test
	public void retornaOTwitterQuandoTemTwitterNoTexto() {
		assertTrue(rsbot.execute("rssgss twitter sdsdsds").startsWith(RsJugBot.PARECEQUE_MESSAGE+ RsJugBot.COMMAND_TWITTER));
	}

	@Test
	public void retornaOEMailQuandoTemEmailNoTexto() {
		assertTrue(rsbot.execute("rssgss email sdsdsds").startsWith(RsJugBot.PARECEQUE_MESSAGE+ RsJugBot.COMMAND_EMAIL));
		assertEquals(RsJugBot.RSJUG_EMAIL, rsbot.execute("email"));

	}

	@Test
	public void retornaOFbQuandoEscreve_FB() {
		assertEquals(RsJugBot.RSJUG_FB, rsbot.execute(RsJugBot.COMMAND_FB));
		assertEquals(RsJugBot.RSJUG_FB, rsbot.execute("fB"));
		assertEquals(RsJugBot.RSJUG_FB, rsbot.execute("  Fb  "));
	}

	/* @Test //TODO Melhorar esse teste. Pessoa pode não ter QNAMaker (nova classe com testes referentes a botInfo)
	public void retornaEJBQuandoPerguntaSobreEJB() {
		assertTrue(rsbot.execute("rssgss ejb sdsdsds").startsWith("Enterprise Java Beans"));
	}*/ 
	
	@Test
	public void retornaNullCasoNaoExistaOComando() {
		assertEquals(RsJugBot.NO_COMMAND_AVAILABLE+RsJugBot.START_MESSAGE,rsbot.execute("outrocomando"));
	}

}
