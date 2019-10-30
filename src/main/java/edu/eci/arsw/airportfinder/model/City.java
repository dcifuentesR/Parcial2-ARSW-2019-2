package edu.eci.arsw.airportfinder.model;

import java.util.Set;

public class City {
	
	private Set<Airport> airports;
	
	private String name;

	public City(Set<Airport> airports, String name) {
		
		this.airports = airports;
		this.name = name;
	}

	public Set<Airport> getAirports() {
		return airports;
	}

	public void setAirports(Set<Airport> airports) {
		this.airports = airports;
	}

	public String getName() {
		return name;
	}

}
