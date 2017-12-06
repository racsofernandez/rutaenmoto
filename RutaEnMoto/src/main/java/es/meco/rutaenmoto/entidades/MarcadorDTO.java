package es.meco.rutaenmoto.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity(name="marcador")
public class MarcadorDTO implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_ruta", nullable=false)
	private int idRuta;
	
	/** Nombre de la localización. */
	private String nombre;
	
	/** Posición, latitud de la localización. */
	private Double latitud;

	/** Posición, longitud de la localización. */
	private Double longitud;
	
	/** Indica si se realiza parada o no. */
	private Boolean parada;
	
	/** Indica la posición de la etiqueta en referencia al punto (arriba: +15, abajo: -15). */
	@Column(name="posicion_etiqueta", nullable=false)
	private Integer posicionEtiqueta;
	
	/** Indica si aparece el nombre de la localización en el mapa o no aparece. */
	private boolean mostrarNombre;

	public MarcadorDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	public MarcadorDTO(String nombre, Double latitud, Double longitud, Boolean parada,
			Integer posicionEtiqueta, boolean mostrarNombre) {
		super();
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.parada = parada;
		this.posicionEtiqueta = posicionEtiqueta;
		this.mostrarNombre = mostrarNombre;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getIdRuta() {
		return idRuta;
	}



	public void setIdRuta(Long idRuta) {
		this.idRuta = idRuta;
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
	 * @return the latitud
	 */
	public Double getLatitud() {
		return latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	/**
	 * @return the longitud
	 */
	public Double getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return the parada
	 */
	public Boolean isParada() {
		return parada;
	}

	/**
	 * @param parada the parada to set
	 */
	public void setParada(Boolean parada) {
		this.parada = parada;
	}

	/**
	 * @return the posicionEtiqueta
	 */
	public Integer getPosicionEtiqueta() {
		return posicionEtiqueta;
	}

	/**
	 * @param posicionEtiqueta the posicionEtiqueta to set
	 */
	public void setPosicionEtiqueta(Integer posicionEtiqueta) {
		this.posicionEtiqueta = posicionEtiqueta;
	}

	/**
	 * @return the mostrarNombre
	 */
	public boolean isMostrarNombre() {
		return mostrarNombre;
	}

	/**
	 * @param mostrarNombre the mostrarNombre to set
	 */
	public void setMostrarNombre(boolean mostrarNombre) {
		this.mostrarNombre = mostrarNombre;
	}
	
}
