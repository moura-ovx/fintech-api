package com.br.fiap.fintech.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_FIN_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USUARIO"
    )
    @SequenceGenerator(
            name = "SEQ_USUARIO",
            sequenceName = "SEQ_USUARIO",
            allocationSize = 1
    )

    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "ds_email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "ds_senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "dt_criado_em", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Define o padrão de data no json
    private LocalDateTime criadoEm = LocalDateTime.now();

    public Usuario(){}

    public Usuario(Long id, String email, String senha, LocalDateTime criadoEm){
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getCriadoEm() {return criadoEm;}

    public void setCriadoEm(LocalDateTime criadoEm) {this.criadoEm = criadoEm;}
}
