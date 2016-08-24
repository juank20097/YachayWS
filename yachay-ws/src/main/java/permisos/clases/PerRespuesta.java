package permisos.clases;

import java.util.List;

public class PerRespuesta {
	private String mensaje;
	private List<Menu> value;
	private String status;
	
	public PerRespuesta(String mensaje, List<Menu> value, String status) {
		this.mensaje = mensaje;
		this.value = value;
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Menu> getValue() {
		return value;
	}

	public void setValue(List<Menu> value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
