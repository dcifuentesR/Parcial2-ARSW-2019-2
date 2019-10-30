package edu.eci.arsw.airportfinder.persistence;

import java.util.Set;

import edu.eci.arsw.airportfinder.model.Airport;
import edu.eci.arsw.airportfinder.model.City;

public interface AirportsPersistence {
	
	public Set<Airport> getAirportsByName(String airportName) throws Exception;
	
	public void addCity(City city) throws Exception;

}
