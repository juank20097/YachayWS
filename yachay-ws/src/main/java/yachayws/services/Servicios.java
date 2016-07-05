package yachayws.services;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import yachayws.model.entidades.GenCatalogoCab;
import yachayws.model.entidades.GenParametro;
import yachayws.model.entidades.GenPersona;
import yachayws.model.entidades.Respuesta;
import yachayws.model.extra.PersonaExterno;
import yachayws.model.extra.PersonaSCV;
import yachayws.model.manager.ManagerServicios;

@Path("/data")
public class Servicios {

	@EJB
	private ManagerServicios m;

	// Creacion de Metodos

	@GET
	@Path("/WSPersonaEntity/all")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response infopersona() {
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods",
						"GET")
				.header("Access-Control-Max-Age", "1209600")
				.entity(m.findAllPersonas()).build();
	}

	@GET
	@Path("/WSPersonaEntity/{dato}={info}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response infopersonaId(@PathParam("info") String info,@PathParam("dato") String dato) {
		if (dato.equals("dni")){
		GenPersona g = m.findPersonaByID(info);
		if (g == null) {
			return Response.status(200)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers",
							"origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Credentials", "true")
					.header("Access-Control-Allow-Methods",
							"GET")
					.header("Access-Control-Max-Age", "1209600").entity("{}")
					.build();
		} else {
			return Response
					.status(200)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers",
							"origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Credentials", "true")
					.header("Access-Control-Allow-Methods",
							"GET")
					.header("Access-Control-Max-Age", "1209600").entity(g)
					.build();
		}
		}else{
			try {
				return Response
						.status(200)
						.header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Headers",
								"origin, content-type, accept, authorization")
						.header("Access-Control-Allow-Credentials", "true")
						.header("Access-Control-Allow-Methods",
								"GET")
						.header("Access-Control-Max-Age", "1209600")
						.entity(m.findPersonaByCampo(info, dato)).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Response.status(200)
						.entity("Sistema devolvio un valor nulo").build();
			}
		}
	}

	@GET
	@Path("/WSParametrosEntity/all")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response infoparametros() {
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods",
						"GET")
				.header("Access-Control-Max-Age", "1209600")
				.entity(m.findAllParametros()).build();
	}

	@GET
	@Path("/WSParametrosEntity/id={id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response infoparametrosId(@PathParam("id") String id) {
		GenParametro g = m.findParametroByID(id);
		if (g == null) {
			return Response.status(200)
					.entity("Sistema devolvio un valor nulo").build();
		} else {
			return Response
					.status(200)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers",
							"origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Credentials", "true")
					.header("Access-Control-Allow-Methods",
							"GET")
					.header("Access-Control-Max-Age", "1209600").entity(g)
					.build();
		}
	}
	
	@GET
	@Path("/WSCatalogoEntity/all")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response infocatalogo() {
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods",
						"GET")
				.header("Access-Control-Max-Age", "1209600")
				.entity(m.findAllCatalogo()).build();
	}

	@GET
	@Path("/WSCatalogoEntity/id={id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response infocatalogoId(@PathParam("id") String id) {
		GenCatalogoCab g = m.findCatalogoByID(id);
		if (g == null) {
			return Response.status(200)
					.entity("Sistema devolvio un valor nulo").build();
		} else {
			return Response
					.status(200)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers",
							"origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Credentials", "true")
					.header("Access-Control-Allow-Methods",
							"GET")
					.header("Access-Control-Max-Age", "1209600").entity(g)
					.build();
		}
	}
	
	@POST
	@Path("/WSPersonaCSV/update")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response ingresarPersonaCSV(final PersonaSCV p) {
		Respuesta r = new Respuesta();
		try {
			m.ingresarModificarPersona(p);
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
				.header("Access-Control-Allow-Methods",
						"POST")
				.header("Access-Control-Max-Age", "1209600").entity(r)
				.build();
	}
	
	@POST
	@Path("/WSPersonaExterno/insert")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response ingresarPersonaExterno(final PersonaExterno p) {
		Respuesta r = new Respuesta();
		try {
			m.ingresarModificarPersonaExterna(p);
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
				.header("Access-Control-Allow-Methods",
						"POST")
				.header("Access-Control-Max-Age", "1209600").entity(r)
				.build();
	}
	
	//metodo de ejemplos de respaldo
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response ingresar2(final GenParametro p) {
		Respuesta r = new Respuesta();
		try {
			m.insertPara(p);
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
				.header("Access-Control-Allow-Methods",
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").entity(r)
				.build();
	}

	@PUT
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response ingresar(final GenParametro p) {
		Respuesta r = new Respuesta();
		try {
			m.insertPara(p);
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
				.header("Access-Control-Allow-Methods",
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").entity(r)
				.build();
	}
	
	@DELETE
	@Path("/eliminar")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response eliminar(final Respuesta ri) {
		Respuesta r = new Respuesta();
		try {
			m.eliminarPara(ri);
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
				.header("Access-Control-Allow-Methods",
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").entity(r)
				.build();
	}
}
