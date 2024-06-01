
## Instruções:

// Define a classe ConsumoApi
// Define o método obterDados que aceita um parâmetro de endereço
// Cria uma nova instância de HttpClient
// Cria uma nova solicitação HTTP com o endereço fornecido
// Configura a solicitação HTTP com o URI fornecido e constrói a solicitação
// Inicializa a variável de resposta como nula
// Inicia um bloco try-catch para capturar exceções
// Envia a solicitação HTTP e armazena a resposta na variável response
// Captura a exceção IOException e lança uma RuntimeException com a causa original
// Captura a exceção InterruptedException e lança uma RuntimeException com a causa original
// Obtém o corpo da resposta HTTP como uma string JSON
// Retorna a string JSON

## Código comentado

```java
package br.com.alura.screenmatch.service;

public class ConsumoApi {
    

    // Criação do método obterDados que recebe um endereço como parâmetro
    public String obterDados(String endereco) {
        // Criação de uma instância do HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // Criação de uma instância do HttpRequest com o endereço fornecido
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        // Inicialização da variável de resposta
        HttpResponse<String> response;
        try {
            // Envio da requisição e obtenção da resposta
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            // Tratamento de exceção para erros de I/O
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            // Tratamento de exceção para interrupção da thread
            throw new RuntimeException(e);
        }

        // Obtém o corpo da resposta (geralmente em formato JSON)
        String json = response.body();
        // Retorna o JSON obtido
        return json;
    }
}
```

Espero que isso ajude! Se você tiver mais alguma dúvida, é só perguntar. 😊⁴

Fonte: conversa com o Copilot, 01/06/2024
(1) Como comentar um bloco de código em Python | DataCamp. https://www.datacamp.com/pt/tutorial/python-block-comment.
(2) Programar em C - Fazer Comentários em C | Caractere Nova Linha \n - Aula 3. https://www.youtube.com/watch?v=1SJpRqQSfac.
(3) Pythontutor – Visualizando o que cada linha do seu código faz. https://wagnergaspar.com/pythontutor-visualizando-o-que-cada-linha-do-seu-codigo-faz/.
(4) Comentar linhas de código muito rápido no VSCODE utilizando atalhos de teclados - dicas do VSCODE. https://www.youtube.com/watch?v=cSW7bf6_tpY.
(5) Observe o trecho de código abaixo: < > - Brainly. https://bing.com/search?q=comente+cada+linha+de+c%c3%b3digo+abaixo.
(6) Observe o trecho de código abaixo: < > - Brainly. https://brainly.com.br/tarefa/57822830.
(7) Analise as linhas de código abaixo, e assinale a alternativa que .... https://brainly.com.br/tarefa/57984984.