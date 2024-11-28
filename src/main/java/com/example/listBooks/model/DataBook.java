package com.example.listBooks.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.mail.MailProperties;

import java.util.List;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook(
    @JsonAlias("id") int id,
    @JsonAlias("title") String title,
    @JsonAlias("authors") List<DataAuthor> authors,
    @JsonAlias("download_count") int download_count,
    @JsonAlias("languages") List<String> languages
) {
    @Override
    public String toString() {
        return "DataBook{" +
                "\n\ttitle='" + title + '\'' +
                "\n\tid='"+ id +
                ",\n\tauthors=" + authors +
                ",\n\tdownload_count=" + download_count +
                ",\n\tlanguages=" + languages +
                "\n}";
    }

}
