package br.edu.fema.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Topico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
    
    @ManyToOne
    private Usuario autor;
    
    @ManyToOne
    private Curso curso;
    
    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas = new ArrayList<>();

    public Topico() {}

    public Topico(String titulo, String mensagem, Curso curso, Usuario autor) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.curso = curso;
        this.autor = autor;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getMensagem() { return mensagem; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public StatusTopico getStatus() { return status; }
    public Usuario getAutor() { return autor; }
    public List<Resposta> getRespostas() { return respostas; }
}