package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Opinion;
import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import br.com.zupacademy.marciosouza.ecommerce.model.User;
import br.com.zupacademy.marciosouza.ecommerce.repository.ProductRepository;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class OpinionRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Min(1) @Max(5)
    private int rating;

    public OpinionRequest(String title, String description, int rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public Opinion toModel(Product product, User user) {

        return new Opinion(this.title, this.description, this.rating, user, product);
    }

    @Override
    public String toString() {
        return "OpinionRequest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", grade=" + rating +
                '}';
    }
}
