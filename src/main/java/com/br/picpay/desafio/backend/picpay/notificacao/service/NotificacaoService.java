package com.br.picpay.desafio.backend.picpay.notificacao.service;

import com.br.picpay.desafio.backend.picpay.notificacao.model.dto.NotificacaoDTO;
import com.br.picpay.desafio.backend.picpay.usuario.model.Usuario;

public interface NotificacaoService {

    void enviarNotificacao(Usuario usuario, String mensagem) throws Exception;
}
