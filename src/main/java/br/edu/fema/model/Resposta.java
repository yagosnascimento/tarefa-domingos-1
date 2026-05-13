package br.edu.fema.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Resposta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    
    @ManyToOne
    private Topico topico;
    
    @ManyToOne
    private Usuario autor;

    public Resposta() {}

    public Resposta(String mensagem, Topico topico, Usuario autor) {
        this.mensagem = mensagem;
        this.topico = topico;
        this.autor = autor;
    }

    // Getters
    public Long getId() { return id; }
    public String getMensagem() { return mensagem; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public Usuario getAutor() { return autor; }
}