package es.meco.rutaenmoto.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.meco.rutaenmoto.entidades.MarcadorDTO;
import es.meco.rutaenmoto.entidades.RutaDTO;

@ManagedBean
@SessionScoped
public class RutaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7663251275597406522L;
	private Integer labelPosArriba = -15;
	private Integer labelPosAbajo = 15;
	
	private RutaDTO datosRuta;
	
	public RutaBean() {
		
		List<MarcadorDTO> markers = new ArrayList<MarcadorDTO>();
		markers = new ArrayList<MarcadorDTO>();
		markers.add(new MarcadorDTO("Meco", 40.5429161,-3.3341463, null, labelPosArriba, false));
		markers.add(new MarcadorDTO("El Gurugú", 40.4526466,-3.3413842, false, labelPosAbajo, true));
		markers.add(new MarcadorDTO("Anchuelo", 40.465844, -3.269406, false, labelPosAbajo, true));
		markers.add(new MarcadorDTO("El Pozo de Guadalajara", 40.493894, -3.182503, false, labelPosArriba, true));
		markers.add(new MarcadorDTO("Sacedón", 40.483973, -2.735489, false, labelPosAbajo, false));
		markers.add(new MarcadorDTO("El Paraíso", 40.535266, -2.706873, false, labelPosArriba, false));
		markers.add(new MarcadorDTO("Gárgoles de Abajo", 40.733919, -2.627488, false, labelPosAbajo, true));
		markers.add(new MarcadorDTO("Cifuentes", 40.781236, -2.622642, true, labelPosArriba, false));
		markers.add(new MarcadorDTO("Mesegoso de Tajuña", 40.825407, -2.699206, false, labelPosArriba, true));
		markers.add(new MarcadorDTO("Mandayona", 40.956504, -2.750214, false, labelPosAbajo, false));
		markers.add(new MarcadorDTO("Matilla", 40.951475, -2.841527, false, labelPosArriba, false));
		markers.add(new MarcadorDTO("Jadraque", 40.926090, -2.927051, false, labelPosArriba, false));
		markers.add(new MarcadorDTO("Miralrío", 40.888228, -2.942863, false, labelPosArriba, true));
		markers.add(new MarcadorDTO("Meco", 40.5429161,-3.3341463, null, labelPosArriba, false));

		datosRuta = new RutaDTO();
		
		datosRuta.setMarkers(markers);
		datosRuta.setAlto(100);
		datosRuta.setAncho(60);
		datosRuta.setTipoMapa("roadmap");
		datosRuta.setTitulo("Ruta a Sacedón");
		
	}
	
	public String getTitulo() {
		String ret = "";
		if (datosRuta!=null) {
			ret = datosRuta.getTitulo();
		}
		return ret;
	}
	
	public String getToJson() {
		
		String ret = null;
		if (datosRuta!=null) {
			ret = datosRuta.getToJson();
		}
		return ret;
		
	}
	
	
}
