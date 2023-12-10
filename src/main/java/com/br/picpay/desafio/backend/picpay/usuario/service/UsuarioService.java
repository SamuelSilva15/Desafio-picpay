package com.br.picpay.desafio.backend.picpay.usuario.service;

import com.br.picpay.desafio.backend.picpay.usuario.model.Usuario;
import com.br.picpay.desafio.backend.picpay.transferencia.model.dto.TransferenciaDTO;

import java.util.List;

public interface UsuarioService {

    void validarUsuario(TransferenciaDTO transferencia) throws Exception;

    Usuario salvarUsuario(Usuario usuario);

    Usuario buscarUsuarioPorId(Long usuarioId) throws Exception;

    List<Usuario> buscarUsuarios();

    Usuario atualizarUsuario(Long usuarioId, Usuario usuario) throws Exception;
}
