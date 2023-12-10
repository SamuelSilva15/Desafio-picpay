package com.br.picpay.desafio.backend.picpay.transferencia.model.dto;

import com.br.picpay.desafio.backend.picpay.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferenciaDTO {

    private Long transferenciaId;


    private BigDecimal valor;

    private Long senderId;

    private Long receiverId;

    public Long getTransferenciaId() {
        return transferenciaId;
    }

    public void setTransferenciaId(Long transferenciaId) {
        this.transferenciaId = transferenciaId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }
}
