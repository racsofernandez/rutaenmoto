/**
 * Maarcadores para la ruta desde Meco a Sacedón y Jadraque
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
        ['Meco', 40.5429161,-3.3341463, null, labelPosArriba, ocultarNombre],
		["El Gurugú", 40.4526466,-3.3413842, parada_no, labelPosAbajo, mostrarNombre],
		["Anchuelo", 40.465844, -3.269406, parada_no, labelPosAbajo, mostrarNombre],
		["El Pozo de Guadalajara", 40.493894, -3.182503, parada_no, labelPosArriba, mostrarNombre],
		["Sacedón", 40.483973, -2.735489, parada_no, labelPosAbajo, ocultarNombre],
		["El Paraíso", 40.535266, -2.706873, parada_no, labelPosArriba, ocultarNombre],
		["Gárgoles de Abajo", 40.733919, -2.627488, parada_no, labelPosAbajo, mostrarNombre],
		["Cifuentes", 40.781236, -2.622642, parada_si, labelPosArriba, ocultarNombre],
		["Mesegoso de Tajuña", 40.825407, -2.699206, parada_no, labelPosArriba, mostrarNombre],
		["Mandayona", 40.956504, -2.750214, parada_no, labelPosAbajo, ocultarNombre],
		["Matilla", 40.951475, -2.841527, parada_no, labelPosArriba, ocultarNombre],
		["Jadraque", 40.926090, -2.927051, parada_no, labelPosArriba, ocultarNombre],
		["Miralrío", 40.888228, -2.942863, parada_no, labelPosArriba, mostrarNombre],
        ['Meco', 40.5429161,-3.3341463, null, labelPosArriba]
	]
	
	return markers;
	
}

function getAlto() {
	alto = 100;
	return alto;
}

function getAncho() {
	ancho = 60;
	return ancho;
}

function getTipoMapa() {
	tipoMapa = "roadmap";
	return tipoMapa;
}