package com.sebrae.teste.controller;

import com.sebrae.teste.dto.CepDto;
import com.sebrae.teste.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping("/{numero}")
    public ResponseEntity<?> getCep(@PathVariable String numero) {
        var cepRetorno = cepService.buscarCep(numero);
        return ResponseEntity.ok(cepRetorno);
    }

}
