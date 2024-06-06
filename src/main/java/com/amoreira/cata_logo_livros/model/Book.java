package com.amoreira.cata_logo_livros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Languages language;
    private int nDownloads;


    @ManyToOne
    //@JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(){}

    public Book(DataBook dataBook, Author author) {

        String language = dataBook.languageBook().get(0); //String.valueOf(dataBook.languageBook());
        this.language = Languages.fromString(language);
        this.author = author;
        //this.author = //(author.getAuthorName() != null ? dataBook.dataAuthor().get(0).nameAuthor() : "Sem autor")

        this.title = dataBook.titleBook(); //db.get(0).titleBook();

        this.nDownloads = dataBook.nDownloads(); //db.get(0).nDownloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public int getnDownloads() {
        return nDownloads;
    }

    public void setnDownloads(int nDownloads) {
        this.nDownloads = nDownloads;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return  "----------------------Book -----------------" + "\n" +
                "Título do Livro: " + title + "\n" +
                //"Autor: " +  + "\n" +
                "Linguagem: " + language + "\n" +
                "Downloads: " + nDownloads + "\n" +
                "---------------------------------------------------------";
    }
}
