package br.com.rest.pojo;

import java.util.List;

public class ProcedimentoPojo {
    private Integer id;
    private String nome;
    private String codigo;
    private List<ProdutoPojo> produtos;
    private String dataInicio;
    private String dataFim;
    private Integer unidade;
    private String statusHorario;
    private List<Integer> medicos;
    private List<Integer> equipamentos;
    private List<Integer> plataformas;
    private Integer conjuntoExecutores;
    private Boolean encaixe;
    private Boolean encaixeForcado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<ProdutoPojo> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPojo> produtos) {
        this.produtos = produtos;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getUnidade() {
        return unidade;
    }

    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }

    public String getStatusHorario() {
        return statusHorario;
    }

    public void setStatusHorario(String statusHorario) {
        this.statusHorario = statusHorario;
    }

    public List<Integer> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Integer> medicos) {
        this.medicos = medicos;
    }

    public List<Integer> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Integer> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public List<Integer> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Integer> plataformas) {
        this.plataformas = plataformas;
    }

    public Integer getConjuntoExecutores() {
        return conjuntoExecutores;
    }

    public void setConjuntoExecutores(Integer conjuntoExecutores) {
        this.conjuntoExecutores = conjuntoExecutores;
    }

    public Boolean getEncaixe() {
        return encaixe;
    }

    public void setEncaixe(Boolean encaixe) {
        this.encaixe = encaixe;
    }

    public Boolean getEncaixeForcado() {
        return encaixeForcado;
    }

    public void setEncaixeForcado(Boolean encaixeForcado) {
        this.encaixeForcado = encaixeForcado;
    }
}
