package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Feature;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class FeatureResponse {

    private String name;
    private String description;
    public FeatureResponse(Feature feature) {
        this.name = feature.getName();
        this.description = feature.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
