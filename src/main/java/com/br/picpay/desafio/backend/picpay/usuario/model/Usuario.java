package com.br.picpay.desafio.backend.picpay.usuario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "US_ID")
    private Long usuarioId;

    @Column(name = "US_NOME")
    private String nome;

    @Column(name = "US_EMAIL")
    private String email;

    @Column(name = "US_SENHA")
    private String senha;

    @Column(name = "US_CPF_CNPJ")
    private String cpfCnpj;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CT_ID")
    private Carteira carteira;

    @Enumerated
    @JoinColumn(name = "US_TYPE")
    private UsuarioTypeEnum usuarioTypeEnum;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public UsuarioTypeEnum getUsuarioTypeEnum() {
        return usuarioTypeEnum;
    }

    public void setUsuarioTypeEnum(UsuarioTypeEnum usuarioTypeEnum) {
        this.usuarioTypeEnum = usuarioTypeEnum;
    }
}
