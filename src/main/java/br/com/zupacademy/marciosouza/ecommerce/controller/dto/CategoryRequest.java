package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.config.exceptions.validation.Unique;
import br.com.zupacademy.marciosouza.ecommerce.model.Category;
import br.com.zupacademy.marciosouza.ecommerce.repository.CategoryRepository;
import javax.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank @Unique(clazz = Category.class, fieldName = "name")
    private String name;

    private Long idParent;

    public CategoryRequest(String name, Long idParent) {
        this.name = name;
        this.idParent = idParent;
    }

    public Category converter(CategoryRepository categoryRepository){
        Category categoryParent = null;

        if(idParent != null){
            categoryParent = categoryRepository.getById(idParent);
        }

        return new Category(this.name, categoryParent);
    }

    public String getName() {
        return name;
    }

    public Long getIdParent() {
        return idParent;
    }
}
