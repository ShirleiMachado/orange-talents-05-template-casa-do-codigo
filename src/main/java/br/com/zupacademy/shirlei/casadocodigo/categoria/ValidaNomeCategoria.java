package br.com.zupacademy.shirlei.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidaNomeCategoria implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz){
        return NovaCategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        if(errors.hasErrors()){
            return;
        }

        NovaCategoriaRequest novaCategoriaRequest = (NovaCategoriaRequest) target;

        Optional<Categoria> autorOP = categoriaRepository.findByNome(novaCategoriaRequest.getNome());
            if(autorOP.isPresent()){
                errors.rejectValue("nome", null, "Essa categoria já existe");
                System.out.println("Essa categoria já existe");
            }
    }
}
