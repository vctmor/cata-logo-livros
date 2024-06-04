package com.amoreira.cata_logo_livros.principal;
import com.amoreira.cata_logo_livros.model.DadosResposta;
import com.amoreira.cata_logo_livros.model.DadosResposta;
import com.amoreira.cata_logo_livros.service.ConsumoApi;
import com.amoreira.cata_logo_livros.service.ConverteDados;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Principal {

    private final Scanner input = new Scanner(System.in);
    List<DadosResposta> dataBook = new ArrayList<>();

    private static final String URL = "https://gutendex.com/books/";
    private static final String URLOption =  "?search=";
    //private String URLsearch;  //= "machado%20assis";

    private int opcao = -1;

    ConsumoApi buscar = new ConsumoApi();
    ConverteDados conversor = new ConverteDados();


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

    public void searchBookWeb(){

        DadosResposta data = getDataBook();

        dataBook.add(data);

        System.out.println("Resposta inteira: " + data );

        //resposta.forEach(t -> t.results().get(0));
        System.out.println("Resposta parcelada : " + data.results().get(0).tituloLivro() +
                "\nAutor: " + data.results().get(0).dadosAutor().get(0).nomeAutor());

        //        System.out.println(dadosResposta.results().get(0)
//                .dadosAutor().get(0).nomeAutor());
    }


    private DadosResposta getDataBook(){

        String URLsearch = input.nextLine();

        var json = buscar.obterDados(URL+ URLOption +
                URLsearch.replace(" ", "%20"));

        return conversor.obterDados(json, DadosResposta.class);

    }

    private void listRegistredBooks(){

        List<Book> books = new ArrayList<>();
        books = dataBook.stream()
                .map(b -> new Book())
                .collect(Collectors.toList());
        books.forEach(System.out::println);
    }

}
