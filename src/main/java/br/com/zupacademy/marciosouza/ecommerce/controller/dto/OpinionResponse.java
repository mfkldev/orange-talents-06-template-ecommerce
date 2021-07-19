package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Opinion;

public class OpinionResponse {

    private String title;
    private String description;
    private int rating;
    private String user;
    private String product;

    public OpinionResponse(Opinion opinion) {
        this.title = opinion.getTitle();
        this.description = opinion.getDescription();
        this.rating = opinion.getRating();
        this.user = opinion.getUser().getUsername();
        this.product = opinion.getProduct().getName();
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

    public String getUser() {
        return user;
    }

    public String getProduct() {
        return product;
    }
}
