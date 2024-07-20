package com.pilvo.automation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.plivo.automation.PlivoAutomation;

import io.restassured.response.Response;

public class plivoTest {

	@Test
    public void testSendSMS() throws IOException {
        PlivoAutomation plivo = new PlivoAutomation();
        Response response = plivo.sendSMS("1");
        Assert.assertEquals(response.statusCode(), 200);
    }
}
