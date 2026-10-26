package com.br.fiap.fintech.service;

import com.br.fiap.fintech.model.Usuario;
import com.br.fiap.fintech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id){

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()){
            return usuario.get();
        } else{
            throw new RuntimeException("Usuário não encontrado");
        }

    }

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()){
            usuarioRepository.deleteById(id);
        } else{
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public Usuario atualizar(Long id, Usuario usuario){
        Optional<Usuario> usuarioAtual = usuarioRepository.findById(id);

        if(usuarioAtual.isPresent()){
            return usuarioRepository.save(usuario);
        }else{
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
