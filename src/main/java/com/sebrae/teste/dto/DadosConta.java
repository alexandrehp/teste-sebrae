package com.sebrae.teste.dto;

import com.sebrae.teste.entity.Conta;

public record DadosConta(String nome, String descricao) {

   public DadosConta (Conta conta) {
       this(conta.getNome(), conta.getDescricao());
   }
}
