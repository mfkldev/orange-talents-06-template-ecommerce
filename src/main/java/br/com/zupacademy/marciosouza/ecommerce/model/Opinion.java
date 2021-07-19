package br.com.zupacademy.marciosouza.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Opinion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Min(1) @Max(5)
    private int rating;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    @Deprecated
    public Opinion() {
    }

    public Opinion(String title, String description, int rating, User user, Product product) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.user = user;
        this.product = product;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }
}
