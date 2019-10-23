package edu.eci.arsw.airportfinder.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface HttpConnectionServices {
	
	public HttpResponse<String> getAirportsByName(String name) throws UnirestException;

}
