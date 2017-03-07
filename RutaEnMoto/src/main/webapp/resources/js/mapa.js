/**
 * 
 */

  // Load the Visualization API and the columnchart package.
	google.load('visualization', '1', {packages: ['columnchart']});

    var path = [];
    var pathNombre = [];
    var map = [];

	jQuery(function($) {
    // Asynchronously Load the map API 
    var script = document.createElement('script');
    script.src = "http://maps.googleapis.com/maps/api/js?sensor=false&callback=initialize&key=AIzaSyAAGSv8J1OLhWG9DHsMIJ5M9zfl2qSF4Qg";
    document.body.appendChild(script);
});

function initialize() {
    // Change a few 'var variableName' to 'window.' This lets us set global variables from within our function
    directionsService = new google.maps.DirectionsService();
    directionsDisplay = new google.maps.DirectionsRenderer();
    var bounds = new google.maps.LatLngBounds();
    var mapOptions = {
        mapTypeId: getTipoMapa(),
		disableDefaultUI: true
    };
                    

	altura = getAlto();
	anchura = getAncho();
	map_wrapper = document.getElementById("map_wrapper");
	map_canvas = document.getElementById("map_canvas");
	right_panel = document.getElementById("right-panel");
	map_wrapper.style.width=anchura + "%";
	right_panel.style.width=(98 - anchura) + "%";
	map_canvas.style.height=altura + "%";
	 
					
	var parada_si = true;
	var parada_no = false;
    // Display a map on the page
    map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
    map.setTilt(45);
        
    markers = getMarcadoresRuta();
    
   for (var i = 0; i < markers.length; i++) {
   		var etiqueta = "";
   		if (markers[i][5] == true) {
   			etiqueta = markers[i][2];
   		}
		 var beachMarker = new google.maps.Marker({
			  position: {lat: markers[i][1], lng: etiqueta},
			  map: map,
			  label: {fontWeight: "bold", text:markers[i][0]},
		      icon: {
				      path: google.maps.SymbolPath.CIRCLE,
				      scale: 1,
				      labelOrigin: new google.maps.Point(0,markers[i][4])
				    },
		 });
		 
/* 		 pos = new google.maps.LatLng(markers[i][1],markers[i][2]);
		 path.push(pos);
 */   }
	
    // Render our directions on the map
    directionsDisplay.setMap(map);
	
    // Set the current route - default: driving
    calcRoute();
    
    elevaciones();
    
}

function elevaciones() {

    // Create an ElevationService.
    var elevator = new google.maps.ElevationService;
    
	    // Draw the path, using the Visualization API and the Elevation service.
	displayPathElevation(path, elevator, map);

}



// Calculate our route between the markers & set/change the mode of travel
function calcRoute() {
    //var selectedMode = document.getElementById('travelType').value;
	var waypts = [];
	for (var i = 1; i < markers.length-1; i++) {
      waypts.push({
	      location: new google.maps.LatLng(markers[i][1], markers[i][2]),
	      stopover:markers[i][3]
      });
	}
    var request = {
        origin: new google.maps.LatLng(markers[0][1], markers[0][2]),
		waypoints: waypts,
        destination: new google.maps.LatLng(markers[markers.length-1][1], markers[markers.length-1][2]),
        // Set our mode of travel - default: driving
        //travelMode: google.maps.TravelMode[selectedMode]
		travelMode: google.maps.TravelMode["DRIVING"]
    };
    directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
			  var route = response.routes[0];
			  var summaryPanel = document.getElementById('directions-panel');
			  summaryPanel.innerHTML = '';
			  // For each route, display summary information.
			  punto=0;
			  var distancia = 0;
			  var duracion = 0;
			  for (var i = 0; i < route.legs.length; i++) {
			  punto+=1;
				var routeSegment = i + 1;
				summaryPanel.innerHTML += '<b>Tramo de la ruta: ' + routeSegment +
					'</b><br>';
				summaryPanel.innerHTML += route.legs[i].start_address + ' hasta ';
				summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
				if (route.legs[i].via_waypoints.length > 0) {
					for (var w = 0; w < route.legs[i].via_waypoints.length; w++) {
						punto+=1;
						//punto = w + i + 2;
						//route.legs[i].via_waypoints[w].toString()
						summaryPanel.innerHTML += "- Punto " + punto + ": " + " " + markers[punto-1][0]+ "" + '<br>';
					}
					//path.push(route.legs[i].steps[0].path[0]);
					//pathNombre.push(markers[i][0]);
					for (var x = 0; x < route.legs[i].steps.length; x++) {
						for (var y = 1; y < route.legs[i].steps[x].path.length; y++) {
							if (y%20 == 0) {
								path.push(route.legs[i].steps[x].path[y]);
								pathNombre.push(markers[i][0]);
							}
						}
					}
					
				}
				summaryPanel.innerHTML += route.legs[i].distance.text + ' ' + route.legs[i].duration.text + '<br><br>';
				distancia+=route.legs[i].distance.value;
				duracion+=route.legs[i].duration.value;
			  }
			
			 var resumenRuta = document.getElementById('resumen-ruta');
			 resRuta = '<b>Resumen de la ruta: </b><br>';
			 resRuta += 'Distancia: ' + distancia/1000 + ' km<br>'
			 resRuta += 'Duración: ' + secondsToTime(duracion) + '<br>';
			resumenRuta.innerHTML = resRuta + resumenRuta.innerHTML;
        }
    });
	
}

