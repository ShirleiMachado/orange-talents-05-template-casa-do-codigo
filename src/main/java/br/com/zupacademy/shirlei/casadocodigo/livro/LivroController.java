package br.com.zupacademy.shirlei.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid NovoLivroRequest request){
        Livro livro = request.toModel();
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }
}
