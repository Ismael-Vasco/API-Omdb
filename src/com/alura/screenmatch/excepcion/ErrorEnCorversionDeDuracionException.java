package com.alura.screenmatch.excepcion;

public class ErrorEnCorversionDeDuracionException extends RuntimeException{
    private String mensaje;

    public ErrorEnCorversionDeDuracionException(String mensaje) {
        this.mensaje = mensaje;

    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
