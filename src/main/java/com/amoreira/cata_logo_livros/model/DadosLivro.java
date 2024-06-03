package com.amoreira.cata_logo_livros.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
        @JsonAlias("title") String tituloLivro,
        @JsonAlias("authors")List<DadosAutor> dadosAutor,
        @JsonAlias("languages")List<String> linguagemLivro,
        @JsonAlias("download_count") Integer nDownloads){
}
