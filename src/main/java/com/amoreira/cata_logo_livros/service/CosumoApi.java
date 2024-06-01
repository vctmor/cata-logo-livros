package com.amoreira.cata_logo_livros.service;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CosumoApi {

   // Define o método obterDados que aceita um parâmetro de endereço
    public String obterDados(String endereco){
        // Cria uma nova instância de HttpClient
        HttpClient cliente = HttpClient.newHttpClient();
        // Configura a solicitação HTTP com o URI fornecido
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build(); //e constrói a solicitação

        System.out.println("Request: " + request);

// Inicializa a variável de resposta como nula
        HttpResponse<String> response = null;
// Inicia um bloco try-catch para capturar exceções
        try {
            // Envia a solicitação HTTP e armazena a resposta na variável response
            response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("response: " + response);

        } catch (IOException e) {
            // Tratamento de exceção para erros de I/O
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            // Tratamento de exceção para interrupção da thread
            throw new RuntimeException(e);
        }


        System.out.println("response body: " + response.body());
        // Obtém e retorna o corpo da resposta HTTP como uma string JSON
         return response.body();
    }



}
