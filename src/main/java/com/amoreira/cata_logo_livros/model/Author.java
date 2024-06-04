package com.amoreira.cata_logo_livros.model;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private Long author_id;

    private String authorName;
    private Integer yearBirth;
    private Integer yearDeath;

    private List<Book> books = new ArrayList<>();

    public Author(){}

    public Author(DataAuthor data){

        this.authorName = data.nomeAutor();
        this.yearBirth = (data.anoNascimento() != null) ? data.anoNascimento():0 ;
        this.yearDeath = (data.anoMorte() != null)? data.anoMorte() : 0;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(Integer yearBirth) {
        this.yearBirth = yearBirth;
    }

    public Integer getYearDeath() {
        return yearDeath;
    }

    public void setYearDeath(Integer yearDeath) {
        this.yearDeath = yearDeath;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "\n------------ Autor ------------\n" +
                "Nome : '" + authorName + '\'' +
                ", Ano do nascimento: " + yearBirth +
                ", Ano da morte: " + yearDeath +
                ", Livros registrados: " + books + //(libros != null ? libros.stream().map(Libro::getTituloLibro).collect(Collectors.toList()) : "Sin libros") + '\n'
                "--------------------------------\n";
    }
}
