package com.pilvo.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.plivo.automation.OpenWeatherAutomation;

import io.restassured.response.Response;

public class OpenWeatherTest {
	@Test
	public void testGetWeatherData() {
		OpenWeatherAutomation weather = new OpenWeatherAutomation();
		Response response = weather.getWeatherData("London");
		System.out.println("Weather Data: " + response.getBody().asString());
		Assert.assertEquals(response.statusCode(), 200);
	}
}
