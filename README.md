# rsjugbot
Bot para Telegram do RSJUG (@rsjugbot)

# para rodar o bot
* crie um bot no telegram para poder configurar. Olhe o arquivo telegram_sample.properties na pasta src/org/rsjug/telegram/bot para ter uma indicação dos comandos. Você deve gerar um arquivo telegram.properties nesta mesma pasta. 
* O arquivo telegram.properties está no gitignore, para evitar que você carregue para um repositório público uma informação sensível. :P 
* O arquivo para rodar o bot no telegram é o RsJugBotRunner.java.
* Ao falar com o bot é gerado um log no console com o comando digitado e informações de quem está conversando com o bot. O log vai no formato de um arquivo csv (separado por ponto e vírgula) contendo data/hora, usuário, nome, sobrenome, id telegram e texto digitado pelo usuário.
* para gerar um JAR file do projeto Java, existe um build (ANT) rsbotbuild.xml. Se achar legal fazer o build usando maven ou gradle, crie uma issue e participe do projeto.