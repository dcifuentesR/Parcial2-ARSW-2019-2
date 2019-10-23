package edu.eci.arsw.airportfinder.persistence;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import edu.eci.arsw.airportfinder.model.Airport;


@Service
public class AirportFinderCache implements AirportsPersistence{
	
	private final ConcurrentHashMap<String, Airport> airports= new ConcurrentHashMap<String, Airport>();
	
	public AirportFinderCache() {
		Airport aberlin = new Airport("SXF", "Schoenfeld/Berlin", "Berlin", "DE");
		airports.put(aberlin.getName(), aberlin);
		
		Airport alondon = new Airport("LCY", "London City", "London", "GB");
		airports.put(alondon.getName(), alondon);
	}

	@Override
	public Airport getAirportByName(String airportName) throws Exception{
		Airport a =airports.get(airportName);
		if(a!=null)
			return a;
		else throw new Exception("could not find airport"+airportName);
	}

}
