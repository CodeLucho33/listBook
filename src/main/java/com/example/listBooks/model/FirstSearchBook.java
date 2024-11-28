package com.example.listBooks.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

        @JsonIgnoreProperties(ignoreUnknown = true)
public record FirstSearchBook(
        @JsonAlias("count") int count

) {
}
