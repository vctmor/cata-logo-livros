package com.amoreira.cata_logo_livros;

import com.amoreira.cata_logo_livros.Repository.AuthorRepository;
import com.amoreira.cata_logo_livros.Repository.BookRepository;
import com.amoreira.cata_logo_livros.principal.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// "https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c"
//http://gutendex.com/books?search=machado%20assis");
@SpringBootApplication
public class CataLogoLivrosApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(CataLogoLivrosApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	//@Override
	public void run(String... args) throws Exception {

		Principal start = new Principal(bookRepository,authorRepository);

		start.menu();
	}

}
