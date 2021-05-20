package br.com.zupacademy.shirlei.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private final AutorRepository autorRepository;


    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Transactional
    @PostMapping
    public String cria(@RequestBody @Valid NovoAutorRequest request) {
        Autor autor = request.toModel();
        autorRepository.save(autor);
        return toString();

    }
}
