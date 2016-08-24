package permisos.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import permisos.clases.PerPeticion;
import permisos.manager.ManagerPermisos;

@Path("/usuario")
public class WSUsuario {
	
	ManagerPermisos m = new ManagerPermisos();
	
	@GET
	@Path("/{usr}")
	@Produces("text/plain")
	public Response dniByUsuario(@PathParam("usr") String usr){
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods",
						"POST")
				.header("Access-Control-Max-Age", "1209600").entity(m.existeUsuario(usr))
				.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces("text/plain")
	public Response cambiarContrasenia(final PerPeticion p){
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods",
						"POST")
				.header("Access-Control-Max-Age", "1209600").entity(m.cambiarPasswordDeUsuario(p.getUsr(), p.getPwd()))
				.build();
	}
}
