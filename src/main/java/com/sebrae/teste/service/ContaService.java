package com.sebrae.teste.service;

import com.sebrae.teste.dto.DadosConta;
import com.sebrae.teste.entity.Conta;

import java.util.List;

public interface ContaService {

    Conta salvar(DadosConta dadosConta);

    Conta buscarPorId(Long id);

    DadosConta atualizar(Conta dadosConta);

    void remover(Long id);

   List<DadosConta> listar();

}
