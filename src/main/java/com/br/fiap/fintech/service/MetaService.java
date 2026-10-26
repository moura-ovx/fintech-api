package com.br.fiap.fintech.service;

import com.br.fiap.fintech.model.Meta;
import com.br.fiap.fintech.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {
    @Autowired
    private MetaRepository metaRepository;

    public Meta salvar(Meta lancamento){
        return metaRepository.save(lancamento);
    }

    public Meta buscarPorId(Long id){

        Optional<Meta> meta = metaRepository.findById(id);

        if(meta.isPresent()){
            return  meta.get();
        } else{
            throw new RuntimeException("Meta não encontrada");
        }
    }

    public List<Meta> buscarTodos(){
        return metaRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Meta> meta = metaRepository.findById(id);

        if(meta.isPresent()){
            metaRepository.deleteById(id);
        } else{
            throw new RuntimeException("Meta não encontrada");
        }
    }

    public Meta atualizar(Long id, Meta meta){
        Optional<Meta> metaAtual = metaRepository.findById(id);

        if(metaAtual.isPresent()){
            return metaRepository.save(meta);
        }else{
            throw new RuntimeException("Meta não encontrada");
        }
    }
}
