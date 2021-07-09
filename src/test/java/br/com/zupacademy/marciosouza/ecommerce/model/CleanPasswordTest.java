package br.com.zupacademy.marciosouza.ecommerce.model;

import org.junit.jupiter.api.Test;
class CleanPasswordTest {

    private CleanPassword cleanPassword;

    @Test()
    void mustAcceptStringBiggerOuEqualThanSix() {

        new CleanPassword("123456"); //Intellij que recomendou isso aqui. :0
    }
}