package com.amoreira.cata_logo_livros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// title, author
@JsonIgnoreProperties(ignoreUnknown = true)
public record DataResponse(
        @JsonAlias("results")List<DataBook> results
) {}







