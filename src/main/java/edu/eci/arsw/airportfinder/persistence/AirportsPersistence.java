package edu.eci.arsw.airportfinder.persistence;

import java.util.Set;

import edu.eci.arsw.airportfinder.model.Airport;

public interface AirportsPersistence {
	
	public Set<Airport> getAirportsByName(String airportName) throws Exception;

}
