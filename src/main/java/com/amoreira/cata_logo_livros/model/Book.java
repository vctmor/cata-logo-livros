package com.amoreira.cata_logo_livros.model;

import java.util.Collections;
import java.util.List;

public class Book {

    private String titulo;
    private String autor;
    private Linguagens linguagem;
    private int nDownloads;

    public Book(DadosResposta dataBook) {

        List<DataBook> db = Collections.singletonList(dataBook.results().get(0));
        String linguagem = String.valueOf(db.get(0).linguagemLivro());
        this.linguagem = Linguagens.fromString(linguagem);
        this.autor = db.get(0).dadosAutor().get(0).nomeAutor();
        this.titulo = db.get(0).tituloLivro();

        this.nDownloads = db.get(0).nDownloads();
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

    @Override
    public String toString() {
        return "Book{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", linguagem=" + linguagem +
                ", nDownloads=" + nDownloads +
                '}';
    }
}
