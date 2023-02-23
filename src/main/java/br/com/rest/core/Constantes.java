package br.com.rest.core;

import io.restassured.http.ContentType;

public interface  Constantes {
    //String BASE_URL =  "http://fleury:teste10@fleury-dev-sp.vm.touchtec.com.br";//Se HTTPS utilizar porta 443
    String BASE_URL = "http://localhost:8080";
    Integer PORT= 8080;
    //String BASE_PATH = "/agendamento/modules/fleury/api/";
    String BASE_PATH = "/agendamento/wise/api/";
            ContentType CONTENT_TYPE = ContentType.JSON;

    Long MAX_TIMEOUT = 8000L;// 1 seg timeout

}
