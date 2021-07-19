package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Opinion;

public class OpinionForDetailedProductResponse {

    private String title;
    private String description;
    private int rating;

    public OpinionForDetailedProductResponse(Opinion opinion) {
        this.title = opinion.getTitle();
        this.description = opinion.getDescription();
        this.rating = opinion.getRating();
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
}
