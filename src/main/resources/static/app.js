var app = (function () {
    
    var stompClient = null;
    var selectedCity=null;
    var selectedCityAirports=null;

    var map;

    var initMap = function()
    {
      map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: -34.397, lng: 150.644},
        zoom: 8
      });
      console.log(map);

//      fetch('https://raw.githubusercontent.com/jayshields/google-maps-api-template/master/markers.json')
//        .then(function(response){return response.json()})
//        .then(plotMarkers);
    }
    
    var plotMarkers =function (m)
    {
      markers = [];
      bounds = new google.maps.LatLngBounds();

      m.forEach(function (marker) {
        var position = new google.maps.LatLng(marker.lat, marker.lng);

        markers.push(
          new google.maps.Marker({
            position: position,
            map: map,
            animation: google.maps.Animation.DROP
          })
        );

        bounds.extend(position);
      });

      map.fitBounds(bounds);
    }
    
    
    var searchAirports = function(city){
    	AirportsFinderModule.getAirportsByName(city,function(error,airports){
    		if(error){
					return console.log("could not find the airport");
				}else{
					selectedCity=city;
					selectedCityAirports=JSON.parse(airports);
					var markers =[];
					selectedCityAirports.forEach(function(currentAirport){
						markers.push({
							lat: currentAirport.location.latitude,
							lng: currentAirport.location.longitude
						});
					});
					plotMarkers(markers);
					
				}
    	})
    }
    
    var updateAirportList = function(city){
    	airportTable = $("#airportTableBody");
    	airportTable.empty();
    	
		searchAirports(city);
		selectedCityAirports.forEach(function(currentAirport){
			var tr,td;
			
			airportTable.append(tr = document.createElement("tr"));
			tr.appendChild(td =document.createElement("td"));
			td.innerHTML=currentAirport.code;
			tr.appendChild(td = document.createElement("td"));
			td.innerHTML=currentAirport.name;
			tr.appendChild(td = document.createElement("td"));
			td.innerHTML=currentAirport.city;
			tr.appendChild(td = document.createElement("td"));
			td.innerHTML=currentAirport.countryCode;
			
		});
		
		airportTable.append();
		
		
    }    
    

    return {

        init: function () {
        	initMap();
        	document.addEventListener('DOMContentLoaded', function () {
        		  if (document.querySelectorAll('#map').length > 0)
        		  {
        		    if (document.querySelector('html').lang)
        		      lang = document.querySelector('html').lang;
        		    else
        		      lang = 'en';

        		    var js_file = document.createElement('script');
        		    js_file.type = 'text/javascript';
        		    js_file.src = 'https://maps.googleapis.com/maps/api/js?callback=initMap&signed_in=true&language=' + lang;
        		    document.getElementsByTagName('head')[0].appendChild(js_file);
        		  }
        		});
        },
    
    updateAirportList:updateAirportList
    };

})();