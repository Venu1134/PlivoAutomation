package com.plivo.automation;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PlivoAutomation {

    private static final String AUTH_ID = "YOUR_AUTH_ID";
    private static final String AUTH_TOKEN = "YOUR_AUTH_TOKEN";
    private static final String BASE_URL = "https://api.plivo.com/v1/Account/" + AUTH_ID + "/Message/";

    public Response sendSMS(String customerId) throws IOException {
        FileReader reader = new FileReader("data/customer_message.csv");
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        Response response = null;

        for (CSVRecord record : csvParser) {
            if (record.get("ID").equals(customerId)) {
                String sourceNumber = record.get("SourceNumber");
                String destinationNumber = record.get("DestinationNumber");
                String message = record.get("Message");

                response = RestAssured.given()
                    .auth().preemptive().basic(AUTH_ID, AUTH_TOKEN)
                    .formParam("src", sourceNumber)
                    .formParam("dst", destinationNumber)
                    .formParam("text", message)
                    .post(BASE_URL);

                System.out.println("Response: " + response.getBody().asString());
            }
        }
        csvParser.close();
        return response;
    }
}
