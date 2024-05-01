package com.alura.screenmatch.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    ListaTitulos list = new ListaTitulos();
    public void guardarJson(ListaTitulos cinta) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        FileWriter escritura = new FileWriter("Titulos.json");
        escritura.write(gson.toJson(cinta));
        escritura.close();

        
    }
}
