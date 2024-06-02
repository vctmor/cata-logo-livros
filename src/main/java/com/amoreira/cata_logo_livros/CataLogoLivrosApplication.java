package com.amoreira.cata_logo_livros;

import com.amoreira.cata_logo_livros.model.DadosResposta;
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
	private static final String URL2 ="https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c";
	private static final String URL3 = "https://gutendex.com/books/";
	private static final String URL4 = "https://gutendex.com/books/" + "?search=crime%20castigo";
	//@Override
	public void run(String... args) throws Exception {

		CosumoApi busca = new CosumoApi();
		ConverteDados conversor = new ConverteDados();

		var json = busca.obterDados(URL3);
		System.out.println("Os dados:");
		System.out.println(json);

		DadosResposta dadosResposta = conversor.obterDados(json, DadosResposta.class) ;

		System.out.println(dadosResposta);



	}

}
