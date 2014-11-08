package com.santana.easy.monitor.server;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.santana.easy.monitor.esclient.ESClient;
import com.santana.easy.monitor.model.UserLocalization;

@Path("/localization")
public class GetLocalization {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public UserLocalization sayPlainTextHello(@QueryParam("id") String id) {
	  ESClient client = new  ESClient();
	  UserLocalization user = client.getLocalization(id);
	  
      return user;
  }

//  @GET
//  @Produces(MediaType.TEXT_HTML)
 // public String sayHtmlHello(@QueryParam("id") String id) {
	 
//	  ESClient client = new  ESClient();
//	 UserLocalization user = client.getLocalization(id);
	  
 //   return "<html> " + "<title>" + "Hello Jersey" + user.getLat() + "</title>"
  //      + "<body><h1>" + "Hello Jersey" + id + "</body></h1>" + "</html> ";
 // }

  @PUT
  public Response createLocalization(UserLocalization user) {
	  ESClient client = new  ESClient();
	  client.putData(user.getId(), ""+user.getLat(), ""+user.getLon());
	  return Response.status(Status.OK).build();
  }
} 