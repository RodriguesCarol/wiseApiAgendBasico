package br.com.rest.pojo;

import java.util.List;

public class RequisicaoPojo {
    private String codigo  ;
    private Integer plano;
    private String status;
    private DadosPacientePojo paciente;


    private Integer regiao;


    private List<ProdutoPojo> produtos;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getPlano() {
        return plano;
    }

    public void setPlano(Integer plano) {
        this.plano = plano;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




    public Integer getRegiao() {
        return regiao;
    }

    public void setRegiao(Integer regiao) {
        this.regiao = regiao;
    }

    public List<ProdutoPojo> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPojo> produtos) {
        this.produtos = produtos;
    }


    public DadosPacientePojo getPaciente() {
        return paciente;
    }

    public void setPaciente(DadosPacientePojo paciente) {
        this.paciente = paciente;
    }
}
