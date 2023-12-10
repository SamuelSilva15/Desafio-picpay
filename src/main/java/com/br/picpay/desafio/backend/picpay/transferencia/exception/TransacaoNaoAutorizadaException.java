package com.br.picpay.desafio.backend.picpay.transferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class TransacaoNaoAutorizadaException extends Exception {

    public TransacaoNaoAutorizadaException() {
        super("Transação não autorizada");
    }
}