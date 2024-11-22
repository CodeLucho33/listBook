package com.example.listBooks;

import com.example.listBooks.service.GetDataApi;

public class Main {
    private final String URL_BASE = "https://gutendex.com/books";
    private GetDataApi getDataApi = new GetDataApi();
    public void getAllDataHardApi(){
      var json =  getDataApi.getDataApi(URL_BASE);
        System.out.println(json);
    }
}
