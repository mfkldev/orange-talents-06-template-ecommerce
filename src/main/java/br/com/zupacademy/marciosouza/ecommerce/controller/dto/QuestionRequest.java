package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import br.com.zupacademy.marciosouza.ecommerce.model.Question;
import br.com.zupacademy.marciosouza.ecommerce.model.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuestionRequest {

    @NotBlank
    private String description;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public QuestionRequest(String description) {

        this.description = description;
    }

    public Question toModel(@NotNull Product product, @NotNull User user) {
        return new Question(this.description, user, product);
    }
}
