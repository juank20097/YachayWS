package permisos.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import permisos.clases.PerPeticion;
import permisos.manager.ManagerPermisos;

@Path("/permisos")
public class WSPermiso {
	
	ManagerPermisos m = new ManagerPermisos();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response permisosAplicacion(final PerPeticion p){
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods",
						"POST")
				.header("Access-Control-Max-Age", "1209600").entity(m.respuestaPermisos(p))
				.build();
	}
}
