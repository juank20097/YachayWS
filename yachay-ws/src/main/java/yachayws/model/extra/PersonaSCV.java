package yachayws.model.extra;

import java.math.BigDecimal;
import java.util.Date;

public class PersonaSCV {

	// Atributos de la clase Gen_Persona
	private String perDni;
	private String perApellidos;
	private String perCelular;
	private String perCorreo;
	private String perEstado;
	private String perEstadoCivil;
	private Date perFechaNacimiento;
	private String perGenero;
	private String perNombres;
	private String perTelefono;
	private String perTipoDni;

	// Atributos de la clase Gen_Persona_Detalle
	private String pdeCiudadNacimiento;
	private String pdeCiudadResidencia;
	private String pdeCondicionCiudadana;
	private String pdeConyuge;
	private String pdeDireccion;
	private String pdeEmergContactoId;
	private String pdeEmergContactoNombres;
	private String pdeEmergContactoTelefono;
	private Date pdeFechaDefuncion;
	private Date pdeFechaMatrimonio;
	private String pdeInscripcionDefuncion;
	private String pdeLugarNacimiento;
	private String pdeNacionalidadMadre;
	private String pdeNacionalidadPadre;
	private String pdeNombreMadre;
	private String pdeNombrePadre;
	private String pdeObservacion;
	private String pdePaisNacimiento;
	private String pdePaisResidencia;
	private String pdeProvinciaNacimiento;
	private String pdeProvinciaResidencia;
	private Integer pdeNumHijos;

	// Atributos de Gen_Salud
	private String sldAlergias;
	private BigDecimal sldAltura;
	private String sldAsegurado;
	private String sldCarnetConadies;
	private String sldConsumeAlcohol;
	private String sldConsumeTabaco;
	private String sldDiscapacidadGrado;
	private String sldDiscapacidadTipo;
	private String sldFrecuenciaConsumoMedicame;
	private String sldGrupoSanguineo;
	private String sldMedicamentos;
	private String sldNivelAzucar;
	private String sldPeriodicidadEjercicio;
	private BigDecimal sldPeso;
	private String sldPresion;
	private Boolean sldRealizaEjercicio;
	private Boolean sldVegetariano;

	public PersonaSCV() {
	}

	/**
	 * @return the perDni
	 */
	public String getPerDni() {
		return perDni;
	}

	/**
	 * @param perDni
	 *            the perDni to set
	 */
	public void setPerDni(String perDni) {
		this.perDni = perDni;
	}

	/**
	 * @return the pdeNumHijos
	 */
	public Integer getPdeNumHijos() {
		return pdeNumHijos;
	}

	/**
	 * @param pdeNumHijos
	 *            the pdeNumHijos to set
	 */
	public void setPdeNumHijos(Integer pdeNumHijos) {
		this.pdeNumHijos = pdeNumHijos;
	}

	/**
	 * @return the perApellidos
	 */
	public String getPerApellidos() {
		return perApellidos;
	}

	/**
	 * @param perApellidos
	 *            the perApellidos to set
	 */
	public void setPerApellidos(String perApellidos) {
		this.perApellidos = perApellidos;
	}

	/**
	 * @return the perCelular
	 */
	public String getPerCelular() {
		return perCelular;
	}

	/**
	 * @param perCelular
	 *            the perCelular to set
	 */
	public void setPerCelular(String perCelular) {
		this.perCelular = perCelular;
	}

	/**
	 * @return the perCorreo
	 */
	public String getPerCorreo() {
		return perCorreo;
	}

	/**
	 * @param perCorreo
	 *            the perCorreo to set
	 */
	public void setPerCorreo(String perCorreo) {
		this.perCorreo = perCorreo;
	}

	/**
	 * @return the perEstado
	 */
	public String getPerEstado() {
		return perEstado;
	}

	/**
	 * @param perEstado
	 *            the perEstado to set
	 */
	public void setPerEstado(String perEstado) {
		this.perEstado = perEstado;
	}

	/**
	 * @return the perEstadoCivil
	 */
	public String getPerEstadoCivil() {
		return perEstadoCivil;
	}

