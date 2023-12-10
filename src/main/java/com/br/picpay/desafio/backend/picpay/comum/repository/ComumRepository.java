package com.br.picpay.desafio.backend.picpay.comum.repository;

import com.br.picpay.desafio.backend.picpay.comum.model.Comum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComumRepository extends JpaRepository<Comum, Long> {
}
