package edu.eci.arsw.airportfinder.services;

import edu.eci.arsw.airportfinder.model.Airport;

public interface AirportFinderServices {
	
	public Airport getAirportByName(String airportName) throws Exception;

}
