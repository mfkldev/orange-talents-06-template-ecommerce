package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Question;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class QuestionForDetailedProductResponse {

    private String description;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDateTime registrationDate = LocalDateTime.now();

    public QuestionForDetailedProductResponse(Question question) {
        this.description = question.getDescription();
        this.registrationDate = question.getRegistrationDate();
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
