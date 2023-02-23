package br.com.rest.dataFactory;

import br.com.rest.pojo.DadosPacientePojo;
import br.com.rest.pojo.ProdutoPojo;
import br.com.rest.pojo.RequisicaoPojo;
import br.com.rest.pojo.TelefonePojo;

import java.util.ArrayList;
import java.util.List;

import static br.com.rest.tests.WiseTest.*;

public class RequisicaoDataFactory {
    public static RequisicaoPojo atualizarDadosRequisicao(String status, Boolean ativo){
        RequisicaoPojo requisicao =new RequisicaoPojo();
        requisicao.setCodigo(codigo);
        requisicao.setPlano(plano);

        requisicao.setRegiao(13);
        requisicao.setStatus(status);

        List<ProdutoPojo> produtos = new ArrayList<>();

        ProdutoPojo primeiroProduto = new ProdutoPojo();
        primeiroProduto.setProduto(produto);

        produtos.add(primeiroProduto);
        requisicao.setProdutos(produtos);


        DadosPacientePojo paciente = new DadosPacientePojo();
        paciente.setId(idpaciente);
        paciente.setNome("Maria do Bairro");
        paciente.setAtivo(ativo);
        requisicao.setPaciente(paciente);

        List<TelefonePojo> telefones =new ArrayList<>();

        TelefonePojo primeiroTelefone = new TelefonePojo();
        primeiroTelefone.setNumero( "11 912341234");
        primeiroTelefone.setTipo( "CELULAR");
        telefones.add(primeiroTelefone);

        paciente.setTelefones(telefones);

        return requisicao;
    }
}
