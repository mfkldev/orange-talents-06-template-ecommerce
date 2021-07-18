package br.com.zupacademy.marciosouza.ecommerce.controller.dto;
import br.com.zupacademy.marciosouza.ecommerce.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class UserResponse {

    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime creationMoment;

    public UserResponse(User user) {
        this.email = user.getEmail();
        this.creationMoment = user.getCreationMoment();
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreationMoment() {
        return creationMoment;
    }
}
