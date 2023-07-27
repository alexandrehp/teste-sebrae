package com.sebrae.teste.client;

import com.sebrae.teste.dto.CepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.*;

@FeignClient(name = "ViaCepClient", url = "www.viacep.com.br")
public interface ViaCepClient {

    @GetMapping(value = "/ws/{cep}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    CepDto buscarCep(@PathVariable(value = "cep") String cep);
}
