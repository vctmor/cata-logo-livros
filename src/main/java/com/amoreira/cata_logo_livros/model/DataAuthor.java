package com.amoreira.cata_logo_livros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAuthor(
        @JsonAlias("name") String nomeAutor,
        @JsonAlias("birth_year") Integer anoNascimento,
        @JsonAlias("death_year") Integer anoMorte
)  {
}
