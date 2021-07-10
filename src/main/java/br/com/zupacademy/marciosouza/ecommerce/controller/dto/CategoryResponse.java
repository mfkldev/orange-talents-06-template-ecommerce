package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Category;

public class CategoryResponse {

    private String name;
    private String parent;

    public CategoryResponse(Category category) {
        this.name = category.getName();
        this.parent = category.getParent().getName();
    }

    public String getName() {
        return name;
    }

    public String getParent() {
        return parent;
    }
}
