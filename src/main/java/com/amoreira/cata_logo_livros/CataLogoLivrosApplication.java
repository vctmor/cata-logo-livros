package com.amoreira.cata_logo_livros;

import com.amoreira.cata_logo_livros.model.DadosAutor;
import com.amoreira.cata_logo_livros.model.DadosLivro;
import com.amoreira.cata_logo_livros.model.DadosResposta;
import com.amoreira.cata_logo_livros.model.Livro;
import com.amoreira.cata_logo_livros.service.ConverteDados;
import com.amoreira.cata_logo_livros.service.CosumoApi;

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

	private final Scanner input = new Scanner(System.in);

    public void menu(){

		String menu = """
				
				Seja bem vindo ao Cata-Logo-Livros!
				
				Digite 1 para buscar por autor
				Digite 1 para buscar por autor
				Digite 0 para sair.
				
				""";

		System.out.println(menu);
        int opcao = input.nextInt();


        while (opcao != 0 ){


			if (opcao == 1){
				System.out.println("Digitou 1");
				break;

			}else if (opcao == 2){

				System.out.println("Digitou 2");
				break;

			} else {
				System.out.println("Opção inválida \n" + menu);
				opcao = input.nextInt();

			}
		}
		System.out.println("Até logo");

	}

	public static void main(String[] args) {
		SpringApplication.run(CataLogoLivrosApplication.class, args);
	}
	private static final String URL = "https://gutendex.com/books/" + "?search=machado%20assis";
	private static final String URL2 ="https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c";
	private static final String URL3 = "https://gutendex.com/books/";
	private static final String URL4 = "https://gutendex.com/books/" + "?search=quincas%20borba";
	//@Override
	public void run(String... args) throws Exception {

		menu();
		CosumoApi busca = new CosumoApi();
		ConverteDados conversor = new ConverteDados();

		var json = busca.obterDados(URL4);
		System.out.println("Os dados:");
		System.out.println(json);

		DadosResposta dadosResposta = conversor.obterDados(json, DadosResposta.class) ;

		System.out.println(dadosResposta);

		List<DadosResposta> resposta = new ArrayList<>();

		resposta.add(dadosResposta);

		System.out.println(resposta.get(0).results().get(0).tituloLivro());


		System.out.println(dadosResposta.results().get(0)
				.dadosAutor().get(0).nomeAutor());



	}



}
