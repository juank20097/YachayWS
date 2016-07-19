package yachayws.model.manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import yachayws.model.entidades.GenCatalogoCab;
import yachayws.model.entidades.GenCatalogoItemsDet;
import yachayws.model.entidades.GenExterno;
import yachayws.model.entidades.GenParametro;
import yachayws.model.entidades.GenPersona;
import yachayws.model.entidades.GenPersonaDetalle;
import yachayws.model.entidades.GenSalud;
import yachayws.model.entidades.Respuesta;
import yachayws.model.extra.PersonaExterno;
import yachayws.model.extra.PersonaSCV;

@Stateless
public class ManagerServicios {

	@EJB
	private ManagerDAO mngDAO;

	public ManagerServicios() {
	}

	// Manejo de PERSONAS

	/**
	 * Metodo para encontrar todos los datos de una entidad
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GenPersona> findAllPersonas() {
		return mngDAO.findAll(GenPersona.class);
	}

	/**
	 * Metodo para encontrar a un dato por su id
	 * 
	 * @param id
	 * @return
	 */
	public List<GenPersona> findPersonaByCampo(String info, String campo) {
		try {
			List<GenPersona> p = new ArrayList<GenPersona>();
			if (campo.equals("nombre")) {
				p = findGenPersonaByNombre(info);
			} else if (campo.equals("apellido")) {
				p = findGenPersonaByApellido(info);
			}
			return p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Metodo para encontrar a un dato por su id
	 * 
	 * @param id
	 * @return
	 */
	public GenPersona findPersonaByID(String id) {
		try {
			return (GenPersona) mngDAO.findById(GenPersona.class, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// Manejo de GENPARAMETROS

	/**
	 * Metodo para encontrar todos los datos de una entidad
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GenParametro> findAllParametros() {
		return mngDAO.findAll(GenParametro.class);
	}

	/**
	 * Metodo para encontrar a un dato por su id
	 * 
	 * @param id
	 * @return
	 */
	public GenParametro findParametroByID(String id) {
		try {
			return (GenParametro) mngDAO.findById(GenParametro.class, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void insertPara(String id, String nombre, String descripcion,
			String valor, String padre, String estado) {
		try {
			GenParametro p = new GenParametro();
			p.setParId(id);
			p.setParDescripcion(descripcion);
			p.setParEstado(estado);
			p.setParNombre(nombre);
			p.setParPadre(padre);
			p.setParValor(valor);
			mngDAO.insertar(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertPara(GenParametro p) throws Exception {
		mngDAO.insertar(p);
	}

	public void eliminarPara(Respuesta r) throws Exception {
		mngDAO.eliminar(GenParametro.class, r.getRespuesta().toString());

	}

	// Manejo de Catalogo

	/**
	 * Metodo para encontrar todos los datos de una entidad
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GenCatalogoCab> findAllCatalogo() {
		return mngDAO.findAll(GenCatalogoCab.class);
	}

	/**
	 * Metodo para encontrar a un dato por su id
	 * 
	 * @param id
	 * @return
	 */
	public GenCatalogoCab findCatalogoByID(String id) {
		try {
			return (GenCatalogoCab) mngDAO.findById(GenCatalogoCab.class, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String NombreItemXId(String id) {
		try {
			GenCatalogoItemsDet ci = (GenCatalogoItemsDet) mngDAO.findById(
					GenCatalogoItemsDet.class, id);
			if (ci != null) {
				return ci.getIteNombre();
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// Manejo de PERSONAS CSV

	/**
	 * Metodo para ingresar o modificar una PersonaCSV
	 * 
	 * @param p
	 * @throws Exception
	 */
	public void ingresarModificarPersona(PersonaSCV p) throws Exception {
		ingresarModificarGenPersona(p);
		ingresarModificarGenDetallePersona(p);
		ingresarModificarGenSalud(p);
	}

	/**
	 * Metodo para ingresar o modificar GenPersona
	 * 
	 * @param p
	 * @throws Exception
	 */
	private void ingresarModificarGenPersona(PersonaSCV p) throws Exception {
		GenPersona genPer = findGenPersonaByDNI(p.getPerDni());
		if (genPer == null) {
			genPer = new GenPersona();
			genPer.setPerDni(p.getPerDni());
			if (p.getPerApellidos() != null || !p.getPerApellidos().isEmpty())
				genPer.setPerApellidos(p.getPerApellidos().toUpperCase());
			if (p.getPerCelular() != null || !p.getPerCelular().isEmpty())
				genPer.setPerCelular(p.getPerCelular());
			if (p.getPerCorreo() != null || !p.getPerCorreo().isEmpty())
				genPer.setPerCorreo(p.getPerCorreo().toLowerCase());
			if (p.getPerFechaNacimiento() != null)
				genPer.setPerFechaNacimiento(sumarRestarDiasFecha(
						p.getPerFechaNacimiento(), 1));
			if (p.getPerGenero() != null || !p.getPerGenero().isEmpty())
				genPer.setPerGenero(p.getPerGenero());
			if (p.getPerNombres() != null || !p.getPerNombres().isEmpty())
				genPer.setPerNombres(p.getPerNombres().toUpperCase());
			if (p.getPerTelefono() != null || !p.getPerTelefono().isEmpty())
				genPer.setPerTelefono(p.getPerTelefono());
			if (p.getPerTipoDni() != null || !p.getPerTipoDni().isEmpty())
				genPer.setPerTipoDni(p.getPerTipoDni());
			if (p.getPerEstadoCivil() != null
					|| !p.getPerEstadoCivil().isEmpty())
				genPer.setPerEstadoCivil(p.getPerEstadoCivil());
			mngDAO.insertar(genPer);
		} else {
			if (p.getPerApellidos() != null)
				genPer.setPerApellidos(p.getPerApellidos().toUpperCase());
			if (p.getPerCelular() != null)
				genPer.setPerCelular(p.getPerCelular());
			if (p.getPerCorreo() != null)
				genPer.setPerCorreo(p.getPerCorreo().toLowerCase());
			if (p.getPerFechaNacimiento() != null)
				genPer.setPerFechaNacimiento(sumarRestarDiasFecha(
						p.getPerFechaNacimiento(), 1));
			if (p.getPerGenero() != null)
				genPer.setPerGenero(p.getPerGenero());
			if (p.getPerNombres() != null)
				genPer.setPerNombres(p.getPerNombres().toUpperCase());
			if (p.getPerTelefono() != null)
				genPer.setPerTelefono(p.getPerTelefono());
			if (p.getPerTipoDni() != null)
				genPer.setPerTipoDni(p.getPerTipoDni());
			if (p.getPerEstadoCivil() != null)
				genPer.setPerEstadoCivil(p.getPerEstadoCivil());
			mngDAO.actualizar(genPer);
		}
	}

	/**
	 * Método para sumar y restar dias a una fecha
	 * 
	 * @param fecha
	 * @param dias
	 * @return
	 */
	public Date sumarRestarDiasFecha(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o
													// restar en caso de días<0
		return calendar.getTime(); // Devuelve el objeto Date con los nuevos
									// días añadidos
	}

	/**
	 * Metodo para ingresar o modificar GenSalud
	 * 
	 * @param p
	 * @throws Exception
	 */
	private void ingresarModificarGenSalud(PersonaSCV p) throws Exception {
		GenSalud d = findGenSaludByPerDNI(p.getPerDni());
		if (d == null) {
			d = new GenSalud();
			d.setPerDni(p.getPerDni());
			if (p.getSldAlergias() != null)
				d.setSldAlergias(p.getSldAlergias().toUpperCase());
			if (p.getSldRealizaEjercicio() != null)
				d.setSldRealizaEjercicio(p.getSldRealizaEjercicio());
			if (p.getSldVegetariano() != null)
				d.setSldVegetariano(p.getSldVegetariano());
			if (p.getSldAltura() != null)
				d.setSldAltura(p.getSldAltura());
			if (p.getSldAsegurado() != null)
				d.setSldAsegurado(p.getSldAsegurado().toUpperCase());
			if (p.getSldConsumeAlcohol() != null)
				d.setSldConsumeAlcohol(p.getSldConsumeAlcohol().toUpperCase());
			if (p.getSldConsumeTabaco() != null)
				d.setSldConsumeTabaco(p.getSldConsumeTabaco().toUpperCase());
			if (p.getSldGrupoSanguineo() != null)
				d.setSldGrupoSanguineo(p.getSldGrupoSanguineo().toUpperCase());
			if (p.getSldCarnetConadies() != null)
				d.setSldCarnetConadies(p.getSldCarnetConadies().toUpperCase());
			if (p.getSldDiscapacidadGrado() != null)
				d.setSldDiscapacidadGrado(p.getSldDiscapacidadGrado().toUpperCase());
			if (p.getSldDiscapacidadTipo() != null)
				d.setSldDiscapacidadTipo(p.getSldDiscapacidadTipo().toUpperCase());
			if (p.getSldPeso() != null)
				d.setSldPeso(p.getSldPeso());
			if (p.getSldPresion() != null)
				d.setSldPresion(p.getSldPresion().toUpperCase());
			if (p.getSldNivelAzucar() != null)
				d.setSldNivelAzucar(p.getSldNivelAzucar().toUpperCase());
			if (p.getSldRealizaEjercicio() != null)
				d.setSldRealizaEjercicio(p.getSldRealizaEjercicio());
			if (p.getSldPeriodicidadEjercicio() != null)
				d.setSldPeriodicidadEjercicio(p.getSldPeriodicidadEjercicio().toUpperCase());
			if (p.getSldMedicamentos() != null)
				d.setSldMedicamentos(p.getSldMedicamentos().toUpperCase());
			if (p.getSldFrecuenciaConsumoMedicame() != null)
				d.setSldFrecuenciaConsumoMedicame(p
						.getSldFrecuenciaConsumoMedicame().toUpperCase());
			mngDAO.insertar(d);
		} else {
			if (p.getSldAlergias() != null)
				d.setSldAlergias(p.getSldAlergias().toUpperCase());
			if (p.getSldRealizaEjercicio() != null)
				d.setSldRealizaEjercicio(p.getSldRealizaEjercicio());
			if (p.getSldVegetariano() != null)
				d.setSldVegetariano(p.getSldVegetariano());
			if (p.getSldAltura() != null)
				d.setSldAltura(p.getSldAltura());
			if (p.getSldAsegurado() != null)
				d.setSldAsegurado(p.getSldAsegurado().toUpperCase());
			if (p.getSldConsumeAlcohol() != null)
				d.setSldConsumeAlcohol(p.getSldConsumeAlcohol().toUpperCase());
			if (p.getSldConsumeTabaco() != null)
				d.setSldConsumeTabaco(p.getSldConsumeTabaco().toUpperCase());
			if (p.getSldGrupoSanguineo() != null)
				d.setSldGrupoSanguineo(p.getSldGrupoSanguineo().toUpperCase());
			if (p.getSldCarnetConadies() != null)
				d.setSldCarnetConadies(p.getSldCarnetConadies().toUpperCase());
			if (p.getSldDiscapacidadGrado() != null)
				d.setSldDiscapacidadGrado(p.getSldDiscapacidadGrado().toUpperCase());
			if (p.getSldDiscapacidadTipo() != null)
				d.setSldDiscapacidadTipo(p.getSldDiscapacidadTipo().toUpperCase());
			if (p.getSldPeso() != null)
				d.setSldPeso(p.getSldPeso());
			if (p.getSldPresion() != null)
				d.setSldPresion(p.getSldPresion().toUpperCase());
			if (p.getSldNivelAzucar() != null)
				d.setSldNivelAzucar(p.getSldNivelAzucar().toUpperCase());
			if (p.getSldRealizaEjercicio() != null)
				d.setSldRealizaEjercicio(p.getSldRealizaEjercicio());
			if (p.getSldPeriodicidadEjercicio() != null)
				d.setSldPeriodicidadEjercicio(p.getSldPeriodicidadEjercicio().toUpperCase());
			if (p.getSldMedicamentos() != null)
				d.setSldMedicamentos(p.getSldMedicamentos().toUpperCase());
			if (p.getSldFrecuenciaConsumoMedicame() != null)
				d.setSldFrecuenciaConsumoMedicame(p
						.getSldFrecuenciaConsumoMedicame().toUpperCase());
			mngDAO.actualizar(d);
		}
	}

	/**
	 * Metodo para ingresar o modificar GenDetallePersona
	 * 
	 * @param p
	 * @throws Exception
	 */
	private void ingresarModificarGenDetallePersona(PersonaSCV p)
			throws Exception {
		GenPersonaDetalle pd = findGenPersonaDetalleByDNI(p.getPerDni());
		if (pd == null) {
			pd = new GenPersonaDetalle();
			pd.setPdeDni(p.getPerDni());
			if (p.getPdePaisNacimiento() != null)
				pd.setPdePaisNacimiento(p.getPdePaisNacimiento());
			if (p.getPdeProvinciaNacimiento() != null)
				pd.setPdeProvinciaNacimiento(p.getPdeProvinciaNacimiento());
			if (p.getPdeCiudadNacimiento() != null)
				pd.setPdeCiudadNacimiento(p.getPdeCiudadNacimiento());
			if (p.getPdeLugarNacimiento() != null)
				pd.setPdeLugarNacimiento(p.getPdeLugarNacimiento().toUpperCase());
			if (p.getPdePaisResidencia() != null)
				pd.setPdePaisResidencia(p.getPdePaisResidencia());
			if (p.getPdeProvinciaResidencia() != null)
				pd.setPdeProvinciaResidencia(p.getPdeProvinciaResidencia());
			if (p.getPdeCiudadResidencia() != null)
				pd.setPdeCiudadResidencia(p.getPdeCiudadResidencia());
			if (p.getPdeDireccion() != null)
				pd.setPdeDireccion(p.getPdeDireccion().toUpperCase());
			if (p.getPdeCondicionCiudadana() != null)
				pd.setPdeCondicionCiudadana(p.getPdeCondicionCiudadana().toUpperCase());
			if (p.getPdeConyuge() != null)
				pd.setPdeConyuge(p.getPdeConyuge().toUpperCase());
			if (p.getPdeNombrePadre() != null)
				pd.setPdeNombrePadre(p.getPdeNombrePadre().toUpperCase());
			if (p.getPdeNacionalidadPadre() != null)
				pd.setPdeNacionalidadPadre(p.getPdeNacionalidadPadre());
			if (p.getPdeNombreMadre() != null)
				pd.setPdeNombreMadre(p.getPdeNombreMadre().toUpperCase());
			if (p.getPdeNacionalidadMadre() != null)
				pd.setPdeNacionalidadMadre(p.getPdeNacionalidadMadre());
			if (p.getPdeNumHijos() != null)
				pd.setPdeNumHijos(p.getPdeNumHijos());
			if (p.getPdeFechaMatrimonio() != null)
				pd.setPdeFechaMatrimonio(sumarRestarDiasFecha(
						p.getPdeFechaMatrimonio(), 1));
			if (p.getPdeInscripcionDefuncion() != null)
				pd.setPdeInscripcionDefuncion(p.getPdeInscripcionDefuncion().toUpperCase());
			if (p.getPdeFechaDefuncion() != null)
				pd.setPdeFechaDefuncion(sumarRestarDiasFecha(
						p.getPdeFechaDefuncion(), 1));
			if (p.getPdeObservacion() != null)
				pd.setPdeObservacion(p.getPdeObservacion().toUpperCase());
			if (p.getPdeEmergContactoId() != null)
				pd.setPdeEmergContactoId(p.getPdeEmergContactoId());
			if (p.getPdeEmergContactoTelefono() != null)
				pd.setPdeEmergContactoTelefono(p.getPdeEmergContactoTelefono());
			if (p.getPdeEmergContactoNombres() != null)
				pd.setPdeEmergContactoNombres(p.getPdeEmergContactoNombres().toUpperCase());
			mngDAO.insertar(pd);
		} else {
			if (p.getPdePaisNacimiento() != null)
				pd.setPdePaisNacimiento(p.getPdePaisNacimiento());
			if (p.getPdeProvinciaNacimiento() != null)
				pd.setPdeProvinciaNacimiento(p.getPdeProvinciaNacimiento());
			if (p.getPdeCiudadNacimiento() != null)
				pd.setPdeCiudadNacimiento(p.getPdeCiudadNacimiento());
			if (p.getPdeLugarNacimiento() != null)
				pd.setPdeLugarNacimiento(p.getPdeLugarNacimiento().toUpperCase());
			if (p.getPdePaisResidencia() != null)
				pd.setPdePaisResidencia(p.getPdePaisResidencia());
			if (p.getPdeProvinciaResidencia() != null)
				pd.setPdeProvinciaResidencia(p.getPdeProvinciaResidencia());
			if (p.getPdeCiudadResidencia() != null)
				pd.setPdeCiudadResidencia(p.getPdeCiudadResidencia());
			if (p.getPdeDireccion() != null)
				pd.setPdeDireccion(p.getPdeDireccion().toUpperCase());
			if (p.getPdeCondicionCiudadana() != null)
				pd.setPdeCondicionCiudadana(p.getPdeCondicionCiudadana().toUpperCase());
			if (p.getPdeConyuge() != null)
				pd.setPdeConyuge(p.getPdeConyuge().toUpperCase());
			if (p.getPdeNombrePadre() != null)
				pd.setPdeNombrePadre(p.getPdeNombrePadre().toUpperCase());
			if (p.getPdeNacionalidadPadre() != null)
				pd.setPdeNacionalidadPadre(p.getPdeNacionalidadPadre());
			if (p.getPdeNombreMadre() != null)
				pd.setPdeNombreMadre(p.getPdeNombreMadre().toUpperCase());
			if (p.getPdeNacionalidadMadre() != null)
				pd.setPdeNacionalidadMadre(p.getPdeNacionalidadMadre());
			if (p.getPdeNumHijos() != null)
				pd.setPdeNumHijos(p.getPdeNumHijos());
			if (p.getPdeFechaMatrimonio() != null)
				pd.setPdeFechaMatrimonio(sumarRestarDiasFecha(
						p.getPdeFechaMatrimonio(), 1));
			if (p.getPdeInscripcionDefuncion() != null)
				pd.setPdeInscripcionDefuncion(p.getPdeInscripcionDefuncion().toUpperCase());
			if (p.getPdeFechaDefuncion() != null)
				pd.setPdeFechaDefuncion(sumarRestarDiasFecha(
						p.getPdeFechaDefuncion(), 1));
			if (p.getPdeObservacion() != null)
				pd.setPdeObservacion(p.getPdeObservacion().toUpperCase());
			if (p.getPdeEmergContactoId() != null)
				pd.setPdeEmergContactoId(p.getPdeEmergContactoId());
			if (p.getPdeEmergContactoTelefono() != null)
				pd.setPdeEmergContactoTelefono(p.getPdeEmergContactoTelefono());
			if (p.getPdeEmergContactoNombres() != null)
				pd.setPdeEmergContactoNombres(p.getPdeEmergContactoNombres().toUpperCase());
			mngDAO.actualizar(pd);
		}
	}

	/**
	 * Metodo para encontrar una Persona CSV
	 * 
	 * @param perDni
	 * @return
	 */
	public PersonaSCV findPersonaSCVByDNI(String perDni) {
		try {
			GenPersona genPer = findGenPersonaByDNI(perDni);
			GenPersonaDetalle pd = findGenPersonaDetalleByDNI(genPer
					.getPerDni());
			PersonaSCV persona = new PersonaSCV();
			persona.setPerDni(genPer.getPerDni());
			persona.setPerApellidos(genPer.getPerApellidos().toUpperCase());
			persona.setPerCelular(genPer.getPerCelular());
			persona.setPerCorreo(genPer.getPerCorreo().toLowerCase());
			persona.setPerFechaNacimiento(genPer.getPerFechaNacimiento());
			persona.setPerGenero(genPer.getPerGenero());
			persona.setPerNombres(genPer.getPerNombres().toUpperCase());
			persona.setPerTelefono(genPer.getPerTelefono());
			persona.setPdeDireccion(pd.getPdeDireccion().toUpperCase());
			persona.setPdePaisNacimiento(pd.getPdePaisNacimiento());
			GenSalud discapacidad = findGenSaludByPerDNI(perDni);
			if (discapacidad != null) {
				persona.setSldDiscapacidadTipo(discapacidad
						.getSldDiscapacidadTipo().toUpperCase());
				persona.setSldDiscapacidadGrado(discapacidad
						.getSldDiscapacidadGrado().toUpperCase());
				persona.setSldCarnetConadies(discapacidad
						.getSldCarnetConadies().toUpperCase());
			}
			return persona;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// Manejo de PERSONAS-EXTERNO

	/**
	 * Metodo para ingresar o modificar una PersonaExterna
	 * 
	 * @param p
	 * @throws Exception
	 */
	public void ingresarModificarPersonaExterna(PersonaExterno p)
			throws Exception {
		ingresarModificarGenPersona(p);
		ingresarModificarGenDetallePersona(p);
		ingresarModificarExterno(p);

	}

	/**
	 * Metodo para ingresar o modificar PersonaExterno
	 * 
	 * @param p
	 * @throws Exception
	 */
	private void ingresarModificarGenPersona(PersonaExterno p) throws Exception {
		GenPersona genPer = findGenPersonaByDNI(p.getPerDni());
		if (genPer == null) {
			genPer = new GenPersona();
			genPer.setPerDni(p.getPerDni());
			if (p.getPerApellidos() != null)
				genPer.setPerApellidos(p.getPerApellidos().toUpperCase());
			if (p.getPerCelular() != null)
				genPer.setPerCelular(p.getPerCelular());
			if (p.getPerCorreo() != null)
				genPer.setPerCorreo(p.getPerCorreo().toLowerCase());
			if (p.getPerFechaNacimiento() != null)
				genPer.setPerFechaNacimiento(sumarRestarDiasFecha(
						p.getPerFechaNacimiento(), 1));
			if (p.getPerGenero() != null)
				genPer.setPerGenero(p.getPerGenero());
			if (p.getPerNombres() != null)
				genPer.setPerNombres(p.getPerNombres().toUpperCase());
			if (p.getPerTelefono() != null)
				genPer.setPerTelefono(p.getPerTelefono());
			if (p.getPerTipoDni() != null)
				genPer.setPerTipoDni(p.getPerTipoDni());
			if (p.getPerEstadoCivil() != null)
				genPer.setPerEstadoCivil(p.getPerEstadoCivil());
			mngDAO.insertar(genPer);
		} else {
			if (p.getPerApellidos() != null)
				genPer.setPerApellidos(p.getPerApellidos().toUpperCase());
			if (p.getPerCelular() != null)
				genPer.setPerCelular(p.getPerCelular());
			if (p.getPerCorreo() != null)
				genPer.setPerCorreo(p.getPerCorreo().toLowerCase());
			if (p.getPerFechaNacimiento() != null)
				genPer.setPerFechaNacimiento(sumarRestarDiasFecha(
						p.getPerFechaNacimiento(), 1));
			if (p.getPerGenero() != null)
				genPer.setPerGenero(p.getPerGenero());
			if (p.getPerNombres() != null)
				genPer.setPerNombres(p.getPerNombres().toUpperCase());
			if (p.getPerTelefono() != null)
				genPer.setPerTelefono(p.getPerTelefono());
			if (p.getPerTipoDni() != null)
				genPer.setPerTipoDni(p.getPerTipoDni());
			if (p.getPerEstadoCivil() != null)
				genPer.setPerEstadoCivil(p.getPerEstadoCivil());
			mngDAO.actualizar(genPer);
		}
	}

	/**
	 * Metodo para ingresar o modificar GenDetallePersona
	 * 
	 * @param p
	 * @throws Exception
	 */
	private void ingresarModificarGenDetallePersona(PersonaExterno p)
			throws Exception {
		GenPersonaDetalle pd = findGenPersonaDetalleByDNI(p.getPerDni());
		if (pd == null) {
			pd = new GenPersonaDetalle();
			pd.setPdeDni(p.getPerDni());
			if (p.getPdePaisNacimiento() != null)
				pd.setPdePaisNacimiento(p.getPdePaisNacimiento());
			if (p.getPdeProvinciaNacimiento() != null)
				pd.setPdeProvinciaNacimiento(p.getPdeProvinciaNacimiento());
			if (p.getPdeProvinciaNacimiento() != null)
				pd.setPdeCiudadNacimiento(p.getPdeProvinciaNacimiento());
			if (p.getPdeLugarNacimiento() != null)
				pd.setPdeLugarNacimiento(p.getPdeLugarNacimiento().toUpperCase());
			if (p.getPdePaisResidencia() != null)
				pd.setPdePaisResidencia(p.getPdePaisResidencia());
			if (p.getPdeProvinciaResidencia() != null)
				pd.setPdeProvinciaResidencia(p.getPdeProvinciaResidencia());
			if (p.getPdeCiudadResidencia() != null)
				pd.setPdeCiudadResidencia(p.getPdeCiudadResidencia());
			if (p.getPdeDireccion() != null)
				pd.setPdeDireccion(p.getPdeDireccion().toUpperCase());
			if (p.getPdeNumHijos() != null)
				pd.setPdeNumHijos(p.getPdeNumHijos());
			if (p.getPdeCondicionCiudadana() != null)
				pd.setPdeCondicionCiudadana(p.getPdeCondicionCiudadana().toUpperCase());
			if (p.getPdeConyuge() != null)
				pd.setPdeConyuge(p.getPdeConyuge().toUpperCase());
			if (p.getPdeNombrePadre() != null)
				pd.setPdeNombrePadre(p.getPdeNombrePadre().toUpperCase());
			if (p.getPdeNacionalidadPadre() != null)
				pd.setPdeNacionalidadPadre(p.getPdeNacionalidadPadre());
			if (p.getPdeNombreMadre() != null)
				pd.setPdeNombreMadre(p.getPdeNombreMadre().toUpperCase());
			if (p.getPdeNacionalidadMadre() != null)
				pd.setPdeNacionalidadMadre(p.getPdeNacionalidadMadre());
			if (p.getPdeFechaMatrimonio() != null)
				pd.setPdeFechaMatrimonio(sumarRestarDiasFecha(
						p.getPdeFechaMatrimonio(), 1));
			if (p.getPdeInscripcionDefuncion() != null)
				pd.setPdeInscripcionDefuncion(p.getPdeInscripcionDefuncion().toUpperCase());
			if (p.getPdeFechaDefuncion() != null)
				pd.setPdeFechaDefuncion(sumarRestarDiasFecha(
						p.getPdeFechaDefuncion(), 1));
			if (p.getPdeObservacion() != null)
				pd.setPdeObservacion(p.getPdeObservacion().toUpperCase());
			if (p.getPdeEmergContactoId() != null)
				pd.setPdeEmergContactoId(p.getPdeEmergContactoId());
			if (p.getPdeEmergContactoTelefono() != null)
				pd.setPdeEmergContactoTelefono(p.getPdeEmergContactoTelefono());
			if (p.getPdeEmergContactoNombres() != null)
				pd.setPdeEmergContactoNombres(p.getPdeEmergContactoNombres().toUpperCase());
			mngDAO.insertar(pd);
		} else {
			if (p.getPdePaisNacimiento() != null)
				pd.setPdePaisNacimiento(p.getPdePaisNacimiento());
			if (p.getPdeProvinciaNacimiento() != null)
				pd.setPdeProvinciaNacimiento(p.getPdeProvinciaNacimiento());
			if (p.getPdeProvinciaNacimiento() != null)
				pd.setPdeCiudadNacimiento(p.getPdeProvinciaNacimiento());
			if (p.getPdeLugarNacimiento() != null)
				pd.setPdeLugarNacimiento(p.getPdeLugarNacimiento().toUpperCase());
			if (p.getPdePaisResidencia() != null)
				pd.setPdePaisResidencia(p.getPdePaisResidencia());
			if (p.getPdeProvinciaResidencia() != null)
				pd.setPdeProvinciaResidencia(p.getPdeProvinciaResidencia());
			if (p.getPdeCiudadResidencia() != null)
				pd.setPdeCiudadResidencia(p.getPdeCiudadResidencia());
			if (p.getPdeDireccion() != null)
				pd.setPdeDireccion(p.getPdeDireccion().toUpperCase());
			if (p.getPdeNumHijos() != null)
				pd.setPdeNumHijos(p.getPdeNumHijos());
			if (p.getPdeCondicionCiudadana() != null)
				pd.setPdeCondicionCiudadana(p.getPdeCondicionCiudadana().toUpperCase());
			if (p.getPdeConyuge() != null)
				pd.setPdeConyuge(p.getPdeConyuge().toUpperCase());
			if (p.getPdeNombrePadre() != null)
				pd.setPdeNombrePadre(p.getPdeNombrePadre().toUpperCase());
			if (p.getPdeNacionalidadPadre() != null)
				pd.setPdeNacionalidadPadre(p.getPdeNacionalidadPadre());
			if (p.getPdeNombreMadre() != null)
				pd.setPdeNombreMadre(p.getPdeNombreMadre().toUpperCase());
			if (p.getPdeNacionalidadMadre() != null)
				pd.setPdeNacionalidadMadre(p.getPdeNacionalidadMadre());
			if (p.getPdeFechaMatrimonio() != null)
				pd.setPdeFechaMatrimonio(sumarRestarDiasFecha(
						p.getPdeFechaMatrimonio(), 1));
			if (p.getPdeInscripcionDefuncion() != null)
				pd.setPdeInscripcionDefuncion(p.getPdeInscripcionDefuncion().toUpperCase());
			if (p.getPdeFechaDefuncion() != null)
				pd.setPdeFechaDefuncion(sumarRestarDiasFecha(
						p.getPdeFechaDefuncion(), 1));
			if (p.getPdeObservacion() != null)
				pd.setPdeObservacion(p.getPdeObservacion().toUpperCase());
			if (p.getPdeEmergContactoId() != null)
				pd.setPdeEmergContactoId(p.getPdeEmergContactoId());
			if (p.getPdeEmergContactoTelefono() != null)
				pd.setPdeEmergContactoTelefono(p.getPdeEmergContactoTelefono());
			if (p.getPdeEmergContactoNombres() != null)
				pd.setPdeEmergContactoNombres(p.getPdeEmergContactoNombres().toUpperCase());
			mngDAO.actualizar(pd);
		}
	}

	/**
	 * Metodo para ingresar o modificar PersonaExterno
	 * 
	 * @param p
	 * @throws Exception
	 */
	private void ingresarModificarExterno(PersonaExterno p) throws Exception {
		GenExterno genExt = findGenExternoByDNI(p.getPerDni());
		if (genExt == null) {
			genExt = new GenExterno();
			genExt.setPerDni(p.getPerDni());
			if (p.getExtTipo() != null)
				genExt.setExtTipo(p.getExtTipo().toUpperCase());
			if (p.getExtReferencia() != null)
				genExt.setExtReferencia(p.getExtReferencia().toUpperCase());
			mngDAO.insertar(genExt);
		} else {
			if (p.getExtTipo() != null)
				genExt.setExtTipo(p.getExtTipo().toUpperCase());
			if (p.getExtReferencia() != null)
				genExt.setExtReferencia(p.getExtReferencia().toUpperCase());
			mngDAO.actualizar(genExt);
		}
	}

	// metodos de busqueda

	public GenExterno findGenExternoByDNI(String perDni) throws Exception {
		return (GenExterno) mngDAO.findById(GenExterno.class, perDni);
	}

	public GenPersona findGenPersonaByDNI(String perDni) throws Exception {
		return (GenPersona) mngDAO.findById(GenPersona.class, perDni);
	}

	@SuppressWarnings("unchecked")
	public List<GenPersona> findGenPersonaByNombre(String nombre)
			throws Exception {
		return mngDAO.findWhere(GenPersona.class, "o.perNombres like '%"
				+ nombre + "%'", null);
	}

	@SuppressWarnings("unchecked")
	public List<GenPersona> findGenPersonaByApellido(String apellido)
			throws Exception {
		return mngDAO.findWhere(GenPersona.class, "o.perApellidos like '%"
				+ apellido + "%'", null);
	}

	public GenSalud findGenSaludByPerDNI(String perDni) throws Exception {
		return (GenSalud) mngDAO.findById(GenSalud.class, perDni);
	}

	public GenPersonaDetalle findGenPersonaDetalleByDNI(String perDni)
			throws Exception {
		return (GenPersonaDetalle) mngDAO.findById(GenPersonaDetalle.class,
				perDni);
	}

}
