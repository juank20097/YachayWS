package yachayws.model.entidades;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the gen_externos database table.
 * 
 */
@Entity
@Table(name = "gen_externos")
@NamedQuery(name = "GenExterno.findAll", query = "SELECT g FROM GenExterno g")
@XmlAccessorType(XmlAccessType.FIELD)
public class GenExterno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "per_dni")
	private String perDni;

	@Column(name = "ext_tipo")
	private String extTipo;

	@Column(name = "ext_referencia")
	private String extReferencia;

	// bi-directional one-to-one association to GenPersona
	@ManyToOne
	@JoinColumn(name = "per_dni", insertable = false, updatable = false)
	@XmlTransient
	private GenPersona genPersona;

	public GenExterno() {
	}

	public String getExtReferencia() {
		return extReferencia;
	}

	public void setExtReferencia(String extReferencia) {
		this.extReferencia = extReferencia;
	}

	public String getPerDni() {
		return this.perDni;
	}

	public void setPerDni(String perDni) {
		this.perDni = perDni;
	}

	public String getExtTipo() {
		return this.extTipo;
	}

	public void setExtTipo(String extTipo) {
		this.extTipo = extTipo;
	}

	public GenPersona getGenPersona() {
		return this.genPersona;
	}

	public void setGenPersona(GenPersona genPersona) {
		this.genPersona = genPersona;
	}

}