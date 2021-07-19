package br.com.zupacademy.marciosouza.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String description;

    @ManyToOne @NotNull
    private User user;

    @ManyToOne @NotNull
    private Product product;

    private LocalDateTime registrationDate = LocalDateTime.now();

    @Deprecated
    public Question() {
    }

    public Question(String description, User user, Product product) {
        this.description = description;
        this.user = user;
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