function displayPathElevation(path, elevator, map) {
  // Display a polyline of the elevation path.
  new google.maps.Polyline({
    path: path,
    strokeColor: '#0000CC',
    opacity: 0.4,
    map: map
  });

  // Create a PathElevationRequest object using this array.
  // Ask for 256 samples along that path.
  // Initiate the path request.
  elevator.getElevationAlongPath({
    'path': path,
    'samples': path.length
  }, plotElevation);
}

// Takes an array of ElevationResult objects, draws the path on the map
// and plots the elevation profile on a Visualization API ColumnChart.
function plotElevation(elevations, status) {
  var chartDiv = document.getElementById('elevation_chart');
  if (status !== google.maps.ElevationStatus.OK) {
    // Show the error code inside the chartDiv.
    chartDiv.innerHTML = 'Cannot show elevation: request failed because ' +
        status;
    return;
  }
  // Create a new chart in the elevation_chart DIV.
  var chart = new google.visualization.ColumnChart(chartDiv);

  // Extract the data from which to populate the chart.
  // Because the samples are equidistant, the 'Sample'
  // column here does double duty as distance along the
  // X axis.
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'Sample');
  data.addColumn('number', 'Elevation');
  var minElev = 10000;
  var maxElev = 0;
  for (var i = 0; i < elevations.length; i++) {
    data.addRow([pathNombre[i], elevations[i].elevation]);
    if (elevations[i].elevation>maxElev)
    	maxElev=elevations[i].elevation;
    if (elevations[i].elevation<minElev)
    	minElev=elevations[i].elevation;
  }
	 var resumenRuta = document.getElementById('resumen-ruta');
	resumenRuta.innerHTML = resumenRuta.innerHTML + 'Desnivel: ' + parseFloat(minElev).toFixed(2)  
		+ ' m - ' + parseFloat(maxElev).toFixed(2) + ' m<br>';



  // Draw the chart using the data within its DIV.
  chart.draw(data, {
    height: 200,
    legend: 'none',
    titleY: 'Elevation (m)'
  });
}

function saveMapToDataUrl() {

    var element = $("#map_canvas");

    html2canvas(element, {
        useCORS: true,
        onrendered: function(canvas) {
            var dataUrl= canvas.toDataURL("image/png");

            // DO SOMETHING WITH THE DATAURL
            // Eg. write it to the page
            document.write('<img src="' + dataUrl + '"/>');
        }
    });
}
function saveElevationToDataUrl() {

    var element = $("#elevation_chart");

    html2canvas(element, {
        useCORS: true,
        onrendered: function(canvas) {
            var dataUrl= canvas.toDataURL("image/png");

            // DO SOMETHING WITH THE DATAURL
            // Eg. write it to the page
            document.write('<img src="' + dataUrl + '"/>');
        }
    });
}
