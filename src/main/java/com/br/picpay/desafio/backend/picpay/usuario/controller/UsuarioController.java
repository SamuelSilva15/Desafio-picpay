package com.br.picpay.desafio.backend.picpay.usuario.controller;

import com.br.picpay.desafio.backend.picpay.usuario.model.Usuario;
import com.br.picpay.desafio.backend.picpay.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/{usuarioId}")
    public Usuario buscarUsuarioPorId(@PathVariable("usuarioId") Long usuarioId) throws Exception {
        return usuarioService.buscarUsuarioPorId(usuarioId);
    }

    @GetMapping()
    public List<Usuario> buscarUsuarios() {
        return usuarioService.buscarUsuarios();
    }

    @PutMapping("/{usuarioId}")
    public Usuario salvarUsuario(@PathVariable("usuarioId") Long usuarioId, @RequestBody Usuario usuario) throws Exception {
        return usuarioService.atualizarUsuario(usuarioId, usuario);
    }
}