package com.medina.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.medina.rest.client.retrofit.RetrofitClientMessage;

public class RestApiClient {
	
	public static void main(String args[]) {
		
		// Llamada al WebService usando ClientBuilder
		Client client = ClientBuilder.newClient();
		
		Response response = client.target("http://localhost:8080/jaxrs-messenger/messages/1").request().get();
		
		String out = response.readEntity(String.class);
		System.out.println(out);
		
		JSONObject json = new JSONObject(out);
		System.out.println(json.get("author"));
		
		// Llamada al WebService usando Retrofit2
		//RetrofitClientMessage retrofitClientMessage = new RetrofitClientMessage();
		//retrofitClientMessage.start();
	}

}
