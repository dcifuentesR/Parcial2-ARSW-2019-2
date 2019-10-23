package edu.eci.arsw.airportfinder.persistence;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
		
		Airport alondon2 = new Airport("LCY", "London City", "London", "GB");
		airports.put(alondon2.getName(), alondon2);
		System.out.print(airports.entrySet());
	}

	@Override
	public Set<Airport> getAirportsByName(String airportName) throws Exception{
		Set<Airport> airportsResponse = new HashSet<Airport>();
        for (Map.Entry<String,Airport> entry : airports.entrySet()) {
            if(entry.getKey().equals(airportName)){
                airportsResponse.add(entry.getValue());
            }
        }
        if(airportsResponse.isEmpty()){
            throw new Exception("Could not find city "+airportName);
        }
        else{
            return airportsResponse;
        }
	}

}
