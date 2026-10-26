package com.br.fiap.fintech.repository;

import com.br.fiap.fintech.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
