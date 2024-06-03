package com.amoreira.cata_logo_livros.model;

import java.util.List;

public class Livro {

    private String titulo;
    private String autor;
    private Linguagens linguagem;
    private int nDownloads;

    public Livro(DadosLivro dadosLivro) {
        String linguagem = dadosLivro.linguagemLivro().get(0);

        this.titulo = dadosLivro.tituloLivro();
        this.linguagem = Linguagens.fromString(linguagem);
        this.nDownloads = dadosLivro.nDownloads();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
