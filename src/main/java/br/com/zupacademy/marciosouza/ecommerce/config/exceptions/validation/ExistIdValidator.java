package br.com.zupacademy.marciosouza.ecommerce.config.exceptions.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExistId, Object> {

    private String fieldName;
    private  Class<?> clazz;

    @Autowired //@PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.fieldName = constraintAnnotation.fieldName();
        this.clazz = constraintAnnotation.clazz();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("SELECT x FROM " + clazz.getName() + " x WHERE x." + fieldName + " = :pCampo").setParameter("pCampo", object);

        List<?> list = query.getResultList();
        Assert.isTrue(list.size() <=1, "Tem mais de um "+clazz.getName()+" com o atributo "+fieldName+" com o valor = "+object);

        return !list.isEmpty();
    }
}
