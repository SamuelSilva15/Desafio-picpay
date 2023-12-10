package com.br.picpay.desafio.backend.picpay.notificacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ErroAoEnviarNotificacaoException extends Exception {

    public ErroAoEnviarNotificacaoException() {
        super("Erro ao enviar notificação.");
    }
}
