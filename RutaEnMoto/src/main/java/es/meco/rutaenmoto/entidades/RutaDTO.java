package es.meco.rutaenmoto.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import com.google.gson.Gson;

@Entity(name="ruta")
public class RutaDTO implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="idRuta")
	private List<MarcadorDTO> markers;
	
	private Integer alto;
	
	private Integer ancho;

	@Column(name="tipo_mapa", nullable=false)
	private String tipoMapa;
	
	private String titulo;

	public RutaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the markers
	 */
	public List<MarcadorDTO> getMarkers() {
		return markers;
	}

	/**
	 * @param markers the markers to set
	 */
	public void setMarkers(List<MarcadorDTO> markers) {
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

	public String getToJson() {
		Gson gson = new Gson();
		String ret = gson.toJson(this);
		return ret;
		
	}
	
}
