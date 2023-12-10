package com.br.picpay.desafio.backend.picpay.usuario.repository;

import com.br.picpay.desafio.backend.picpay.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UsuarioRepository extends JpaRepository<Usuario, Long> {
}
