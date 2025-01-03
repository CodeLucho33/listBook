package com.example.listBooks;

import com.example.listBooks.model.DataBook;
import com.example.listBooks.model.FirstSearchBook;
import com.example.listBooks.model.ListBooksPage;
import com.example.listBooks.service.ConvertBooks;
import com.example.listBooks.service.GetDataApi;

import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/?page=";
    private GetDataApi getDataApi = new GetDataApi();
    private ConvertBooks convertBooks =  new ConvertBooks();
    private  final String urlRandom = getNewUrlWithPageRandom();
    // THIS IS THE MENU OF THE APP
    public void showMenuOfAppListBooks(){
        var option = -1;
        String menu = """
                ### Welcome to your listBook ###
                1- Show url with random page!
                2- Show list of books in page
                3- Show ten random titles
                4- Search book by name
                
                """;
        System.out.println(menu);
        option = scanner.nextInt();
        scanner.nextLine();
                switch (option){
                    case 1:
                        System.out.println("We're looking the JSON...");
                        getNewUrlWithPageRandom();
                        break;
                    case 2:
                        System.out.println("searching Books in page");
                        getBooksFromPageRandom(urlRandom);
                        break;
                    case 3:
                        System.out.println("This are all titles in page");
                        showTenRandomTitles();
                        //showAllTitlesInPage();
                        break;
                    case 4:
                        System.out.println("Searching book by title...");
                        searchBookByTitle();
                        break;
                    default:
                        System.out.println("Option invalid, closing app...");
                }

    }

    private void showTenRandomTitles() {
        List<DataBook> tenBooks = getBooksFromPageRandom(urlRandom).results();
        tenBooks.stream().limit(10).forEach(System.out::println);
        

    }

    private ListBooksPage getBooksFromPageRandom(String url)
    {
        GetDataApi getDataApi = new GetDataApi();
        var json = getDataApi.getDataApi(url);
        var jsonBooks = convertBooks.getDataApi(json, ListBooksPage.class);
        return jsonBooks;
    }


    private String getNewUrlWithPageRandom(){
        String newUrl =  URL_BASE + getPageRandom();
        System.out.println("This is the URL of your request"+ newUrl);
        return newUrl;
    }

    // GET RANDOM PAGE FROM FIrST RESULT
    // return String.valueOf(randomPage);
    private String getPageRandom(){
        var json = getDataApi.getDataApi(URL_BASE);
        var countPagesApi = convertBooks.getDataApi(json, FirstSearchBook.class);
        int totalBooks = countPagesApi.count();
        int totalPages = totalBooks/32;
        System.out.println("Available BOOKs in API: " +totalBooks);
        System.out.println("Available PAGEs in API: " +totalPages);
        int randomPage = (int) (Math.random() * totalPages) + 1;
        System.out.println("Your random pages is: " + randomPage);
        return String.valueOf(randomPage);
    }
    private void searchBookByTitle(){
        System.out.println("Entry title book: ");
        var nameBook = scanner.nextLine().trim();

        //build the URL with the parameter of search
        String urlBookByName = URL_BASE + "&search=" + nameBook.replace(" ", "%20");

        System.out.println("Searching book related with: " + nameBook);

        try {
            // Get response of API
            var jsonResponse = getDataApi.getDataApi(urlBookByName);
            var booksPage = convertBooks.getDataApi(jsonResponse, ListBooksPage.class);

                if(booksPage.results().isEmpty()){
                    System.out.println("Sorry, title no found");
                } else {
                    System.out.println("Books find:");
                    booksPage.results().forEach(System.out::println);
                }
            // Evaluate if is there any result
        } catch (RuntimeException e) {
            System.out.println("¡Something is wrong!");
        }

    }

    }


