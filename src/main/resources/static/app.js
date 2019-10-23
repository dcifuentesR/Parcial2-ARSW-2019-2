var app = (function () {
    
    var stompClient = null;
    var selectedCity=null;
    var selectedCityAirports=null;

    var getMousePosition = function (evt) {
        canvas = document.getElementById("canvas");
        var rect = canvas.getBoundingClientRect();
        return {
            x: evt.clientX - rect.left,
            y: evt.clientY - rect.top
        };
    };
    
    var searchAirports = function(city){
    	AirportsFinderModule.getAirportsByName(city,function(error,airports){
    		if(error){
					return console.log("could not find the airport");
				}else{
					selectedCity=city;
					selectedCityAirports=airports;
					
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
            var can = document.getElementById("canvas");
            
            if(window.PointerEvent){
            	can.addEventListener("pointerdown",function(event){
            		var point = getMousePosition(event);
            		app.publishPoint(point.x ,point.y ,$("#canvasId").val())
            	})
            }
            //websocket connection
            //connectAndSubscribe();
        },
    
    updateAirportList:updateAirportList
    };

})();