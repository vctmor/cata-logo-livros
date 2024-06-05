package com.amoreira.cata_logo_livros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAuthor(
        @JsonAlias("name") String nameAuthor,
        @JsonAlias("birth_year") Integer yearBirth,
        @JsonAlias("death_year") Integer yearDeath
)  {
}