	/**
	 * @param perEstadoCivil
	 *            the perEstadoCivil to set
	 */
	public void setPerEstadoCivil(String perEstadoCivil) {
		this.perEstadoCivil = perEstadoCivil;
	}

	/**
	 * @return the perFechaNacimiento
	 */
	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	/**
	 * @param perFechaNacimiento
	 *            the perFechaNacimiento to set
	 */
	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	/**
	 * @return the perGenero
	 */
	public String getPerGenero() {
		return perGenero;
	}

	/**
	 * @param perGenero
	 *            the perGenero to set
	 */
	public void setPerGenero(String perGenero) {
		this.perGenero = perGenero;
	}

	/**
	 * @return the perNombres
	 */
	public String getPerNombres() {
		return perNombres;
	}

	/**
	 * @param perNombres
	 *            the perNombres to set
	 */
	public void setPerNombres(String perNombres) {
		this.perNombres = perNombres;
	}

	/**
	 * @return the perTelefono
	 */
	public String getPerTelefono() {
		return perTelefono;
	}

	/**
	 * @param perTelefono
	 *            the perTelefono to set
	 */
	public void setPerTelefono(String perTelefono) {
		this.perTelefono = perTelefono;
	}

	/**
	 * @return the perTipoDni
	 */
	public String getPerTipoDni() {
		return perTipoDni;
	}

	/**
	 * @param perTipoDni
	 *            the perTipoDni to set
	 */
	public void setPerTipoDni(String perTipoDni) {
		this.perTipoDni = perTipoDni;
	}

	/**
	 * @return the pdeCiudadNacimiento
	 */
	public String getPdeCiudadNacimiento() {
		return pdeCiudadNacimiento;
	}

	/**
	 * @param pdeCiudadNacimiento
	 *            the pdeCiudadNacimiento to set
	 */
	public void setPdeCiudadNacimiento(String pdeCiudadNacimiento) {
		this.pdeCiudadNacimiento = pdeCiudadNacimiento;
	}

	/**
	 * @return the pdeCiudadResidencia
	 */
	public String getPdeCiudadResidencia() {
		return pdeCiudadResidencia;
	}

	/**
	 * @param pdeCiudadResidencia
	 *            the pdeCiudadResidencia to set
	 */
	public void setPdeCiudadResidencia(String pdeCiudadResidencia) {
		this.pdeCiudadResidencia = pdeCiudadResidencia;
	}

	/**
	 * @return the pdeCondicionCiudadana
	 */
	public String getPdeCondicionCiudadana() {
		return pdeCondicionCiudadana;
	}

	/**
	 * @param pdeCondicionCiudadana
	 *            the pdeCondicionCiudadana to set
	 */
	public void setPdeCondicionCiudadana(String pdeCondicionCiudadana) {
		this.pdeCondicionCiudadana = pdeCondicionCiudadana;
	}

	/**
	 * @return the pdeConyuge
	 */
	public String getPdeConyuge() {
		return pdeConyuge;
	}

	/**
	 * @param pdeConyuge
	 *            the pdeConyuge to set
	 */
	public void setPdeConyuge(String pdeConyuge) {
		this.pdeConyuge = pdeConyuge;
	}

	/**
	 * @return the pdeDireccion
	 */
	public String getPdeDireccion() {
		return pdeDireccion;
	}

	/**
	 * @param pdeDireccion
	 *            the pdeDireccion to set
	 */
	public void setPdeDireccion(String pdeDireccion) {
		this.pdeDireccion = pdeDireccion;
	}

	/**
	 * @return the pdeEmergContactoId
	 */
	public String getPdeEmergContactoId() {
		return pdeEmergContactoId;
	}

	/**
	 * @param pdeEmergContactoId
	 *            the pdeEmergContactoId to set
	 */
	public void setPdeEmergContactoId(String pdeEmergContactoId) {
		this.pdeEmergContactoId = pdeEmergContactoId;
	}

	/**
	 * @return the pdeEmergContactoNombres
	 */
	public String getPdeEmergContactoNombres() {
		return pdeEmergContactoNombres;
	}

	/**
	 * @param pdeEmergContactoNombres
	 *            the pdeEmergContactoNombres to set
	 */
	public void setPdeEmergContactoNombres(String pdeEmergContactoNombres) {
		this.pdeEmergContactoNombres = pdeEmergContactoNombres;
	}

