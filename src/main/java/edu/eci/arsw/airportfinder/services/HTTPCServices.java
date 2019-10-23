package edu.eci.arsw.airportfinder.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class HTTPCServices implements HttpConnectionServices {
	
	public HttpResponse<String> getAirportsByName(String name) throws UnirestException {

        return Unirest.get("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=" + name)
                .header("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "3407fc8ec4msh92a7a491f6cfa03p18fee7jsn32c7feb653f1")
                .asString();

    }

}
