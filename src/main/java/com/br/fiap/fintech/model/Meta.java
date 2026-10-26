package com.br.fiap.fintech.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_FIN_META")
public class Meta {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_META"
    )
    @SequenceGenerator(
            name = "SEQ_META",
            sequenceName = "SEQ_META",
            allocationSize = 1
    )
    @Column(name = "id_meta")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "nm_meta", length = 100, nullable = false)
    private String nome;

    @Column(name = "vl_total", precision = 10, scale = 2, nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "vl_atual", precision = 10, scale = 2, nullable = false)
    private BigDecimal valorAtual;

    @Column(name = "dt_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "dt_final", nullable = false)
    private LocalDate dataFinal;

    @Enumerated(EnumType.STRING)
    @Column(name = "st_meta", length = 10, nullable = false)
    private StatusMeta status;

    @Column(name = "dt_criado_em", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Define o padrão de data no json
    private LocalDateTime criadoEm = LocalDateTime.now();

    public Meta() {}

    public Meta(Long id, Usuario usuario, String nome, BigDecimal valorTotal, BigDecimal valorAtual,
                LocalDate dataInicio, LocalDate dataFinal, StatusMeta status) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.valorTotal = valorTotal;
        this.valorAtual = (valorAtual != null) ? valorAtual : BigDecimal.ZERO;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.status = (status != null) ? status : StatusMeta.ATIVA;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(BigDecimal valorAtual) {
        this.valorAtual = valorAtual;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public StatusMeta getStatus() {
        return status;
    }

    public void setStatus(StatusMeta status) {
        this.status = status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}