package edu.eci.arsw.airportfinder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.airportfinder.model.Airport;
import edu.eci.arsw.airportfinder.persistence.AirportsPersistence;

@Service
public class AFServices implements AirportFinderServices {
	
	
	@Autowired
	private AirportsPersistence ap;

	public Airport getAirportByName(String airportName) throws Exception{
		return ap.getAirportByName(airportName);
	}

}
