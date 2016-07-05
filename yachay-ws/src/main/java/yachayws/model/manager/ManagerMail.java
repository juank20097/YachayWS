package yachayws.model.manager;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import yachayws.model.entidades.GenWsMail;
import yachayws.model.extra.Email;
import yachayws.model.extra.WsMailYachay;
import yachayws.model.mail.estructura.Mail;

@Stateless
public class ManagerMail {

	@EJB
	private ManagerDAO mngDAO;

	public ManagerMail() {
	}

	/**
	 * 
	 * @param data
	 * @throws Exception
	 */
	public void envioMail(Email e) throws Exception {
		if (validarEstructura(e)) {
			WsMailYachay serverMail = existeMailActivo(e.getId().trim());
			if (serverMail == null)
				throw new Exception("No existe el usuario de correo enviado.");
			else
				// Mailer.generateAndSendEmail(crearCorreo(data));
				Mail.generateAndSendEmail(e, serverMail);
		} else
			throw new Exception("Estructura inválida.");
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	private boolean validarEstructura(Email e) {
		if (e.getId().trim() == null || e.getPara().trim() == null
				|| e.getAsunto().trim() == null || e.getBody().trim() == null
				|| e.getId().trim().isEmpty() || e.getPara().trim().isEmpty()
				|| e.getAsunto().trim().isEmpty()
				|| e.getBody().trim().isEmpty()
				|| e.getPara().trim().contains(";")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public WsMailYachay existeMailActivo(String id) throws SQLException {
		List<GenWsMail> l_ws = mngDAO.findWhere(GenWsMail.class, "o.maiId='"
				+ id + "' and maiEstado='A'", null);
		if (l_ws != null) {
			GenWsMail g = l_ws.get(0);
			return new WsMailYachay(g.getMaiServer(), g.getMaiUsuario(),
					g.getMailPwdResp());
		} else {
			return null;
		}
	}

}
