package edu.eci.arsw.airportfinder.services;

import java.util.Set;

import edu.eci.arsw.airportfinder.model.Airport;

public interface AirportFinderServices {
	
	public Set<Airport> getAirportsByName(String cityName) throws Exception;

}
