package permisos.manager;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import permisos.clases.*;
import permisos.conection.SingletonJDBC;

public class ManagerPermisos {
	
	private SingletonJDBC conn;
	
	public ManagerPermisos() {
		conn = SingletonJDBC.getInstance();
	}
	
	public PerRespuesta respuestaPermisos(PerPeticion appPeticion){
		try {
			if(!existeUsuario(appPeticion.getUsr(), appPeticion.getPwd()))
				return new PerRespuesta("Usuario y/o contraseña incorrectos.", new ArrayList<Menu>(), "ERROR");
			else{
				List<Menu> lstPermisos = menuPermisosUsuarioAplicacion(appPeticion.getUsr(), appPeticion.getApl());
				if(lstPermisos.isEmpty())
					return new PerRespuesta("No posee permisos para esta aplicación.", new ArrayList<Menu>(), "ERROR");
				else
					return new PerRespuesta("Consulta correcta.", lstPermisos, "OK");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new PerRespuesta(e.getMessage(), new ArrayList<Menu>(), "ERROR");
		}
	}
	
	private boolean existeUsuario(String usuario, String password) throws SQLException{
		ResultSet consulta = conn.consultaSQL("select * from app_usuario where usu_login='"+usuario+"' and usu_password='"+getMD5(password)+"';");
		if(consulta.next())
			return true;
		else
			return false;
	}
	
	private List<Menu> menuPermisosUsuarioAplicacion(String usuario, String aplicacion) throws SQLException {
		List<Menu> menuPermisos = new ArrayList<Menu>();
		List<AppPermisos> lista = consultarPermisos(usuario, aplicacion);
		if(!lista.isEmpty()){
			int contador = 0;
			String modAnt = "";
			Menu menu = new Menu();
			for (AppPermisos p : lista) {
				contador++;
				if(!modAnt.equals(p.getModulo())){
					if(!modAnt.trim().isEmpty())
						menuPermisos.add(menu);
					menu = new Menu(p.getModulo(), new ArrayList<Submenu>());
				}
				menu.getVistas().add(new Submenu(p.getVista(), p.getVistaLink()));
				modAnt = p.getModulo();
				if(contador==lista.size())
					menuPermisos.add(menu);
			}
		}
		return menuPermisos;
	}
	
	private List<AppPermisos> consultarPermisos(String usuario, String aplicacion) throws SQLException{
		List<AppPermisos> resultado = new ArrayList<AppPermisos>();
		StringBuilder sql = new StringBuilder();
		sql.append("select m.mod_nombre as modulo, v.vis_nombre as vista , v.vis_link link ");
		sql.append("from app_aplicaciones a, app_modulos m, app_vistas v, app_permisos p ");
		sql.append("where a.apl_id = m.apl_id and m.mod_id = v.mod_id ");
		sql.append("and p.vis_id=v.vis_id and apl_estado='A' ");
		sql.append("and mod_estado='A' and vis_estado='A' ");
		sql.append("and p.per_estado='A' and p.usu_login='"+usuario+"' and a.apl_id='"+aplicacion+"' ");
		sql.append("order by a.apl_id, m.mod_orden, v.vis_orden;");
		ResultSet consulta = conn.consultaSQL(sql.toString());
		while(consulta.next()){
			resultado.add(new AppPermisos(consulta.getString("modulo"), consulta.getString("vista"), consulta.getString("link")));
		}
		return resultado;
	}
	
	public String cambiarPasswordDeUsuario(String usuario, String password){
		try {
			if(existeUsuario(usuario).equals("ERROR"))
				return "ERROR";
			boolean estado = conn.ejecutarSQL("UPDATE app_usuario SET usu_password='"
					+ getMD5(password) + "', usu_password_text='" + password
					+ "' WHERE usu_login='" + usuario + "';");
			if(!estado)
				return "ERROR";
			return "OK";
		} catch (SQLException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	public String existeUsuario(String usuario){
		try {
			ResultSet consulta = conn.consultaSQL("select * from app_usuario where usu_login='"+usuario+"';");
			if(consulta.next())
				return consulta.getString("per_id");
			else
				return "ERROR";
		} catch (SQLException e) {
			e.printStackTrace();
			return "ERROR";
		}
		
	}
	
	private String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
