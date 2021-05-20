package br.com.zupacademy.shirlei.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private final AutorRepository autorRepository;

    @Autowired
    private ValidaEmailAutor emailAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailAutorValidator);
    }

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cria(@RequestBody @Valid NovoAutorRequest request) {
        Autor autor = request.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}