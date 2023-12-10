package com.br.picpay.desafio.backend.picpay.lojista.repository;

import com.br.picpay.desafio.backend.picpay.comum.model.Comum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojistaRepository extends JpaRepository<Comum, Long> {
}
