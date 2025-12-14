package com.example.cuenta_mov.util.exception;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException() {
        super("Saldo no disponible");
    }
}