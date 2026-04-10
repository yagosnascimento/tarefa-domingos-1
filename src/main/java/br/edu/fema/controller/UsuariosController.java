package br.edu.fema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fema.controller.dto.UsuarioDto;
import br.edu.fema.model.Usuario;
import br.edu.fema.repository.UsuarioRepository;

@RestController
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<UsuarioDto> lista(String nome) {
        if (nome == null) {
            // Se não enviares o nome, devolve todos os utilizadores
            List<Usuario> usuarios = usuarioRepository.findAll();
            return UsuarioDto.converter(usuarios);
        } else {
            // Se enviares o nome, filtra usando o novo método do repositório
            List<Usuario> usuarios = usuarioRepository.findByNome(nome);
            return UsuarioDto.converter(usuarios);
        }
    }
}