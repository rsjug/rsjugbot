
package org.rsjug.telegram.bot;

// // This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONObject;

public class QnAProxy {


	public String execute(String cmd) {
		
		BotInfo botInfo = new BotInfo();
		if(botInfo.getBotQnASubscription() == null) return null;
		
		
		HttpClient httpclient = HttpClients.createDefault();

		try {
			URIBuilder builder = new URIBuilder(
					"https://westus.api.cognitive.microsoft.com/qnamaker/v2.0/knowledgebases/" + botInfo.getBotQnAKnowledgebaseId() + "/generateAnswer");

			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);
			request.setHeader("Content-Type", "application/json");
			request.setHeader("Ocp-Apim-Subscription-Key", botInfo.getBotQnASubscription());

			// Request body
			String cmdRequest = "{\"question\":\"" + cmd + "\"}";
			StringEntity reqEntity = new StringEntity(cmdRequest);
			request.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				String jsonResponse = EntityUtils.toString(entity);
				JSONObject jsonObject = new JSONObject(jsonResponse);
				//System.out.println(jsonResponse); //TODO cleanup code
				String cmdResponse = jsonObject.getJSONArray("answers").getJSONObject(0).getString("answer");
				if(cmdResponse != null && cmdResponse.startsWith("No good match found")) return null;
				if(cmdResponse != null) { //TODO achar algo não deprecated
					return StringEscapeUtils.unescapeHtml4(cmdResponse);
				}
			}
		} catch (Exception e) {
			// any exception running Q&AMaker will turn into null. Check log later to avoid this. 
			System.out.println(e.getMessage());
		}

		return null;
	}

}
