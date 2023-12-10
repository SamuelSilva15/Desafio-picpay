package com.br.picpay.desafio.backend.picpay.transferencia.repository;

import com.br.picpay.desafio.backend.picpay.transferencia.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT tf FROM Transferencia tf WHERE tf.receiver.usuarioId = ?1 OR tf.sender.usuarioId = ?1")
    List<Transferencia> findByUsuarioId(Long usuarioId);
}
