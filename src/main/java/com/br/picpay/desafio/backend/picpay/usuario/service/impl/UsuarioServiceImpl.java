package com.br.picpay.desafio.backend.picpay.usuario.service.impl;

import com.br.picpay.desafio.backend.picpay.usuario.exception.PermissaoUsuarioException;
import com.br.picpay.desafio.backend.picpay.usuario.model.Carteira;
import com.br.picpay.desafio.backend.picpay.usuario.model.CarteiraRepository;
import com.br.picpay.desafio.backend.picpay.usuario.model.Usuario;
import com.br.picpay.desafio.backend.picpay.usuario.model.UsuarioTypeEnum;
import com.br.picpay.desafio.backend.picpay.usuario.repository.UsuarioRepository;
import com.br.picpay.desafio.backend.picpay.usuario.service.UsuarioService;
import com.br.picpay.desafio.backend.picpay.usuario.exception.SaldoInsuficienteException;
import com.br.picpay.desafio.backend.picpay.transferencia.model.dto.TransferenciaDTO;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarteiraRepository carteiraRepository;

    public void validarUsuario(TransferenciaDTO transferencia) throws Exception {
        Usuario user = buscarUsuarioPorId(transferencia.getSenderId());

        if(Objects.nonNull(user.getUsuarioTypeEnum())) {
            if (user.getUsuarioTypeEnum().equals(UsuarioTypeEnum.LOJISTA)) {
                throw new PermissaoUsuarioException(user.getUsuarioId());
            }
        }

        if(transferencia.getValor().compareTo(user.getCarteira().getSaldo()) > 0) {
            throw new SaldoInsuficienteException(user.getUsuarioId());
        }
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        carteiraRepository.save(usuario.getCarteira());
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorId(Long usuarioId) throws Exception {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    @Override
    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario atualizarUsuario(Long usuarioId, Usuario usuario) throws Exception {
        Usuario usuarioEncontrado = buscarUsuarioPorId(usuarioId);
        usuarioEncontrado.setNome(Objects.nonNull(usuario.getNome()) ? usuario.getNome() : usuarioEncontrado.getNome());
        usuarioEncontrado.setEmail(Objects.nonNull(usuario.getSenha()) ? usuario.getSenha() : usuarioEncontrado.getSenha());
        usuarioEncontrado.setSenha(Objects.nonNull(usuario.getCpfCnpj()) ? usuario.getCpfCnpj() : usuarioEncontrado.getCpfCnpj());
        usuarioEncontrado.setCarteira(Objects.nonNull(usuario.getCarteira()) ? usuario.getCarteira() : usuarioEncontrado.getCarteira());
        usuarioEncontrado.setUsuarioTypeEnum(Objects.nonNull(usuario.getUsuarioTypeEnum()) ? usuario.getUsuarioTypeEnum() : usuarioEncontrado.getUsuarioTypeEnum());

        return usuarioEncontrado;
    }

}
