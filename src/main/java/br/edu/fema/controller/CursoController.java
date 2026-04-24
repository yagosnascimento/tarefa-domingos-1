package br.edu.fema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fema.controller.dto.CursoDto;
import br.edu.fema.model.Curso;
import br.edu.fema.repository.CursoRepository;

@RestController
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @RequestMapping(value = "/cursos", method = RequestMethod.GET)
    public List<CursoDto> lista() {
        List<Curso> cursos = cursoRepository.findAll();
        return CursoDto.converter(cursos);
    }

    @RequestMapping(value = "/cursos", method = RequestMethod.POST)
    public void cadastrar(@RequestBody Curso curso) {
        // Define o valor fixo no atributo "nome" antes de salvar no banco de dados
        curso.setNome("Curso de spring do Yago Siqueira Nascimento");
        cursoRepository.save(curso);
    }
}