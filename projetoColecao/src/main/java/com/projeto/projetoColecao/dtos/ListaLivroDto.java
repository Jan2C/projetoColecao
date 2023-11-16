package com.projeto.projetoColecao.dtos;

public class ListaLivroDto {

    private Long id;
    private String nome;
    private String genero;
    private String editora;
    private Long escritorId;
    private Long paginas;
    private String ano;

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Long getEscritorId() {
        return escritorId;
    }

    public void setEscritorId(Long escritorId) {
        this.escritorId = escritorId;
    }

    public Long getPaginas() {
        return paginas;
    }

    public void setPaginas(Long paginas) {
        this.paginas = paginas;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public ListaLivroDto(){

    }
}
