/**
 * Maarcadores para la ruta desde Meco a Cañamares
 * 04/02/2017.
 */

function getMarcadoresRuta() {
	
	var parada_si = true;
	var parada_no = false;
	var labelPosAbajo = 15;
	var labelPosArriba = -15;
	var mostrarNombre = true;
	var ocultarNombre = false;
	

	// Multiple Markers (Start & end destination)
	markers = [
	           ['Meco', 40.5429161,-3.3341463, null, labelPosAbajo, mostrarNombre],
	   		["Guadalajara", 40.621704, -3.158333, parada_no, labelPosAbajo, mostrarNombre],
	   		["Horche", 40.580647, -3.081284, parada_no, labelPosAbajo, mostrarNombre],
	   		["Tendilla", 40.537528, -2.969833, parada_no, labelPosAbajo, mostrarNombre],
	   		["Alhondiga", 40.523633, -2.825294, parada_no, labelPosAbajo, mostrarNombre],
	   		["Auñón", 40.518642, -2.796283, parada_no, labelPosArriba, mostrarNombre],
	   		["Sacedón", 40.483973, -2.735489, parada_no, labelPosAbajo, mostrarNombre],
	   		["Córcoles", 40.482678, -2.660100, parada_no, labelPosArriba, mostrarNombre],
	   		["Alcocer", 40.471383, -2.614052, parada_si, labelPosAbajo, mostrarNombre],
	   		["San Pedro Palmiches", 40.429647, -2.402758, parada_no, labelPosAbajo, mostrarNombre],
	   		["Priego", 40.450840, -2.311196, parada_no, labelPosArriba, mostrarNombre],
	   		["Cañamares", 40.451080, -2.240098, null, labelPosAbajo, mostrarNombre]
	   	]	
	
	return markers;
	
}

function getAlto() {
	alto = 60;
	return alto;
}

function getAncho() {
	ancho = 70;
	return ancho;
}

function getTipoMapa() {
	tipoMapa = "roadmap";
	return tipoMapa;
}