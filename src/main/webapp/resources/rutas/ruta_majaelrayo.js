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
	   		["Marchamalo", 40.671646, -3.210297, parada_no, labelPosAbajo, mostrarNombre],
	   		["Razbona", 40.855906, -3.180282, parada_no, labelPosAbajo, mostrarNombre],
	   		["Tamajón", 41.002773, -3.248589, parada_si, labelPosAbajo, mostrarNombre],
	   		["Campillejo", 41.063885, -3.289803, parada_no, labelPosAbajo, mostrarNombre],
	   		["Campillo de Ranas", 41.082767, -3.311797, parada_no, labelPosAbajo, mostrarNombre],
	   		["Majaelrayo", 41.112455, -3.301696, null, labelPosAbajo, mostrarNombre]
	   	]
	
	return markers;
	
}

function getAlto() {
	alto = 100;
	return alto;
}

function getAncho() {
	ancho = 30;
	return ancho;
}

function getTipoMapa() {
	tipoMapa = "roadmap";
	return tipoMapa;
}