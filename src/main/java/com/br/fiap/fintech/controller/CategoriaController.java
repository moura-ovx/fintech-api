package com.br.fiap.fintech.controller;

import com.br.fiap.fintech.model.Categoria;
import com.br.fiap.fintech.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@Tag(name = "Categorias", description = "Endpoints para gerenciamento de categorias de receitas e despesas")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar nova categoria", description = "Cria uma nova categoria no banco de dados.")
    public Categoria salvar(@RequestBody  Categoria categoria){
        return categoriaService.salvar(categoria);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar categoria por ID", description = "Retorna os detalhes de uma categoria específica com base no ID fornecido.")
    public Categoria buscarPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar todas as categorias", description = "Retorna uma lista com todas as categorias cadastradas no sistema.")
    public List<Categoria> buscarTodos(){
        return categoriaService.buscarTodos();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar categoria", description = "Atualiza os dados de uma categoria existente.")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria){
        return categoriaService.atualizar(id, categoria);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir categoria", description = "Remove uma categoria do sistema com base no ID informado.")
    public void excluir(@PathVariable Long id){
        categoriaService.excluir(id);
    }
}
