package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Feature;
import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FeatureRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public FeatureRequest(@NotBlank String name, @NotBlank String description) {
        this.name = name;
        this.description = description;
    }

    public Feature toFeature(@NotNull @Valid Product product) {
        return new Feature(name, description, product);
    }

    @Override
    public String toString() {
        return "FeatureRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
