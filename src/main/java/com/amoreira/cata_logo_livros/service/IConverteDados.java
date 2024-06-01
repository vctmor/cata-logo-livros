package com.amoreira.cata_logo_livros.service;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);
}
