package com.amoreira.cata_logo_livros;

import com.amoreira.cata_logo_livros.model.DadosResposta;
import com.amoreira.cata_logo_livros.principal.Principal;
import com.amoreira.cata_logo_livros.service.ConverteDados;
import com.amoreira.cata_logo_livros.service.ConsumoApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// "https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c"
//http://gutendex.com/books?search=machado%20assis");
@SpringBootApplication
public class CataLogoLivrosApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(CataLogoLivrosApplication.class, args);
	}

	private static final String URL2 ="https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c";
	private static final String URL3 = "https://gutendex.com/books/";
	private static final String URL4 = "https://gutendex.com/books/" + "?search=quincas%20borba";
	//@Override
	public void run(String... args) throws Exception {

		Principal start = new Principal();

		start.menu();

//		ConsumoApi busca = new ConsumoApi();
//		ConverteDados conversor = new ConverteDados();
//
//		var json = busca.obterDados(URL4);
//		System.out.println("Os dados:");
//		System.out.println(json);
//
//		DadosResposta dadosResposta = conversor.obterDados(json, DadosResposta.class) ;
//
//		System.out.println(dadosResposta);
//
//		List<DadosResposta> resposta = new ArrayList<>();
//
//		resposta.add(dadosResposta);
//
//		System.out.println(resposta.get(0).results().get(0).tituloLivro());






	}



}
