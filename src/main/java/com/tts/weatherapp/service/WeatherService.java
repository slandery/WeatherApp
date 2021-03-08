package com.tts.weatherapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tts.weatherapp.model.Response;



@Service
public class WeatherService {
	@Value("${api_key}")
	private String apiKey;

	public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + 
            zipCode + "&units=imperial&appid=" + apiKey;
        try {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Response.class);
    }catch (HttpClientErrorException ex) {
        Response response = new Response();
        response.setName("error");
        return response;
    }
    }
	
 
}