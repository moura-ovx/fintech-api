package com.br.fiap.fintech.repository;

import com.br.fiap.fintech.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
