package br.edu.fema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.model.Usuario; // Não te esqueças de importar a List

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // O Spring Boot vai traduzir isto para: SELECT * FROM usuario WHERE nome = ?
    List<Usuario> findByNome(String nome);
    
}