package permisos.clases;

import java.util.List;

public class Menu {
	private String nombre;
	private List<Submenu> vistas;
	
	public Menu() {
	}

	public Menu(String nombre, List<Submenu> vistas) {
		this.nombre = nombre;
		this.vistas = vistas;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the lstLinks
	 */
	public List<Submenu> getVistas() {
		return vistas;
	}

	/**
	 * @param lstLinks the lstLinks to set
	 */
	public void setVistas(List<Submenu> lstLinks) {
		this.vistas = lstLinks;
	}
	
	
}
