package com.br.picpay.desafio.backend.picpay.transferencia.controller;

import com.br.picpay.desafio.backend.picpay.transferencia.model.Transferencia;
import com.br.picpay.desafio.backend.picpay.transferencia.model.dto.TransferenciaDTO;
import com.br.picpay.desafio.backend.picpay.transferencia.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="api/v1/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping
    public List<Transferencia> buscarTransferencias() {
        return transferenciaService.buscarTransferencias();
    }

    @PostMapping
    public Transferencia salvarTransferencia(@RequestBody TransferenciaDTO transferenciaDTO) throws Exception {
        return transferenciaService.realizarTransferencia(transferenciaDTO);
    }

    @GetMapping("/{usuarioId}/transferenciaPorUsuario")
    public List<Transferencia> buscarTransferenciaPorUsuario(@PathVariable("usuarioId") Long usuarioId){
        return transferenciaService.buscarTransferenciasPorUsuario(usuarioId);
    }
}
