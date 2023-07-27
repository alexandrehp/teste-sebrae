package com.sebrae.teste;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebrae.teste.dto.DadosConta;
import com.sebrae.teste.entity.Conta;
import com.sebrae.teste.repository.ContaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ContaController {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosConta> dadosContaJson;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ContaRepository contaRepository;

    @Test
    void cadastrar_conta() throws Exception {

        var dadosConta = new DadosConta("Alexandre", "Teste");

        //when(contaRepository.save(any())).thenReturn(new Conta(dadosConta));

        var response = mvc.perform(
                        post("/conta")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(dadosContaJson.write(dadosConta).getJson()))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

    }

}
