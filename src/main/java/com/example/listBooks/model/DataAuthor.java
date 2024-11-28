package com.example.listBooks.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAuthor(
     @JsonAlias("name") String name,
     @JsonAlias("birth_year")   Integer birth_year,
     @JsonAlias("death_year")   Integer death_year
) {

}
