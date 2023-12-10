package com.br.picpay.desafio.backend.picpay.usuario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(Long codigoPayer) {
        super("Seu saldo é insuficiente para realizar essa transferência: " + codigoPayer);
    }
}
