package permisos.clases;

public class AppPermisos {
	private String modulo;
	private String vista;
	private String vistaLink;

	public AppPermisos() {
	}
	
	public AppPermisos(String modulo, String vista, String vistaLink) {
		this.modulo = modulo;
		this.vista = vista;
		this.vistaLink = vistaLink;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getVista() {
		return vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}

	public String getVistaLink() {
		return vistaLink;
	}

	public void setVistaLink(String vistaLink) {
		this.vistaLink = vistaLink;
	}
		
	@Override
	public String toString() {
		return "{"+getModulo()+","+getVista()+","+getVistaLink()+"}";
	}
	
}
