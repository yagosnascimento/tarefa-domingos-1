package br.edu.fema.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fema.model.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}