	/**
	 * @return the pdeEmergContactoTelefono
	 */
	public String getPdeEmergContactoTelefono() {
		return pdeEmergContactoTelefono;
	}

	/**
	 * @param pdeEmergContactoTelefono
	 *            the pdeEmergContactoTelefono to set
	 */
	public void setPdeEmergContactoTelefono(String pdeEmergContactoTelefono) {
		this.pdeEmergContactoTelefono = pdeEmergContactoTelefono;
	}

	/**
	 * @return the pdeFechaDefuncion
	 */
	public Date getPdeFechaDefuncion() {
		return pdeFechaDefuncion;
	}

	/**
	 * @param pdeFechaDefuncion
	 *            the pdeFechaDefuncion to set
	 */
	public void setPdeFechaDefuncion(Date pdeFechaDefuncion) {
		this.pdeFechaDefuncion = pdeFechaDefuncion;
	}

	/**
	 * @return the pdeFechaMatrimonio
	 */
	public Date getPdeFechaMatrimonio() {
		return pdeFechaMatrimonio;
	}

	/**
	 * @param pdeFechaMatrimonio
	 *            the pdeFechaMatrimonio to set
	 */
	public void setPdeFechaMatrimonio(Date pdeFechaMatrimonio) {
		this.pdeFechaMatrimonio = pdeFechaMatrimonio;
	}

	/**
	 * @return the pdeInscripcionDefuncion
	 */
	public String getPdeInscripcionDefuncion() {
		return pdeInscripcionDefuncion;
	}

	/**
	 * @param pdeInscripcionDefuncion
	 *            the pdeInscripcionDefuncion to set
	 */
	public void setPdeInscripcionDefuncion(String pdeInscripcionDefuncion) {
		this.pdeInscripcionDefuncion = pdeInscripcionDefuncion;
	}

	/**
	 * @return the pdeLugarNacimiento
	 */
	public String getPdeLugarNacimiento() {
		return pdeLugarNacimiento;
	}

	/**
	 * @param pdeLugarNacimiento
	 *            the pdeLugarNacimiento to set
	 */
	public void setPdeLugarNacimiento(String pdeLugarNacimiento) {
		this.pdeLugarNacimiento = pdeLugarNacimiento;
	}

	/**
	 * @return the pdeNacionalidadMadre
	 */
	public String getPdeNacionalidadMadre() {
		return pdeNacionalidadMadre;
	}

	/**
	 * @param pdeNacionalidadMadre
	 *            the pdeNacionalidadMadre to set
	 */
	public void setPdeNacionalidadMadre(String pdeNacionalidadMadre) {
		this.pdeNacionalidadMadre = pdeNacionalidadMadre;
	}

	/**
	 * @return the pdeNacionalidadPadre
	 */
	public String getPdeNacionalidadPadre() {
		return pdeNacionalidadPadre;
	}

	/**
	 * @param pdeNacionalidadPadre
	 *            the pdeNacionalidadPadre to set
	 */
	public void setPdeNacionalidadPadre(String pdeNacionalidadPadre) {
		this.pdeNacionalidadPadre = pdeNacionalidadPadre;
	}

	/**
	 * @return the pdeNombreMadre
	 */
	public String getPdeNombreMadre() {
		return pdeNombreMadre;
	}

	/**
	 * @param pdeNombreMadre
	 *            the pdeNombreMadre to set
	 */
	public void setPdeNombreMadre(String pdeNombreMadre) {
		this.pdeNombreMadre = pdeNombreMadre;
	}

	/**
	 * @return the pdeNombrePadre
	 */
	public String getPdeNombrePadre() {
		return pdeNombrePadre;
	}

	/**
	 * @param pdeNombrePadre
	 *            the pdeNombrePadre to set
	 */
	public void setPdeNombrePadre(String pdeNombrePadre) {
		this.pdeNombrePadre = pdeNombrePadre;
	}

	/**
	 * @return the pdeObservacion
	 */
	public String getPdeObservacion() {
		return pdeObservacion;
	}

	/**
	 * @param pdeObservacion
	 *            the pdeObservacion to set
	 */
	public void setPdeObservacion(String pdeObservacion) {
		this.pdeObservacion = pdeObservacion;
	}

