package com.sebrae.teste.sevice.impl;

import com.sebrae.teste.client.ViaCepClient;
import com.sebrae.teste.dto.CepDto;
import com.sebrae.teste.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepServiceImpl implements CepService {

    @Autowired
    private ViaCepClient client;

    @Override
    public CepDto buscarCep(String cep) {
        try {
            var result = client.buscarCep(cep);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
