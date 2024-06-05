package com.amoreira.cata_logo_livros.model;

import org.jetbrains.annotations.Nullable;

public enum Languages {
    EN("en"),
    ES("es"),
    FR("fr"),
    PT("pt")
    ;
    private final String languages;

    Languages(String languages) {
        this.languages = languages;
    }

    @Nullable
    //@org.jetbrains.annotations.Nullable
    public static Languages fromString(String text){

        for(Languages languages : Languages.values()){

            if (languages.languages.equalsIgnoreCase(text)){
                return languages;
            }
        }
        System.out.println("Nenhuma categoria encontrada");
        return null;
    }

}
