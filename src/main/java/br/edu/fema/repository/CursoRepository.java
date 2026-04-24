package br.edu.fema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}