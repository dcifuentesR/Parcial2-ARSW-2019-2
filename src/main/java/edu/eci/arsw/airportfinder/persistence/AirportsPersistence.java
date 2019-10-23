package edu.eci.arsw.airportfinder.persistence;

import edu.eci.arsw.airportfinder.model.Airport;

public interface AirportsPersistence {
	
	public Airport getAirportByName(String airportName) throws Exception;

}
