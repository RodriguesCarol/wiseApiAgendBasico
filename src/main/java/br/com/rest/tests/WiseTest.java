package br.com.rest.tests;

import br.com.rest.core.BaseTest;
import br.com.rest.dataFactory.ProcedimentoDataFactory;
import br.com.rest.dataFactory.RequisicaoDataFactory;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WiseTest extends BaseTest {
    public static Integer unidade;
    public static Integer plano;
    public static Integer medico;

    public static Integer produto;
    public static String codigo;
    public static Integer idpaciente;
    public static Integer idProcedimento;
    public static String dtInicio;
    public static String dtFim;
    public static String nomeProduto;
    public static String status;





    @Test
    @Order(1)
    @DisplayName("Validar  Unidade Encontrada")
    public void ObterUnidade() {
        unidade = given()
                .when()
                .get("/unidades?nome=Unidade I-Caxias")
                .then()
                .assertThat()
                .body("nome[0]", equalTo("Unidade I-Caxias"))
                .extract()
                .path("id[0]");
    }

    @Test
    @Order(2)
    @DisplayName("Validar Plano Encontrado")
    public void ObterPlano() {
        plano = given()
                .when()
                .get("/planos?nome=Particular")
                .then()
                .assertThat()
                .body("nome[0]", equalTo("Particular"))
                .extract()
                .path("id [0]");
    }

    @Test
    @Order(3)
    @DisplayName("Validar Médico Encontrado ")
    public void ObterMedico() {
        medico = given()
                .when()
                .get("/medicos?nome=medica")
                .then()
                .assertThat()
                .body("nome[0]", equalTo("Medica"))
                .extract()
                .path("id [0]");
    }

    @Test
    @Order(4)
    @DisplayName("Validar Produto Encontrado")
    public void ObterProduto() {
        produto = given()
                .when()
                .get("/produtos?nome=Tomografia de Crânio")
                .then()
                .assertThat()
                .body("nome[0]", equalTo("Tomografia de Crânio"))
                .extract()
                .path("id [0]");

        nomeProduto = given()
                .when()
                .get("/produtos?nome=Tomografia de Crânio")
                .then()
                .assertThat()
                .body("nome[0]", equalTo("Tomografia de Crânio"))
                .extract()
                .path("nome [0]");

    }

    @Test
    @Order(5)
    @DisplayName("Validar Paciente criado")
    public  void CriarPaciente() {
        idpaciente = given()
                .body("{}")
                .when()
                .post("/paciente")
                .then()
                .assertThat()
                .body("nome", equalTo("Paciente não identificado"))
                .extract()
                .path("id");
    }

    @Test
    @Order(6)
    @DisplayName("Validar Requisição criada")
    public void CriarRequisição() {
        codigo = given()
                .queryParam("paciente", +idpaciente)
                .when()
                .post("/requisicoes")
                .then()
                .assertThat()
                .body("paciente.id", equalTo(idpaciente))
                .body("paciente.nome", equalTo("Paciente não identificado"))
                .extract()
                .path("codigo");
    }

    @Test
    @Order(7)
    @DisplayName("Atualizar Requisição")
    public void AtualizarRequisição() {
        given()
                .pathParam("codigo", codigo)
                .body(RequisicaoDataFactory.atualizarDadosRequisicao("NAO_CONFIRMADO",false))
                .when()
                .put("/requisicoes/{codigo}")
                .then();
    }

    @Test
    @Order(8)
    @DisplayName("Validar Procedimento ")
    public void ObterProcedimentos() {
        idProcedimento = given()
                .pathParam("codigo", codigo)
                .when()
                .get("/requisicoes/{codigo}/agendamentos")
                .then()
                .assertThat()
                .body("codigo[0]", equalTo(codigo))
                .body("paciente[0]", equalTo(idpaciente))
                .body("plano[0]", equalTo(plano))
                .body("produtos[0].produto[0]", equalTo(produto))
                .body("produtos[0].status[0]", equalTo("CRIADO"))
                .extract()
                .path("id[0]");
    }

    @Test
    @Order(9)
    @DisplayName("Obter Dias Disponíveis")
    public void ObterDiasDisponíveis() {
        given()
                .queryParam("unidades", unidade)
                .queryParam("codigo", codigo)
                .queryParam("listaMedicos", medico)
                .queryParam("procedimentos", idProcedimento)
                .queryParam("ignorarRestricoes", "true")
                .when()
                .get("/diasdisponiveis")
                .then();
    }

    @Test
    @Order(10)
    @DisplayName("Obter horário")
    public void BuscarHorário() {
        dtInicio = given()
                .queryParam("unidades", unidade)
                .queryParam("codigo", codigo)
                .when()
                .get("/horarios")
                .then()
                .extract()
                .path("agendamentos[0].dataInicio[0]");

        dtFim= given()
                .queryParam("unidades", unidade)
                .queryParam("codigo", codigo)
                .when()
                .get("/horarios")
                .then()
                .extract()
                .path("agendamentos[0].dataFim[0]");
    }
    @Test
    @Order(11)
    @DisplayName("Reservar Horário")
    public void ReservarHorário() {
        given()
                .pathParam("id", idProcedimento)
                .queryParam("ignorarCobertura", "true")
                .body(ProcedimentoDataFactory.inserirDadosProcedimento())
                .when()
                .put("/agendamentos/{id}")
                .then();
    }
    @Test
    @Order(12)
    @DisplayName("Obter Token")
    public void ObterToken() {
         given()
                .queryParam("login", "admin")
                .queryParam("dominio", "DEFAULT")
                .when()
                .get("/me")
                .then()
                    .extract()
                        .path ("token");


    }
    @Test
    @Order(13)
    @DisplayName("Validar Agendamento com status horário RESERVADO")
    public void VerificaAgendamentoReservado() {
        given()
                .pathParam("id",idProcedimento)
                .when()
                .get("/agendamentos/{id}")
                .then()
                .body("id", equalTo(idProcedimento))
                .body("nome", equalTo(nomeProduto))
                .body("codigo", equalTo(codigo))
                .body("paciente", equalTo(idpaciente))
                .body("produtos [0].produto", equalTo(produto))
                .body("produtos [0] .status", equalTo("CRIADO"))
                .body("dataInicio",equalTo(dtInicio))
                .body("dataFim",equalTo(dtFim))
                .body("statusHorario", equalTo("RESERVADO"))
                .body("unidade", equalTo(unidade))
                .body("medicos[0]",equalTo(medico));
    }
    @Test
    @Order(14)
    @DisplayName("Validar Confirmação Requisição")
    public void ConfirmarRequisição() {
        given()
                .pathParam("codigo", codigo)
                .body(RequisicaoDataFactory.atualizarDadosRequisicao("CRIADO",true))
                .when()
                .put("/requisicoes/{codigo}")
                .then();
    }

    @Test
    @Order(15)
    @DisplayName("Validar Agendamento com status horário MARCADO")
    public void VerificaAgendamentoMarcado() {
        given()
                .pathParam("id",idProcedimento)
                .when()
                .get("/agendamentos/{id}")
                .then()
                .log().all()
                .body("id", equalTo(idProcedimento))
                .body("nome", equalTo(nomeProduto))
                .body("codigo", equalTo(codigo))
                .body("paciente", equalTo(idpaciente))
                .body("produtos [0].produto", equalTo(produto))
                .body("produtos [0] .status", equalTo("CRIADO"))
                .body("dataInicio",equalTo(dtInicio))
                .body("dataFim",equalTo(dtFim))
                .body("statusHorario", equalTo("MARCADO"))
                .body("unidade", equalTo(unidade))
                .body("medicos[0]",equalTo(medico));
        System.out.println(codigo);



    }

}
