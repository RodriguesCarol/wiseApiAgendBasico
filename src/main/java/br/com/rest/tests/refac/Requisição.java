package br.com.rest.tests.refac;

import br.com.rest.core.BaseTest;
import br.com.rest.dataFactory.RefacRequisicaoDataFactory;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Requisição extends BaseTest {

    @Test
    @DisplayName("Validar Requisição criada")
    public void CriarRequisição() {
        Integer idPaciente = getIdPacienteCriado("Marcos"); /// Colocar nome que desejar
        given()
                .queryParam("paciente",+ idPaciente)
                .when()
                .post("/requisicoes")
                .then()
                .assertThat()
                .body("paciente.nome", equalTo("Marcos")) /// Validar o nome que foi inserido na criação
                .body("paciente.id", equalTo(idPaciente))
                .body("status",equalTo("NAO_CONFIRMADO"));
    }
     /// Criar um paciente com nome e obter o Id
     public Integer getIdPacienteCriado (String nomePaciente) {
        return RestAssured.given().body("{ \"nome\": \""+ nomePaciente+"\"\n" + "   \n" + "}").when()
                        .post("/paciente").then().extract().path("id");

    }


    @Test
    @DisplayName("Validar Requisição Atualizada")
    public void AtualizarRequisição() {
        Integer idPfcriado =getIdPacienteCriado();
        ///cria uma requisição a partir de um paciente criado
        given().log().all().queryParam("paciente",+ idPfcriado).when()
                .post("/requisicoes").then().extract().path("codigo");

        /// Atualiza a requisição a partir do codigo  e dados informados no Body
        String idCodigo = getCodigoRequisicao(idPfcriado);
        given().log().all().pathParam("codigo",idCodigo)
                .body(RefacRequisicaoDataFactory.atualizarDadosRequisicao("NAO_CONFIRMADO",false, 221,idPfcriado,1,13,idCodigo,"Marcos"))
                .when().put("/requisicoes/{codigo}").then();

        ////Valida a Requisição atualizada
        given().log().all()
                .pathParam("codigo", idCodigo)
                .when()
                .get("/requisicoes/{codigo}/agendamentos")
                .then()
                .assertThat()
                .body("codigo[0]", equalTo(idCodigo))
                .body("paciente[0]", equalTo(idPfcriado))
                .body("plano[0]", equalTo(221))
                .body("produtos[0].produto[0]", equalTo(1))
                .body("produtos[0].status[0]", equalTo("CRIADO"))
                .log().all();
     }

    ///cria um paciente e obtem o id
    public Integer getIdPacienteCriado () {
        return RestAssured.given().body("{ \"nome\": \"\"\n" + "   \n" + "}").when().post("/paciente").then().log().all().extract().path("id");
    }
    ////Recupera o codigo da requisição NAO Confirmada
    public String getCodigoRequisicao( Integer paciente){
         return RestAssured.given().queryParam("paciente",paciente).when() .log().all().get ("/requisicoes").then().extract().path("codigo[0]");
    }

    }