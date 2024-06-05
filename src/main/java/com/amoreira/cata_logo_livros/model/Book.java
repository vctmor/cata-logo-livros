package com.amoreira.cata_logo_livros.model;
import com.amoreira.cata_logo_livros.model.Author;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    private String title;
    private Languages language;
    private int nDownloads;


    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private Author author;

    public Book(){}

    public Book(DataBook dataBook) {

        //List<DataBook> db = Collections.singletonList(dataBook.results().get(0));
        String language = dataBook.languageBook().get(0); //String.valueOf(dataBook.languageBook());
        this.language = Languages.fromString(language);

        //this.author = //(author.getAuthorName() != null ? dataBook.dataAuthor().get(0).nameAuthor() : "Sem autor")

        this.title = dataBook.titleBook(); //db.get(0).titleBook();

        this.nDownloads = dataBook.nDownloads(); //db.get(0).nDownloads();
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
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
