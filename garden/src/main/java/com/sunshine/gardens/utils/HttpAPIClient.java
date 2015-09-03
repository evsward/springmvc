package com.sunshine.gardens.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunshine.gardens.model.Message;

public class HttpAPIClient {
	private final static Log logger = LogFactory.getLog(HttpAPIClient.class);
	HttpClient client = null;

	public HttpAPIClient(String host, int port) {
		client = new HttpClient();
		client.getHostConfiguration().setHost(host, port);
		if(logger.isInfoEnabled()) {
			logger.info("host:" + host +" port:" + port);
		}
	}
	
	public static String sendMsg(String host, int port, String uri, Message message) {
		HttpAPIClient client = new HttpAPIClient(host, port);
		return client.sendMessage(uri, message);
	}

	public String sendMessage(String uri, Message message) {
		try {
			message.doEncode();
			PostMethod method = new PostMethod(uri);
			Map<String, String> params = message.getParams();
			Set<Entry<String, String>> entrySet = params.entrySet();
			for (Entry<String, String> entry : entrySet) {
				method.addParameter(entry.getKey(), entry.getValue());
			}
			int state = client.executeMethod(method);
			if (state != 200) {
				return null;
			}
			return method.getResponseBodyAsString();
		} catch(Exception e) {
			logger.error("send error!", e);
			return null;
		}
	}

}
