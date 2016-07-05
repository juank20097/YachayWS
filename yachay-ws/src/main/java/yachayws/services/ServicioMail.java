package yachayws.services;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import yachayws.model.entidades.Respuesta;
import yachayws.model.extra.Email;
import yachayws.model.manager.ManagerMail;

@Path("/")
public class ServicioMail {

	@EJB
	private ManagerMail m;

	// Creacion de Metodos

	@POST
	@Path("/email")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response ingresarPersonaCSV(final Email email) {
		Respuesta r = new Respuesta();
		try {
			m.envioMail(email);
			r.setRespuesta("OK");
		} catch (Exception e) {
			e.printStackTrace();
			r.setRespuesta("ERROR: " + e.getMessage());
		}
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "POST")
				.header("Access-Control-Max-Age", "1209600").entity(r).build();
	}
}
