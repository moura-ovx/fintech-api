package com.br.fiap.fintech.service;

import com.br.fiap.fintech.model.Lancamento;
import com.br.fiap.fintech.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento buscarPorId(Long id){

        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);

        if(lancamento.isPresent()){
            return lancamento.get();
        } else{
            throw new RuntimeException("Lançamento não encontrado");
        }
    }

    public List<Lancamento> buscarTodos(){
        return lancamentoRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);

        if(lancamento.isPresent()){
            lancamentoRepository.deleteById(id);
        } else{
            throw new RuntimeException("Lançamento não encontrado");
        }
    }

    public Lancamento atualizar(Long id, Lancamento lancamento){
        Optional<Lancamento> lancamentoAtual = lancamentoRepository.findById(id);

        if(lancamentoAtual.isPresent()){
            return lancamentoRepository.save(lancamento);
        }else{
            throw new RuntimeException("Lançamento não encontrado");
        }
    }

}
