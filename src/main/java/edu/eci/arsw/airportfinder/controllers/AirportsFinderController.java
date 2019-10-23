package edu.eci.arsw.airportfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.airportfinder.services.AirportFinderServices;

@RestController
@RequestMapping(value="/cities")
public class AirportsFinderController {
	
	@Autowired
	private AirportFinderServices afs;
	
	@RequestMapping(path = "/{cityName}", method = RequestMethod.GET)
	public ResponseEntity<?> getAirportsByName(@PathVariable("cityName") String cityName){
		
		try {
			return new ResponseEntity<>(afs.getAirportsByName(cityName), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}

}
