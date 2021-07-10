package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.config.exceptions.validation.Unique;
import br.com.zupacademy.marciosouza.ecommerce.model.CleanPassword;
import br.com.zupacademy.marciosouza.ecommerce.model.User;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank @Email @Length(min = 6) @Unique(clazz = User.class, fieldName = "email")
    private String email;

    @NotBlank @Length(min = 6)
    private String password;


    public UserRequest(@NotBlank @Email @Length(min = 6) String email, @NotBlank @Length(min = 6) String password) {
        this.email = email;
        this.password = password;
    }

    public User converter() {
        return new User(email, new CleanPassword(password));
    }
}
