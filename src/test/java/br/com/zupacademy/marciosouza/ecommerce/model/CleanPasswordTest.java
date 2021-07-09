package br.com.zupacademy.marciosouza.ecommerce.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CleanPasswordTest {

    private CleanPassword cleanPassword;

    @Test()
    void mustNotAcceptStringLessThanSix() {

        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()-> {new CleanPassword("12345");} );
    }

    @Test()
    void mustAcceptStringBiggerOuEqualThanSix() {

        new CleanPassword("1234567"); //Intellij que recomendou isso aqui. :0
    }
}