package br.com.zupacademy.marciosouza.ecommerce.config.exceptions.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistIdValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistId {

    Class[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String message() default "br.com.zupacademy.marciosouza.beanvalidation.existid";
    String fieldName();
    Class<?> clazz();
}
