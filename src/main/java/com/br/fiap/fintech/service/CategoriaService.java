package com.br.fiap.fintech.service;

import com.br.fiap.fintech.model.Categoria;
import com.br.fiap.fintech.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria buscarPorId(Long id){

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if(categoria.isPresent()){
            return categoria.get();
        } else{
            throw new RuntimeException("Categoria não encontrada");
        }

    }

    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if(categoria.isPresent()){
            categoriaRepository.deleteById(id);
        } else{
            throw new RuntimeException("Categoria não encontrada");
        }
    }

    public Categoria atualizar(Long id, Categoria usuario){
        Optional<Categoria> categoriaAtual = categoriaRepository.findById(id);

        if(categoriaAtual.isPresent()){
            return categoriaRepository.save(usuario);
        }else{
            throw new RuntimeException("Categoria não encontrada");
        }
    }
}
