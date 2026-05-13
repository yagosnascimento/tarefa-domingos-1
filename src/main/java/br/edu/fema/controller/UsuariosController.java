package br.edu.fema.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.fema.controller.dto.UsuarioDto;
import br.edu.fema.controller.form.UsuarioForm;
import br.edu.fema.model.Usuario;
import br.edu.fema.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository; // A ligação com a despensa

    // O GET que você já tinha
    @GetMapping
    public List<UsuarioDto> lista(String nome) {
        if (nome == null) {
            List<Usuario> usuarios = usuarioRepository.findAll();
            return UsuarioDto.converter(usuarios);
        } else {
            List<Usuario> usuarios = usuarioRepository.findByNome(nome);
            return UsuarioDto.converter(usuarios);
        }
    }

    // A NOVIDADE: O POST para cadastrar
    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioForm form, UriComponentsBuilder uriBuilder) {
        // 1. Pega a ficha que o cliente mandou e vira um Usuário
        Usuario usuario = form.converter(); 
        
        // 2. Manda a despensa salvar no banco de dados
        usuarioRepository.save(usuario); 
        
        // 3. Devolve a resposta com "Status 201 Created" dizendo que deu certo
        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
    }
}