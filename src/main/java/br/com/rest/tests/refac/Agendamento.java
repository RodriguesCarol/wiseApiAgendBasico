package br.com.rest.tests.refac;

/*
public class Agendamento extends BaseTest {*/

    /*@Test
    @DisplayName("Validar Busca de hoŕario")
    public void ObterDiasDisponíveis() {

       *//* Integer idPfcriado =getIdPacienteCriado();
        ///cria uma requisição a partir de um paciente criado
        given().log().all().queryParam("paciente",+ idPfcriado).when()
                .post("/requisicoes").then().log().all().extract().path("codigo");
        /// Atualiza a requisição a partir do codigo  e dados informados no Body
        String idCodigo = getCodigoRequisicao(idPfcriado);
*//*
        /// Verificar dias disponíveis na agenda do médico
        Integer idUnidade = getDadosMedico(131); ///Informar Id do Medico
       // String idCodigo = getCodigoRequisicao("NAO_CONFIRMADO", 50);
        System.out.println(idUnidade);

        given().queryParam("unidades", idUnidade).queryParam("codigo", idCodigo).when()
                .get("/diasdisponiveis").then().log().all()
        ;
        System.out.println(idUnidade);
        given()

                .queryParam("unidades", idUnidade)
                .queryParam("codigo", idCodigo)
                .when()
                .get("/horarios")
                .then()
                .log().all();
    }

    public Integer getDadosMedico(Integer idMedico) {
        return RestAssured.given().pathParam("id", idMedico).queryParam("exibirListaProdutos", true).queryParam("exibirUnidades", true)
                .get("/medicos/{id}").then().log().all().extract().path("unidades[0]");
    }

//    public Integer codigoRequsição (){
//        return
//    }
*//*
    public String getCodigoRequisicao(String status, Integer idUsuario) {
        return RestAssured.given()
                .queryParam("status", status)
                .queryParam("agendadoPor", idUsuario)
                .when().get("/requisicoes").then().log().all().extract().path("codigo[0]");

    }*//*
*//*
    public Integer getIdPacienteCriado () {
        return RestAssured.given().body("{ \"nome\": \"\"\n" + "   \n" + "}").when().post("/paciente").then().log().all().extract().path("id");
    }
    ////Recupera o codigo da requisição NAO Confirmada
    public String getCodigoRequisicao( Integer paciente){
        return RestAssured.given().queryParam("paciente",paciente).when() .log().all().get ("/requisicoes").then().extract().path("codigo[0]");
    }*//*

    @Test

    @DisplayName("Reservar Horário")
    public void ReservarHorário() {
        Integer idProcedimento = getIdProcedimentoRequisicao("NAO_CONFIRMADO", 50);

        given()
                .pathParam("id", idProcedimento)
                .queryParam("ignorarCobertura", "true")
                .body(ProcedimentoDataFactory.inserirDadosProcedimento())
                .when()
                .put("/agendamentos/{id}")
                .then();
    }

    public Integer getIdProcedimentoRequisicao(String status, Integer idUsuario) {
        return RestAssured.given()
                .queryParam("status", status)
                .queryParam("agendadoPor", idUsuario)
                .when().get("/requisicoes").then().extract().path("id");
    }
}*/