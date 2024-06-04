package com.amoreira.cata_logo_livros.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Collections;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String titulo;
    private Linguagens linguagem;
    private int nDownloads;

    @ManyToOne
    @JoinColumn(name = "author_d", nullable = false)
    private Author author;

    public Book(){}

    public Book(DadosResposta dataBook) {

        List<DataBook> db = Collections.singletonList(dataBook.results().get(0));
        String linguagem = String.valueOf(db.get(0).linguagemLivro());
        this.linguagem = Linguagens.fromString(linguagem);

        this.titulo = db.get(0).tituloLivro();

        this.nDownloads = db.get(0).nDownloads();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Author getAutor() {
        return author;
    }

    public void setAutor(Author autor) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + author + '\'' +
                ", linguagem=" + linguagem +
                ", nDownloads=" + nDownloads +
                '}';
    }
}
