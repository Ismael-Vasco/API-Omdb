package com.alura.screenmatch.modelos;

import java.util.ArrayList;
import java.util.List;

public class ListaTitulos {

    List<Titulo> titulos = new ArrayList<>();

    public void lista(Titulo pelicula) {
        this.titulos.add(pelicula);
    }

    public void VistaDeLista() {
        if (titulos.isEmpty()) {
            System.out.println("\nLista vacia");
        } else {
            System.out.println("\n***************************************");
            System.out.println(titulos);
            System.out.println("***************************************\n");
        }

    }
}
