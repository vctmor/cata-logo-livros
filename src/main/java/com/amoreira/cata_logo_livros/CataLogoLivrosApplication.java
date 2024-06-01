package com.amoreira.cata_logo_livros;

import com.amoreira.cata_logo_livros.service.ConverteDados;
import com.amoreira.cata_logo_livros.service.CosumoApi;

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
	private static final String URL = "https://gutendex.com/books/" + "?search=machado%20assis";

	//@Override
	public void run(String... args) throws Exception {

		CosumoApi busca = new CosumoApi();
		ConverteDados converte = new ConverteDados();

		var json = busca.obterDados(URL);
		System.out.println("Os dados:");
		System.out.println(json);



	}

}
