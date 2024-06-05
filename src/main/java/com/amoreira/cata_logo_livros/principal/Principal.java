package com.amoreira.cata_logo_livros.principal;
import com.amoreira.cata_logo_livros.Repository.AuthorRepository;
import com.amoreira.cata_logo_livros.Repository.BookRepository;
import com.amoreira.cata_logo_livros.model.Author;
import com.amoreira.cata_logo_livros.model.Book;

import com.amoreira.cata_logo_livros.model.DataResponse;
import com.amoreira.cata_logo_livros.service.ConsumoApi;
import com.amoreira.cata_logo_livros.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Principal {

    private final Scanner input = new Scanner(System.in);
    List<DataResponse> dataResponses = new ArrayList<>();

    private static final String URL = "https://gutendex.com/books/";
    private static final String URLOption =  "?search=";
    //private String URLsearch;  //= "machado%20assis";

    private int opcao = -1;

    ConsumoApi buscar = new ConsumoApi();
    ConverteDados conversor = new ConverteDados();

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Principal(BookRepository bookRepository, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public void menu(){

        String menu = """
				 /////////////////////////////////////
				< Seja bem vindo ao Cata-Logo-Livros! >
				 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
				 
				1. busca livro pelo título;
				2. lista livros registrados;
				3. lista autores registrados;
				
				Digite 0 para sair.
				_____________________________________
				""";

        while (opcao != 0 ){

            System.out.println(menu);
            opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1){
                System.out.println("Digite o título do livro");

                searchBookWeb();

            }else if (opcao == 2){

                System.out.println("Digitou 2");
                listRegistredBooks();

            } else {
                System.out.println("Opção inválida \n" + menu);
                opcao = input.nextInt();

            }
        }
        System.out.println("Até logo");

    }

    private DataResponse getDadosRespostas(){

        String URLsearch = input.nextLine();

        var json = buscar.obterDados(URL+ URLOption +
                URLsearch.replace(" ", "%20"));

        return conversor.obterDados(json, DataResponse.class);

    }

    public void searchBookWeb(){

        DataResponse data = getDadosRespostas();
        System.out.println("Resposta inteira: " + data );

        Book book = new Book(data.results().get(0));
        System.out.println("\n" + "Livros: " + book);


        Author author = new Author(data.results().get(0).dataAuthor().get(0));

        //dadosRespostas.add(data);
        System.out.println("\n" + "Author: " + author);
        authorRepository.save(author);
        bookRepository.save(book);




        //resposta.forEach(t -> t.results().get(0));
//        System.out.println("Resposta parcelada : " + data.results().get(0).titleBook() +
//                "\nAutor: " + data.results().get(0).dataAuthor().get(0).nameAuthor());

        //        System.out.println(dadosResposta.results().get(0)
//                .dadosAutor().get(0).nameAuthor());
    }

    private void listRegistredBooks(){

//        List<Book> books = new ArrayList<>();
//        books = dadosRespostas.stream()
//                .map(b -> new Book(getDadosRespostas()))
//                .collect(Collectors.toList());
//        books.forEach(System.out::println);

    }

}
