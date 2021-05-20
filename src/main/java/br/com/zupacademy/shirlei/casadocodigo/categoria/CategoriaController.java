package br.com.zupacademy.shirlei.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ValidaNomeCategoria categoriaDuplicaValidator;


    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators((Validator) categoriaDuplicaValidator);
    }

    @Transactional
    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid NovaCategoriaRequest categoriaDTO){
        Categoria categoria = categoriaDTO.converter();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}

