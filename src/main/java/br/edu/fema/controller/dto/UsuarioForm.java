package br.edu.fema.controller.form;

import br.edu.fema.model.Usuario;

public class UsuarioForm {
    private String nome;
    private String email;
    private String senha;

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }

    // Isso transforma a ficha de cadastro em um Usuário de verdade
    public Usuario converter() {
        return new Usuario(nome, email, senha);
    }
}