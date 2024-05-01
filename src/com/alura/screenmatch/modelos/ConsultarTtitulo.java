package com.alura.screenmatch.modelos;

import com.alura.screenmatch.excepcion.ErrorEnCorversionDeDuracionException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarTtitulo {

    public Titulo buscarTitulo(String titulo) {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        URI direccion = URI.create("http://www.omdbapi.com/?t=" + titulo
                .replace(" ", "+") +
                "&apikey=a955e4f3");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            TituloOmdb miTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);

            //System.out.println("visualización de miTituloOmdb dentro dle ConsultarTitulo: " + miTituloOmdb);

            Titulo nuevo = new Titulo(miTituloOmdb);
            System.out.println("\n***************************************************************************************");
            System.out.println("Datos: "
                    + nuevo + "");
            System.out.println("***************************************************************************************\n");
            return nuevo;

        } catch (Exception e) {
            throw new ErrorEnCorversionDeDuracionException("""
                    \n****************¡ERROR!****************
                    Tiene: Nombre erroneo o un contiene 'N/A' \n""");
        }
    }
}