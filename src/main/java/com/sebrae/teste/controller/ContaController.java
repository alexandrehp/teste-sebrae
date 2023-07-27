package com.sebrae.teste.controller;

import com.sebrae.teste.dto.DadosConta;
import com.sebrae.teste.entity.Conta;
import com.sebrae.teste.repository.ContaRepository;
import com.sebrae.teste.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity cadastrarConta(@RequestBody DadosConta conta) {
        var contaSalva = contaService.salvar(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaSalva);
    }

    @GetMapping
    public ResponseEntity listarContas() {
        var listaContas = contaService.listar();
        return ResponseEntity.ok().body(listaContas);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarContasPorId(@PathVariable Long id) {
        var conta = contaService.buscarPorId(id);
        return ResponseEntity.ok().body(conta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarConta(@PathVariable Long id) {
        contaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity atualizarConta(@RequestBody Conta conta) {
        var contaAtualizada = contaService.atualizar(conta);
        return ResponseEntity.ok().body(contaAtualizada);
    }

}
