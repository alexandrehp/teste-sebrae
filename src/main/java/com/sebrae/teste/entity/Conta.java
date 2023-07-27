package com.sebrae.teste.entity;


import javax.persistence.*;

import com.sebrae.teste.dto.DadosConta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    public Conta(DadosConta conta) {
        this.nome = conta.nome();
        this.descricao = conta.descricao();
    }
}
