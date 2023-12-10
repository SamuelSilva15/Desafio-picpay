package com.br.picpay.desafio.backend.picpay.transferencia.service.impl;

import com.br.picpay.desafio.backend.picpay.notificacao.service.NotificacaoService;
import com.br.picpay.desafio.backend.picpay.transferencia.exception.TransacaoNaoAutorizadaException;
import com.br.picpay.desafio.backend.picpay.transferencia.model.Transferencia;
import com.br.picpay.desafio.backend.picpay.transferencia.model.dto.TransferenciaDTO;
import com.br.picpay.desafio.backend.picpay.transferencia.repository.TransferenciaRepository;
import com.br.picpay.desafio.backend.picpay.transferencia.service.TransferenciaService;
import com.br.picpay.desafio.backend.picpay.usuario.model.Usuario;
import com.br.picpay.desafio.backend.picpay.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Transferencia> buscarTransferencias() {
        return transferenciaRepository.findAll();
    }

    public Transferencia realizarTransferencia(TransferenciaDTO transferencia) throws Exception {
        Usuario sender = usuarioService.buscarUsuarioPorId(transferencia.getSenderId());
        Usuario receiver = usuarioService.buscarUsuarioPorId(transferencia.getReceiverId());
        usuarioService.validarUsuario(transferencia);

        Boolean autorizado = validarTransferencia();
        if(!autorizado) {
            throw new TransacaoNaoAutorizadaException();
        }

        Transferencia novaTransferencia = calculaTransferencia(transferencia, sender, receiver);
        salvarUsuarios(sender, receiver);

        enviarNotificacao(sender, receiver);

        novaTransferencia.setData(LocalDateTime.now());
        return transferenciaRepository.save(novaTransferencia);
    }

    public List<Transferencia> buscarTransferenciasPorUsuario(Long usuarioId) {
        return transferenciaRepository.findByUsuarioId(usuarioId);
    }

    private void enviarNotificacao(Usuario sender, Usuario receiver) throws Exception {
        notificacaoService.enviarNotificacao(sender, "Transação realizada com sucesso");
        notificacaoService.enviarNotificacao(receiver, "Você recebeu uma transação");
    }

    private void salvarUsuarios(Usuario sender, Usuario receiver) {
        usuarioService.salvarUsuario(sender);
        usuarioService.salvarUsuario(receiver);
    }

    private static Transferencia calculaTransferencia(TransferenciaDTO transferencia, Usuario sender, Usuario receiver) {
        Transferencia novaTransferencia = converterTransferencia(transferencia, sender, receiver);
        sender.getCarteira().setSaldo(sender.getCarteira().getSaldo().subtract(transferencia.getValor()));
        receiver.getCarteira().setSaldo(receiver.getCarteira().getSaldo().add(transferencia.getValor()));
        return novaTransferencia;
    }

    private static Transferencia converterTransferencia(TransferenciaDTO transferencia, Usuario sender, Usuario receiver) {
        Transferencia novaTransferencia = new Transferencia();
        novaTransferencia.setTransferenciaId(transferencia.getTransferenciaId());
        novaTransferencia.setValor(transferencia.getValor());
        novaTransferencia.setSender(sender);
        novaTransferencia.setReceiver(receiver);
        return novaTransferencia;
    }

    private Boolean validarTransferencia() {
        ResponseEntity<Map> authorizeTemplate = restTemplate.getForEntity(
                "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);

        if (authorizeTemplate.getStatusCode().equals(HttpStatus.OK)) {
            String message = (String) authorizeTemplate.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        } else return false;
    }
}