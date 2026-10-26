package com.br.fiap.fintech.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FIN_CATEGORIA")
public class Categoria {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CATEGORIA"
    )
    @SequenceGenerator(
            name = "SEQ_CATEGORIA",
            sequenceName = "SEQ_CATEGORIA",
            allocationSize = 1
    )
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nm_categoria", length = 50, nullable = false)
    private String nome;

    public Categoria() {
    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