	/**
	 * @return the pdePaisNacimiento
	 */
	public String getPdePaisNacimiento() {
		return pdePaisNacimiento;
	}

	/**
	 * @param pdePaisNacimiento
	 *            the pdePaisNacimiento to set
	 */
	public void setPdePaisNacimiento(String pdePaisNacimiento) {
		this.pdePaisNacimiento = pdePaisNacimiento;
	}

	/**
	 * @return the pdePaisResidencia
	 */
	public String getPdePaisResidencia() {
		return pdePaisResidencia;
	}

	/**
	 * @param pdePaisResidencia
	 *            the pdePaisResidencia to set
	 */
	public void setPdePaisResidencia(String pdePaisResidencia) {
		this.pdePaisResidencia = pdePaisResidencia;
	}

	/**
	 * @return the pdeProvinciaNacimiento
	 */
	public String getPdeProvinciaNacimiento() {
		return pdeProvinciaNacimiento;
	}

	/**
	 * @param pdeProvinciaNacimiento
	 *            the pdeProvinciaNacimiento to set
	 */
	public void setPdeProvinciaNacimiento(String pdeProvinciaNacimiento) {
		this.pdeProvinciaNacimiento = pdeProvinciaNacimiento;
	}

	/**
	 * @return the pdeProvinciaResidencia
	 */
	public String getPdeProvinciaResidencia() {
		return pdeProvinciaResidencia;
	}

	/**
	 * @param pdeProvinciaResidencia
	 *            the pdeProvinciaResidencia to set
	 */
	public void setPdeProvinciaResidencia(String pdeProvinciaResidencia) {
		this.pdeProvinciaResidencia = pdeProvinciaResidencia;
	}

	/**
	 * @return the sldAlergias
	 */
	public String getSldAlergias() {
		return sldAlergias;
	}

	/**
	 * @param sldAlergias
	 *            the sldAlergias to set
	 */
	public void setSldAlergias(String sldAlergias) {
		this.sldAlergias = sldAlergias;
	}

	/**
	 * @return the sldAltura
	 */
	public BigDecimal getSldAltura() {
		return sldAltura;
	}

	/**
	 * @param sldAltura
	 *            the sldAltura to set
	 */
	public void setSldAltura(BigDecimal sldAltura) {
		this.sldAltura = sldAltura;
	}

	/**
	 * @return the sldAsegurado
	 */
	public String getSldAsegurado() {
		return sldAsegurado;
	}

	/**
	 * @param sldAsegurado
	 *            the sldAsegurado to set
	 */
	public void setSldAsegurado(String sldAsegurado) {
		this.sldAsegurado = sldAsegurado;
	}

	/**
	 * @return the sldCarnetConadies
	 */
	public String getSldCarnetConadies() {
		return sldCarnetConadies;
	}

	/**
	 * @param sldCarnetConadies
	 *            the sldCarnetConadies to set
	 */
	public void setSldCarnetConadies(String sldCarnetConadies) {
		this.sldCarnetConadies = sldCarnetConadies;
	}

	/**
	 * @return the sldConsumeAlcohol
	 */
	public String getSldConsumeAlcohol() {
		return sldConsumeAlcohol;
	}

	/**
	 * @param sldConsumeAlcohol
	 *            the sldConsumeAlcohol to set
	 */
	public void setSldConsumeAlcohol(String sldConsumeAlcohol) {
		this.sldConsumeAlcohol = sldConsumeAlcohol;
	}

	/**
	 * @return the sldConsumeTabaco
	 */
	public String getSldConsumeTabaco() {
		return sldConsumeTabaco;
	}

	/**
	 * @param sldConsumeTabaco
	 *            the sldConsumeTabaco to set
	 */
	public void setSldConsumeTabaco(String sldConsumeTabaco) {
		this.sldConsumeTabaco = sldConsumeTabaco;
	}

	/**
	 * @return the sldDiscapacidadGrado
	 */
	public String getSldDiscapacidadGrado() {
		return sldDiscapacidadGrado;
	}

