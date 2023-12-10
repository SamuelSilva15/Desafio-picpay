package com.br.picpay.desafio.backend.picpay.comum.model;

import com.br.picpay.desafio.backend.picpay.usuario.model.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "COMUM")
public class Comum extends Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CM_ID")
    private Long comumId;

    public Long getComumId() {
        return comumId;
    }

    public void setComumId(Long comumId) {
        this.comumId = comumId;
    }
}
