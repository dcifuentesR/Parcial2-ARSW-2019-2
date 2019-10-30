package edu.eci.arsw.airportfinder.persistence;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import edu.eci.arsw.airportfinder.model.Airport;
import edu.eci.arsw.airportfinder.model.City;


@Service
public class AirportFinderCache implements AirportsPersistence{
	
	private final ConcurrentHashMap<String, City> cities= new ConcurrentHashMap<String, City>();
	
	public AirportFinderCache() {
		
	}

	@Override
	public Set<Airport> getAirportsByName(String cityName) throws Exception{
		Set<Airport> airportsResponse = cities.get(cityName).getAirports();
        if(airportsResponse.isEmpty()){
            throw new Exception("Could not find city "+cityName);
        }
        else{
            return airportsResponse;
        }
	}

	@Override
	public void addCity(City city) throws Exception {
		cities.put(city.getName(), city);
		
	}

	
}
