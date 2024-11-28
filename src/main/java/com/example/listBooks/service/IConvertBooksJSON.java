package com.example.listBooks.service;

public interface IConvertBooksJSON {
    <T> T getDataApi(String json, Class<T> clase);
}
