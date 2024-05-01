package com.alura.screenmatch.principal;

import com.alura.screenmatch.excepcion.ErrorEnCorversionDeDuracionException;
import com.alura.screenmatch.modelos.*;

import java.io.*;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

    // link dinamico para interacción con el
        // Scanner
        Scanner teclado = new Scanner(System.in);
        // instancia de ConsultarTitulop
        ConsultarTtitulo consulta = new ConsultarTtitulo();
        // instancia de lista
        ListaTitulos list = new ListaTitulos();
        // instancia de Generador de archivos
        GeneradorDeArchivo archivo = new GeneradorDeArchivo();
        // instancia de Titulo para convertir
        Titulo cinta = new Titulo();


        while (true) {
            // Ingreso de datos de usuario
            System.out.println("Ingresa le nombre de la película: ");
            var busqueda = teclado.nextLine();
            // condición de salida
            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }

            try {
                // Buscar la pelicula
                cinta = consulta.buscarTitulo(busqueda);
                // añadir a la lista
                list.lista(cinta);
            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error!!");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección");
            } catch (ErrorEnCorversionDeDuracionException e) {
                System.out.println(e.getMessage());
            }

        }

        // print lista
        list.VistaDeLista();
        // convertir a .Json
        archivo.guardarJson(list);

        System.out.println("\nFin del programa!");
    }
}
