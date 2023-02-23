package br.com.rest.dataFactory;

import br.com.rest.pojo.ProcedimentoPojo;
import br.com.rest.pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

import static br.com.rest.tests.WiseTest.*;

public class ProcedimentoDataFactory {
    public static ProcedimentoPojo inserirDadosProcedimento(){
        ProcedimentoPojo procedimento = new ProcedimentoPojo();
        procedimento.setId(idProcedimento);
        procedimento.setNome("Tomografia de Crânio");
        procedimento.setCodigo(codigo);

        List<ProdutoPojo> produtos = new ArrayList<>();

        ProdutoPojo primeiroProduto = new ProdutoPojo();
        primeiroProduto.setProduto(produto);

        produtos.add(primeiroProduto);
        procedimento.setProdutos(produtos);

        procedimento.setDataInicio(dtInicio);
        procedimento.setDataFim(dtFim);

        procedimento.setUnidade(unidade);
        procedimento.setStatusHorario("RESERVADO");

        List<Integer> medicoProcedimento = new ArrayList<>();
        medicoProcedimento.add(medico);
        procedimento.setMedicos(medicoProcedimento);

        List<Integer> equipamentoProcedimento =new ArrayList<>();
        equipamentoProcedimento.add(190);
        procedimento.setEquipamentos(equipamentoProcedimento);

        List<Integer> plataformaProcediemento = new ArrayList<>();
        /*plataformaProcediemento.add("");*/
        procedimento.setPlataformas(plataformaProcediemento);

        procedimento.setConjuntoExecutores(66);
        procedimento.setEncaixe(false);
        procedimento.setEncaixeForcado(false);

        return procedimento;
    }
}
