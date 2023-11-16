package com.projeto.projetoColecao.models;

import jakarta.persistence.*;

@Entity
@Table(name = "LIVROS")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long livroId;

    @Column(nullable = false)
    private String livroNome;

    @Column(nullable = false)
    private String livroGenero;

    @Column(nullable = false)
    private String livroEditora;


    @ManyToOne
    @JoinColumn(name = "escritor")
    private EscritorModel livroEscritor;

    @Column(nullable = false)
    private Long livroPaginas;

    @Column(nullable = false)
    private String livroAno;

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public String getLivroNome() {
        return livroNome;
    }

    public void setLivroNome(String livroNome) {
        this.livroNome = livroNome;
    }

    public String getLivroGenero() {
        return livroGenero;
    }

    public void setLivroGenero(String livroGenero) {
        this.livroGenero = livroGenero;
    }

    public String getLivroEditora() {
        return livroEditora;
    }

    public void setLivroEditora(String livroEditora) {
        this.livroEditora = livroEditora;
    }

    public EscritorModel getLivroEscritor() {
        return livroEscritor;
    }

    public void setLivroEscritor(EscritorModel livroEscritor) {
        this.livroEscritor = livroEscritor;
    }

    public String getLivroAno() {
        return livroAno;
    }

    public void setLivroAno(String livroAno) {
        this.livroAno = livroAno;
    }

    public Long getLivroPaginas() {
        return livroPaginas;
    }

    public void setLivroPaginas(Long livroPaginas) {
        this.livroPaginas = livroPaginas;
    }

    public LivroModel(){

    }
}
