package br.edu.fema.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import br.edu.fema.model.Topico;

public class DetalhesDoTopicoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String status;
    private String autor;
    private List<RespostaDto> respostas;

    public DetalhesDoTopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.status = topico.getStatus().name();
        this.autor = topico.getAutor().getNome();
        this.respostas = topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList());
    }
    // Getters...
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getMensagem() { return mensagem; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public String getStatus() { return status; }
    public String getAutor() { return autor; }
    public List<RespostaDto> getRespostas() { return respostas; }
}