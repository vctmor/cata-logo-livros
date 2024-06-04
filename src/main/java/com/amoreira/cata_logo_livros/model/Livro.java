package com.amoreira.cata_logo_livros.model;

public class Livro {

    private String titulo;
    private String autor;
    private Linguagens linguagem;
    private int nDownloads;

    public Livro(DataBook dataBook) {
        String linguagem = dataBook.linguagemLivro().get(0);

        this.titulo = dataBook.tituloLivro();
        this.linguagem = Linguagens.fromString(linguagem);
        this.nDownloads = dataBook.nDownloads();
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
