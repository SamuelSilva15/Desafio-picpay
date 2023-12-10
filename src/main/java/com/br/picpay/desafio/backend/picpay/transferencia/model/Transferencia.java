package com.br.picpay.desafio.backend.picpay.transferencia.model;

import com.br.picpay.desafio.backend.picpay.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSFERENCIA")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TF_ID")
    private Long transferenciaId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "TF_DATA")
    private LocalDateTime data;

    @Column(name = "TF_VALOR")
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "US_ID")
    private Usuario sender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CM_ID")
    private Usuario receiver;

    public Long getTransferenciaId() {
        return transferenciaId;
    }

    public void setTransferenciaId(Long transferenciaId) {
        this.transferenciaId = transferenciaId;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Usuario getSender() {
        return sender;
    }

    public void setSender(Usuario sender) {
        this.sender = sender;
    }

    public Usuario getReceiver() {
        return receiver;
    }

    public void setReceiver(Usuario receiver) {
        this.receiver = receiver;
    }
}
