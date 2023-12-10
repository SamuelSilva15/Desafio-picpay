package com.br.picpay.desafio.backend.picpay.usuario.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CARTEIRA")
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CT_ID")
    private Long carteiraId;

    @Column(name = "CT_SALDO")
    private BigDecimal saldo;

    public Long getCarteiraId() {
        return carteiraId;
    }

    public void setCarteiraId(Long carteiraId) {
        this.carteiraId = carteiraId;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
