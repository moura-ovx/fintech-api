package com.br.fiap.fintech.controller;

import com.br.fiap.fintech.model.Lancamento;
import com.br.fiap.fintech.service.LancamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamentos")
@Tag(name = "Lançamentos", description = "Endpoints para gerenciamento de Lançamentos de receitas e despesas")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar novo lançamento", description = "Cria uma novo lançamento no banco de dados.")
    public Lancamento salvar(@RequestBody  Lancamento lancamento){
        return lancamentoService.salvar(lancamento);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar lançamento por ID", description = "Retorna os detalhes de um lançamento específico com base no ID fornecido.")
    public Lancamento buscarPorId(@PathVariable Long id){
        return lancamentoService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar todos os lançamentos", description = "Retorna uma lista com todos os lançamentos cadastrados no sistema.")
    public List<Lancamento> buscarTodos(){
        return lancamentoService.buscarTodos();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar lançamento", description = "Atualiza os dados de um lançamento existente.")
    public Lancamento atualizar(@PathVariable Long id, @RequestBody Lancamento lancamento){
        return lancamentoService.atualizar(id, lancamento);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir lançamento", description = "Remove um lançamento do sistema com base no ID informado.")
    public void excluir(@PathVariable Long id){
        lancamentoService.excluir(id);
    }
}
