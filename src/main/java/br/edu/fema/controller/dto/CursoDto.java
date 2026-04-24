package br.edu.fema.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.fema.model.Curso;

public class CursoDto {
    private Long id;
    private String nome;

    public CursoDto(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }

    public static List<CursoDto> converter(List<Curso> cursos) {
        return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
    }
}