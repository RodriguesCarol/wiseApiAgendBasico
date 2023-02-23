package br.com.rest.pojo;

import java.util.List;

public class DadosPacientePojo {
private Boolean ativo;
private Integer id;
private String nome;
private List<TelefonePojo> telefones;






    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

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

    public List<TelefonePojo> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefonePojo> telefones) {
        this.telefones = telefones;
    }
}
