package br.edu.fema.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.fema.model.Usuario;

public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;

    // Aqui ele pega o usuário que veio da despensa e coloca na "embalagem"
    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }

    public static List<UsuarioDto> converter(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
    }
}