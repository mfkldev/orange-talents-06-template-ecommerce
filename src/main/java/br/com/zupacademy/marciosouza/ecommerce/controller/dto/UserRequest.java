package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.CleanPassword;
import br.com.zupacademy.marciosouza.ecommerce.model.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRequest {

    @NotBlank @Email @Length(min = 6)
    private String email;

    @NotNull
    private CleanPassword cleanPassword;

    public UserRequest(@NotBlank @Email @Length(min = 6) String email, @NotNull CleanPassword cleanPassword) {
        Assert.isTrue(StringUtils.hasLength(email), "Não pode ser em branco");
        Assert.notNull(cleanPassword, "Não pode ser nulo");

        this.email = email;
        this.cleanPassword = cleanPassword;
    }

    public User converter() {
        return new User(email, cleanPassword);
    }
}
