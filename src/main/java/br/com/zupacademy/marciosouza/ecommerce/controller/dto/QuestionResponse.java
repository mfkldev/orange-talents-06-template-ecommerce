package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Question;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class QuestionResponse {

    private String description;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime registrationDate = LocalDateTime.now();

    private String user;
    private String product;

    public QuestionResponse(Question question) {
        this.description = question.getDescription();
        this.registrationDate = question.getRegistrationDate();
        this.user = question.getUser().getEmail();
        this.product = question.getProduct().getName();
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public String getUser() {
        return user;
    }

    public String getProduct() {
        return product;
    }
}
