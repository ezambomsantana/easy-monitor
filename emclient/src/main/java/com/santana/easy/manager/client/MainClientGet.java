package com.santana.easy.manager.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.santana.easy.monitor.model.UserLocalization;

public class MainClientGet {

	public static void main(String args[]) {
				
		ClientConfig clientConfig = new ClientConfig();
		
		Client client = ClientBuilder.newClient(clientConfig);
		
		WebTarget webTarget = client.target("http://localhost:8080/emserver");
		
		WebTarget resourceWebTarget = webTarget.path("rest");
		WebTarget helloworldWebTarget = resourceWebTarget.path("localization");
		WebTarget helloworldWebTargetWithQueryParam = helloworldWebTarget.queryParam("id", "a");
				
		
		Invocation.Builder invocationBuilder = helloworldWebTargetWithQueryParam.request(MediaType.APPLICATION_JSON_TYPE);
		
		Response response = invocationBuilder.get();
		
		System.out.println(response.getStatus());
		UserLocalization local = response.readEntity(UserLocalization.class);
		
		System.out.println(local.getId());
		System.out.println(local.getLat());
		System.out.println(local.getLon());
		
	}
	
	
}
