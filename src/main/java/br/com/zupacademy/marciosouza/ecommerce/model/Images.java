package br.com.zupacademy.marciosouza.ecommerce.model;

import org.hibernate.validator.constraints.URL;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Images {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne @NotNull @Valid
    private Product product;

    @URL @NotBlank
    private String link;

    @Deprecated
    public Images() {
    }

    public Images(@NotNull @Valid Product product, @URL String links) {
        this.product = product;
        this.link = links;
    }

    public String getLink() {
        return link;
    }
}
