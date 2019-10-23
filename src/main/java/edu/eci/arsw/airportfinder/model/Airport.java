package edu.eci.arsw.airportfinder.model;

public class Airport {
	private String code;
	
	private String name;
	
	private String city;
	
	private String countryCode;

	public Airport(String code, String name, String city, String countryCode) {
		this.code = code;
		this.name = name;
		this.city = city;
		this.countryCode = countryCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	

}
