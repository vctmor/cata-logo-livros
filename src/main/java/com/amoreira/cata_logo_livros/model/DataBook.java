package com.amoreira.cata_logo_livros.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook(
        @JsonAlias("title") String titleBook,
        @JsonAlias("authors")List<DataAuthor> dataAuthor,
        @JsonAlias("languages")List<String> languageBook,
        @JsonAlias("download_count") Integer nDownloads){
}
