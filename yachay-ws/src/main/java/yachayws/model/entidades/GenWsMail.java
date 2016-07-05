package yachayws.model.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gen_ws_mail database table.
 * 
 */
@Entity
@Table(name="gen_ws_mail")
@NamedQuery(name="GenWsMail.findAll", query="SELECT g FROM GenWsMail g")
public class GenWsMail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mai_id")
	private String maiId;

	@Column(name="mai_estado",columnDefinition="bpchar")
	private String maiEstado;

	@Column(name="mai_password")
	private String maiPassword;

	@Column(name="mai_server")
	private String maiServer;

	@Column(name="mai_usuario")
	private String maiUsuario;

	@Column(name="mail_pwd_resp")
	private String mailPwdResp;

	public GenWsMail() {
	}

	public String getMaiId() {
		return this.maiId;
	}

	public void setMaiId(String maiId) {
		this.maiId = maiId;
	}

	public String getMaiEstado() {
		return this.maiEstado;
	}

	public void setMaiEstado(String maiEstado) {
		this.maiEstado = maiEstado;
	}

	public String getMaiPassword() {
		return this.maiPassword;
	}

	public void setMaiPassword(String maiPassword) {
		this.maiPassword = maiPassword;
	}

	public String getMaiServer() {
		return this.maiServer;
	}

	public void setMaiServer(String maiServer) {
		this.maiServer = maiServer;
	}

	public String getMaiUsuario() {
		return this.maiUsuario;
	}

	public void setMaiUsuario(String maiUsuario) {
		this.maiUsuario = maiUsuario;
	}

	public String getMailPwdResp() {
		return this.mailPwdResp;
	}

	public void setMailPwdResp(String mailPwdResp) {
		this.mailPwdResp = mailPwdResp;
	}

}