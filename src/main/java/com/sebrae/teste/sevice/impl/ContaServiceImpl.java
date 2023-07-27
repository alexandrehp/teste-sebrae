package com.sebrae.teste.sevice.impl;

import com.sebrae.teste.dto.DadosConta;
import com.sebrae.teste.entity.Conta;
import com.sebrae.teste.repository.ContaRepository;
import com.sebrae.teste.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public Conta salvar(DadosConta dadosConta) {
        var novaConta = new Conta(dadosConta);
        return contaRepository.save(novaConta);
    }

    @Override
    public Conta buscarPorId(Long id) {
        var conta = contaRepository.findById(id);
        if (conta.isPresent()){
            return conta.get();
        } else {
            return null;
        }

    }

    @Override
    public DadosConta atualizar(Conta conta) {
        var contaOptional = contaRepository.findById(conta.getId());
        Conta contaAtualizar = new Conta();
        contaAtualizar.setNome(conta.getNome());
        contaAtualizar.setDescricao(conta.getDescricao());
        if (contaOptional.isPresent()) {
            contaAtualizar.setId(conta.getId());
        }
        var contaAtualizada = contaRepository.save(contaAtualizar);

        return new DadosConta(contaAtualizada);
    }

    @Override
    public void remover(Long id) {
        contaRepository.deleteById(id);
    }

    @Override
    public List<DadosConta> listar() {
        var contas = contaRepository.findAll();
        List<DadosConta> listaContas = contas.stream().map(DadosConta::new).toList();
        return listaContas;
    }
}
