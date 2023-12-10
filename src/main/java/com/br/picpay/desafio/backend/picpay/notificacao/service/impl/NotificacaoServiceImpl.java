package com.br.picpay.desafio.backend.picpay.notificacao.service.impl;

import com.br.picpay.desafio.backend.picpay.notificacao.exception.ErroAoEnviarNotificacaoException;
import com.br.picpay.desafio.backend.picpay.notificacao.model.dto.NotificacaoDTO;
import com.br.picpay.desafio.backend.picpay.notificacao.service.NotificacaoService;
import com.br.picpay.desafio.backend.picpay.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void enviarNotificacao(Usuario usuario, String mensagem) throws Exception {
        String email = usuario.getEmail();
        NotificacaoDTO notificacaoDTO = new NotificacaoDTO(email, mensagem);

        Boolean notificacaoResponse = buscarNotificacaoAutorizada();

        if (!notificacaoResponse) {
            throw new ErroAoEnviarNotificacaoException();
        }
    }

    private Boolean buscarNotificacaoAutorizada() {
        ResponseEntity<NotificacaoDTO> response = restTemplate.getForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", NotificacaoDTO.class);
        return response.getStatusCode().equals(HttpStatus.OK);
    }
}