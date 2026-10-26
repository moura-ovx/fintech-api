package com.br.fiap.fintech.controller;

import com.br.fiap.fintech.model.Usuario;
import com.br.fiap.fintech.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuários", description = "Endpoints para gerenciamento dos Usuários do sistema")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar novo usuário", description = "Cria um novo usuário no banco de dados.")
    public Usuario salvar(@RequestBody  Usuario usuario){
        return usuarioService.salvar(usuario);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar usuário por ID", description = "Retorna os detalhes de um usuário específico com base no ID fornecido.")
    public Usuario buscarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar todas os usuários cadastrados", description = "Retorna uma lista com todos os usuários cadastrados no sistema.")
    public List<Usuario> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar usuário", description = "Atualiza os dados de um usuário existente.")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.atualizar(id, usuario);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir usuário", description = "Remove um usuário do sistema com base no ID informado.")
    public void excluir(@PathVariable Long id){
        usuarioService.excluir(id);
    }
}
