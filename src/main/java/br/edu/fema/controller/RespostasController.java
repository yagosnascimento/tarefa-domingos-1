package br.edu.fema.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.fema.controller.dto.RespostaDto;
import br.edu.fema.model.Resposta;
import br.edu.fema.model.Topico;
import br.edu.fema.model.Usuario;
import br.edu.fema.repository.RespostaRepository;
import br.edu.fema.repository.TopicoRepository;
import br.edu.fema.repository.UsuarioRepository;

@RestController
@RequestMapping("/respostas")
public class RespostasController {

    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<RespostaDto> cadastrar(@RequestBody RespostaForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = topicoRepository.getReferenceById(form.getTopicoId());
        Usuario autor = usuarioRepository.getReferenceById(form.getAutorId());
        
        Resposta resposta = new Resposta(form.getMensagem(), topico, autor);
        respostaRepository.save(resposta);

        URI uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new RespostaDto(resposta));
    }
}

// Classe auxiliar para receber os dados do POST
class RespostaForm {
    private String mensagem;
    private Long topicoId;
    private Long autorId;
    public String getMensagem() { return mensagem; }
    public Long getTopicoId() { return topicoId; }
    public Long getAutorId() { return autorId; }
}