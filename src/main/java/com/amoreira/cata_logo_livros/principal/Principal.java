package com.amoreira.cata_logo_livros.principal;
import com.amoreira.cata_logo_livros.Repository.AuthorRepository;
import com.amoreira.cata_logo_livros.Repository.BookRepository;
import com.amoreira.cata_logo_livros.model.Author;
import com.amoreira.cata_logo_livros.model.Book;

import com.amoreira.cata_logo_livros.model.DataAuthor;
import com.amoreira.cata_logo_livros.model.DataResponse;
import com.amoreira.cata_logo_livros.service.ConsumoApi;
import com.amoreira.cata_logo_livros.service.ConverteDados;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Principal {

    private final Scanner input = new Scanner(System.in);
    List<DataResponse> dataResponses = new ArrayList<>();
    List<Book> books = new ArrayList<>();
    List<Author> authors = new ArrayList<>();

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
                        < Seja bem vindo 
                                ao 
                        Cata-Logo-Livros! >
                 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
				 
				1. busca livro pelo título;
				2. lista livros registrados;
				3. lista autores registrados;
				4. listar autores vivos em determinado ano
				5. listrar livros em um determinado idioma
				
				Digite 0 para sair.
				_____________________________________
				
				""";

        while (opcao != 0 ){

            System.out.println(menu);
            System.out.print("Digite a sua opção: ");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("\n Digite o título do livro: ");
                    searchBookWeb();
                    break;
                case 2:

                    listRegistredBooks();
                    break;
                case 3:
                    System.out.print("\nDigite o ano: ");
                    listRegisteredAuthors();
                    System.out.println("\nListando autores registrados em ordem alfabética:\n");

                    break;
                case 4:

                    System.out.print("Digite a data: ");
                    listRegisteredLivingAuthorGivenYear();
                    break;
                case 5:
                    System.out.println("\nListando livros em um determinado idioma.");
                    break;
                default:
                    System.out.println("Opção inválida \n" + menu);
                    opcao = input.nextInt();
                    break;

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

    public void searchBookWeb() {

        DataResponse data = getDadosRespostas();
        System.out.println("Resposta inteira: " + data);
        relationBookWithAuthor(data);

    }
    public void relationBookWithAuthor(DataResponse data ) {
        DataAuthor dataAutor = data.results().get(0).dataAuthor().get(0);
        //new Author(dataAutor);
        Author author = new Author(dataAutor);
        Book book = new Book(data.results().get(0),author);

        author.setAuthorName(data.results().get(0).dataAuthor().get(0).nameAuthor());
        authorRepository.save(author);

        bookRepository.save(book);
        }

    private void listRegistredBooks(){

    books = bookRepository.findAll();
    books.stream()
            .sorted(Comparator.comparing(Book::getTitle))
            .forEach(System.out::println);

    }

    private void listRegisteredAuthors(){

        authors = authorRepository.findAll();
        authors.stream()
                .sorted(Comparator.comparing(Author::getAuthorName))
                .forEach(System.out::println);

    }

    private void listRegisteredLivingAuthorGivenYear(){

        Integer year = input.nextInt();

        authors = authorRepository.findAll();
        authors.stream()
                .filter(a ->a.getYearDeath() != null || a.getYearBirth() != null)
                .filter(a -> year >= a.getYearBirth() &&   year <= a.getYearDeath() )
                .sorted(Comparator.comparing(Author::getAuthorName))
                .forEach(System.out::println);
    }

}
