package com.projeto.projetoColecao.dtos;

public class ListaEscritorDto {

    private Long id;
    private String nome;
    private String generoLiterario;
    private String dataNascMorte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    public String getDataNascMorte() {
        return dataNascMorte;
    }

    public void setDataNascMorte(String dataNascMorte) {
        this.dataNascMorte = dataNascMorte;
    }

    public ListaEscritorDto(){

    }
}
