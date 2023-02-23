package br.com.rest.core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;


public class BaseTest implements Constantes {

    @BeforeAll
    public static void setup(){

        baseURI = BASE_URL;
        port = PORT;
        basePath = BASE_PATH;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(CONTENT_TYPE);
        requestSpecification = reqBuilder.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        resBuilder.expectStatusCode(200);
        responseSpecification = resBuilder.build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();



    }


}
