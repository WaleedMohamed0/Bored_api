package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class StepDefinitions {
    private Response response;

    @Given("the base URL is {string}")
    public void setBaseURL(String baseURL) {
        RestAssured.baseURI = baseURL;
    }

    @When("a GET request is made to {string}")
    public void performGETRequest(String endpoint) {
        response = RestAssured.get(endpoint);
        response.prettyPrint();
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }
}
