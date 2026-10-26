package com.br.fiap.fintech.controller;

import com.br.fiap.fintech.model.Meta;
import com.br.fiap.fintech.service.MetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
@Tag(name = "Metas", description = "Endpoints para gerenciamento de metas do usuário")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ Operation(summary = "Cadastrar nova meta", description = "Cria uma nova meta no banco de dados.")
    public Meta salvar(@RequestBody Meta meta){
        return metaService.salvar(meta);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar meta por ID", description = "Retorna os detalhes de uma meta específica com base no ID fornecido.")
    public Meta buscarPorId(@PathVariable Long id){
        return metaService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar todas as metas", description = "Retorna uma lista com todas as metas cadastradas no sistema.")
    public List<Meta> buscarTodos(){
        return metaService.buscarTodos();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar meta", description = "Atualiza os dados de uma meta existente.")
    public Meta atualizar(@PathVariable Long id, @RequestBody Meta meta){
        return metaService.atualizar(id, meta);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir meta", description = "Remove uma meta do sistema com base no ID informado.")
    public void excluir(@PathVariable Long id){
        metaService.excluir(id);
    }
}
