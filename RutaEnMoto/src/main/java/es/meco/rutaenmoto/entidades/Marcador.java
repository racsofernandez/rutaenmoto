package es.meco.rutaenmoto.entidades;

public class Marcador {

	/** Nombre de la localización. */
	private String nombre;
	
	/** Posición, latitud de la localización. */
	private Double latitud;

	/** Posición, longitud de la localización. */
	private Double longitud;
	
	/** Indica si se realiza parada o no. */
	private Boolean parada;
	
	/** Indica la posición de la etiqueta en referencia al punto (arriba: +15, abajo: -15). */
	private Integer posicionEtiqueta;
	
	/** Indica si aparece el nombre de la localización en el mapa o no aparece. */
	private boolean mostrarNombre;

	public Marcador() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Marcador(String nombre, Double latitud, Double longitud, Boolean parada,
			Integer posicionEtiqueta, boolean mostrarNombre) {
		super();
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.parada = parada;
		this.posicionEtiqueta = posicionEtiqueta;
		this.mostrarNombre = mostrarNombre;
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
