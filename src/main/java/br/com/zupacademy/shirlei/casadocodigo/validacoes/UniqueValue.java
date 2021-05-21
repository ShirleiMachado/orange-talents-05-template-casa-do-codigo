package br.com.zupacademy.shirlei.casadocodigo.validacoes;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
    String message() default "Valor único violado";
    Class<? extends Payload>[] payload() default {};

    String fieldName();
    Class<?> domainClass();

}
