/**
 * 
 */
var AirportsFinderModule = (function(){
	
	
	return {
		getAirportsByName:function(airportName,callback){
			jQuery.ajax({
                url: "http://localhost:8080/cities/"+airportName,
                success: function (result) {
                    callback(null,result);
                },
                async: false
            });
		}
	}
})();
