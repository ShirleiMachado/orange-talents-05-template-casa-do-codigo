package br.com.zupacademy.shirlei.casadocodigo.autor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidaEmailAutor implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        NovoAutorRequest autorDto = (NovoAutorRequest) target;
        Optional<Autor> autorOp = autorRepository.findByEmail(autorDto.getEmail());
        if(autorOp.isPresent()){
            errors.rejectValue("email", null, "Já existe este email cadastrado na base de dados");
            System.out.println("Já existe este email na base de dados");
        }
    }
}
