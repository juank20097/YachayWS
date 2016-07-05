package yachayws.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class Index {
	
	@GET
	public Response imprimirMessage() {
		return Response.status(200).entity("Sistema de Servicios Yachay City Platform").build();
	}
}
