package com.br.fiap.fintech.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_FIN_LANCAMENTO")
public class Lancamento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_LANCAMENTO"
    )
    @SequenceGenerator(
            name = "SEQ_LANCAMENTO",
            sequenceName = "SEQ_LANCAMENTO",
            allocationSize = 1
    )
    @Column(name = "id_lancamento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_tipo", length = 7, nullable = false)
    private TipoLancamento tipo;

    @Column(name = "vl_valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "dt_criado_em", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Define o padrão de data no json
    private LocalDateTime criadoEm = LocalDateTime.now();

    public Lancamento() {}

    public Lancamento(Long id, Usuario usuario, Categoria categoria, TipoLancamento tipo, BigDecimal valor) {
        this.id = id;
        this.usuario = usuario;
        this.categoria = categoria;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}