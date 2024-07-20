package com.plivo.automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeatherAutomation {

    private static final String API_KEY = "213087bc46b3c42e0cfc764a7b7cd970";
    private static final String GEOCODING_URL = "http://api.openweathermap.org/data/2.5/geo/1.0/direct";
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/onecall";

    public Response getWeatherData(String city) {
        Response response = RestAssured.given()
            .queryParam("q", city)
            .queryParam("appid", API_KEY)
            .get(GEOCODING_URL);

        String lat = response.jsonPath().getString("[0].lat");
        String lon = response.jsonPath().getString("[0].lon");

        return RestAssured.given()
            .queryParam("lat", lat)
            .queryParam("lon", lon)
            .queryParam("appid", API_KEY)
            .get(WEATHER_URL);
    }
}
