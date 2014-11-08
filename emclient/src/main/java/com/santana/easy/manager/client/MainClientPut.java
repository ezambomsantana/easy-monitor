package com.santana.easy.manager.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.santana.easy.monitor.model.UserLocalization;

public class MainClientPut {
	public static void main(String args[]) {
		
		UserLocalization user = new UserLocalization();
		user.setId("b");
		user.setLat("d");
		user.setLon("d");
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target("http://localhost:8080/emserver");
		WebTarget resourceWebTarget = webTarget.path("rest");
		
		WebTarget deleteWeb = resourceWebTarget.path("localization");
	//	WebTarget deleteWebTarget = deleteWeb.path("put");
		Invocation.Builder deleteInvocationBuilder = deleteWeb.request();
		Response putResponse = deleteInvocationBuilder.put(Entity.entity(user, MediaType.APPLICATION_JSON_TYPE));

		System.out.println(putResponse.getStatus());
		System.out.println(putResponse.readEntity(String.class));
		
	}
	
}
