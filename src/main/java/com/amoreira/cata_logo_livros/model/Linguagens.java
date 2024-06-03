package com.amoreira.cata_logo_livros.model;

import org.jetbrains.annotations.Nullable;

public enum Linguagens {
    EN("en"),
    ES("es"),
    FR("fr"),
    PT("pt")
    ;
    private final String linguagens;

    Linguagens (String linguagens) {
        this.linguagens = linguagens;
    }

    @Nullable
    //@org.jetbrains.annotations.Nullable
    public static Linguagens fromString(String text){

        for(Linguagens linguegem : Linguagens.values()){

            if (linguegem.linguagens.equalsIgnoreCase(text)){
                return linguegem;
            }
        }
        System.out.println("Nenhuma categoria encontrada");
        return null;
    }

}