	/**
	 * @param sldDiscapacidadGrado
	 *            the sldDiscapacidadGrado to set
	 */
	public void setSldDiscapacidadGrado(String sldDiscapacidadGrado) {
		this.sldDiscapacidadGrado = sldDiscapacidadGrado;
	}

	/**
	 * @return the sldDiscapacidadTipo
	 */
	public String getSldDiscapacidadTipo() {
		return sldDiscapacidadTipo;
	}

	/**
	 * @param sldDiscapacidadTipo
	 *            the sldDiscapacidadTipo to set
	 */
	public void setSldDiscapacidadTipo(String sldDiscapacidadTipo) {
		this.sldDiscapacidadTipo = sldDiscapacidadTipo;
	}

	/**
	 * @return the sldFrecuenciaConsumoMedicame
	 */
	public String getSldFrecuenciaConsumoMedicame() {
		return sldFrecuenciaConsumoMedicame;
	}

	/**
	 * @param sldFrecuenciaConsumoMedicame
	 *            the sldFrecuenciaConsumoMedicame to set
	 */
	public void setSldFrecuenciaConsumoMedicame(
			String sldFrecuenciaConsumoMedicame) {
		this.sldFrecuenciaConsumoMedicame = sldFrecuenciaConsumoMedicame;
	}

	/**
	 * @return the sldGrupoSanguineo
	 */
	public String getSldGrupoSanguineo() {
		return sldGrupoSanguineo;
	}

	/**
	 * @param sldGrupoSanguineo
	 *            the sldGrupoSanguineo to set
	 */
	public void setSldGrupoSanguineo(String sldGrupoSanguineo) {
		this.sldGrupoSanguineo = sldGrupoSanguineo;
	}

	/**
	 * @return the sldMedicamentos
	 */
	public String getSldMedicamentos() {
		return sldMedicamentos;
	}

	/**
	 * @param sldMedicamentos
	 *            the sldMedicamentos to set
	 */
	public void setSldMedicamentos(String sldMedicamentos) {
		this.sldMedicamentos = sldMedicamentos;
	}

	/**
	 * @return the sldNivelAzucar
	 */
	public String getSldNivelAzucar() {
		return sldNivelAzucar;
	}

	/**
	 * @param sldNivelAzucar
	 *            the sldNivelAzucar to set
	 */
	public void setSldNivelAzucar(String sldNivelAzucar) {
		this.sldNivelAzucar = sldNivelAzucar;
	}

	/**
	 * @return the sldPeriodicidadEjercicio
	 */
	public String getSldPeriodicidadEjercicio() {
		return sldPeriodicidadEjercicio;
	}

	/**
	 * @param sldPeriodicidadEjercicio
	 *            the sldPeriodicidadEjercicio to set
	 */
	public void setSldPeriodicidadEjercicio(String sldPeriodicidadEjercicio) {
		this.sldPeriodicidadEjercicio = sldPeriodicidadEjercicio;
	}

	/**
	 * @return the sldPeso
	 */
	public BigDecimal getSldPeso() {
		return sldPeso;
	}

	/**
	 * @param sldPeso
	 *            the sldPeso to set
	 */
	public void setSldPeso(BigDecimal sldPeso) {
		this.sldPeso = sldPeso;
	}

	/**
	 * @return the sldPresion
	 */
	public String getSldPresion() {
		return sldPresion;
	}

	/**
	 * @param sldPresion
	 *            the sldPresion to set
	 */
	public void setSldPresion(String sldPresion) {
		this.sldPresion = sldPresion;
	}

	/**
	 * @return the sldRealizaEjercicio
	 */
	public Boolean getSldRealizaEjercicio() {
		return sldRealizaEjercicio;
	}

	/**
	 * @param sldRealizaEjercicio
	 *            the sldRealizaEjercicio to set
	 */
	public void setSldRealizaEjercicio(Boolean sldRealizaEjercicio) {
		this.sldRealizaEjercicio = sldRealizaEjercicio;
	}

	/**
	 * @return the sldVegetariano
	 */
	public Boolean getSldVegetariano() {
		return sldVegetariano;
	}

	/**
	 * @param sldVegetariano
	 *            the sldVegetariano to set
	 */
	public void setSldVegetariano(Boolean sldVegetariano) {
		this.sldVegetariano = sldVegetariano;
	}

}
