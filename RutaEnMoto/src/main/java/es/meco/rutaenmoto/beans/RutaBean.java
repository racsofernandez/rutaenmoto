package es.meco.rutaenmoto.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.meco.rutaenmoto.entidades.Marcador;

@ManagedBean
@SessionScoped
public class RutaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7663251275597406522L;
	private Integer labelPosArriba = -15;
	private Integer labelPosAbajo = 15;
	
	private List<Marcador> markers;
	
	private Integer alto;
	
	private Integer ancho;

	private String tipoMapa;
	
	private String titulo;

	public RutaBean() {
		markers = new ArrayList<Marcador>();
		markers.add(new Marcador("Meco", 40.5429161,-3.3341463, null, labelPosArriba, false));
		markers.add(new Marcador("El Gurugú", 40.4526466,-3.3413842, false, labelPosAbajo, true));
		markers.add(new Marcador("Anchuelo", 40.465844, -3.269406, false, labelPosAbajo, true));
		markers.add(new Marcador("El Pozo de Guadalajara", 40.493894, -3.182503, false, labelPosArriba, true));
		markers.add(new Marcador("Sacedón", 40.483973, -2.735489, false, labelPosAbajo, false));
		markers.add(new Marcador("El Paraíso", 40.535266, -2.706873, false, labelPosArriba, false));
		markers.add(new Marcador("Gárgoles de Abajo", 40.733919, -2.627488, false, labelPosAbajo, true));
		markers.add(new Marcador("Cifuentes", 40.781236, -2.622642, true, labelPosArriba, false));
		markers.add(new Marcador("Mesegoso de Tajuña", 40.825407, -2.699206, false, labelPosArriba, true));
		markers.add(new Marcador("Mandayona", 40.956504, -2.750214, false, labelPosAbajo, false));
		markers.add(new Marcador("Matilla", 40.951475, -2.841527, false, labelPosArriba, false));
		markers.add(new Marcador("Jadraque", 40.926090, -2.927051, false, labelPosArriba, false));
		markers.add(new Marcador("Miralrío", 40.888228, -2.942863, false, labelPosArriba, true));
		markers.add(new Marcador("Meco", 40.5429161,-3.3341463, null, labelPosArriba, false));

		alto = 100;
		ancho = 60;
		tipoMapa = "roadmap";
		titulo = "Ruta a Sacedón";
	}

	public RutaBean getMe() {
		return this;
	}
	
	/**
	 * @return the markers
	 */
	public List<Marcador> getMarkers() {
		return markers;
	}

	/**
	 * @param markers the markers to set
	 */
	public void setMarkers(List<Marcador> markers) {
		this.markers = markers;
	}

	/**
	 * @return the alto
	 */
	public Integer getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(Integer alto) {
		this.alto = alto;
	}

	/**
	 * @return the ancho
	 */
	public Integer getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(Integer ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the tipoMapa
	 */
	public String getTipoMapa() {
		return tipoMapa;
	}

	/**
	 * @param tipoMapa the tipoMapa to set
	 */
	public void setTipoMapa(String tipoMapa) {
		this.tipoMapa = tipoMapa;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	
}
