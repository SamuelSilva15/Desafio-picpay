package com.br.picpay.desafio.backend.picpay.lojista.model;

import com.br.picpay.desafio.backend.picpay.usuario.model.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "LOJISTA")
public class Lojista extends Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LJ_ID")
    private Long lojistaId;

    public Long getLojistaId() {
        return lojistaId;
    }

    public void setLojistaId(Long lojistaId) {
        this.lojistaId = lojistaId;
    }
}
