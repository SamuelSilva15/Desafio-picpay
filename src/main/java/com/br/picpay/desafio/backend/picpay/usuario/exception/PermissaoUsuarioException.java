package com.br.picpay.desafio.backend.picpay.usuario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PermissaoUsuarioException extends Exception{

    public PermissaoUsuarioException(Long codigoPayer) {
        super("O usuário não tem permissão para efetuar a transação: " + codigoPayer);
    }
}
