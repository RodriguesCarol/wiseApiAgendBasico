package br.com.rest.tests;

import br.com.rest.core.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;



public class WiseTest2 extends BaseTest {

    @Test
    @DisplayName("Criar Requisição")
    public void CriarReq() {
        Map<String,String> bodyheader = new HashMap<>();
        bodyheader.put ("marca","AM");
        bodyheader.put("regional","SP");

       given()
               .log().all()
               .body(bodyheader)
               .when()
               .post("requisicoes")
               .then()
              // .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("req.json"))
               .log().all()
       ;

    }


}
