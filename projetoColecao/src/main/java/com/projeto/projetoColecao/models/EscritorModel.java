package com.projeto.projetoColecao.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ESCRITORES")
public class EscritorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long escritorId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String dataNascMorte;

    @Column(nullable = false)
    private String generoLiterario;

    public Long getEscritorId() {
        return escritorId;
    }

    public void setEscritorId(Long escritorId) {
        this.escritorId = escritorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascMorte() {
        return dataNascMorte;
    }

    public void setDataNascMorte(String dataNascMorte) {
        this.dataNascMorte = dataNascMorte;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    public EscritorModel(){

    }
}
