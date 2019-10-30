package edu.eci.arsw.airportfinder.services;

import java.util.Set;

import edu.eci.arsw.airportfinder.model.Airport;

public interface AirportFinderServices {
	
	public String getAirportsByName(String cityName) throws Exception;

}
