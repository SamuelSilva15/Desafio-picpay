package com.br.picpay.desafio.backend.picpay.transferencia.service;

import com.br.picpay.desafio.backend.picpay.transferencia.model.Transferencia;
import com.br.picpay.desafio.backend.picpay.transferencia.model.dto.TransferenciaDTO;

import java.util.List;

public interface TransferenciaService {

    List<Transferencia> buscarTransferencias();

    Transferencia realizarTransferencia(TransferenciaDTO transferencia) throws Exception;

    List<Transferencia> buscarTransferenciasPorUsuario(Long usuarioId);
}
