package br.edu.fema.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}