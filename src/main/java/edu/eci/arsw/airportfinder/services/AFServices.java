package edu.eci.arsw.airportfinder.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.airportfinder.model.Airport;
import edu.eci.arsw.airportfinder.model.City;
import edu.eci.arsw.airportfinder.persistence.AirportsPersistence;

@Service
public class AFServices implements AirportFinderServices {
	
	
	@Autowired
	private AirportsPersistence ap;
	
	@Autowired
	private HttpConnectionServices httpCS;

	public Set<Airport> getAirportsByName(String airportName) throws Exception{
		if(ap.getAirportsByName(airportName)==null) {
			JSONArray airports = (JSONArray) new JSONParser().parse(httpCS.getAirportsByName(airportName).getBody());
			for(Object o:airports) {
				JSONObject oj = (JSONObject) o; 
				Set<Airport> aports= new HashSet<Airport>();
				aports.add(new Airport((String)oj.get("code"),(String) oj.get("name"), (String)oj.get("city"),(String) oj.get("countryCode")));
			}	
		}

		return ap.getAirportsByName(airportName);
	}
		

}
