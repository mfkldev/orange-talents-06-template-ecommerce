package br.com.zupacademy.marciosouza.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class User{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    private final LocalDateTime creationMoment = LocalDateTime.now();

    @NotBlank @Email
    private String email;

    @NotBlank @Length(min = 6)
    private String password;

    @Deprecated
    public User() {
    }

    public User(@NotBlank @Email String email, @Valid @NotNull CleanPassword cleanPassword) {

        this.email = email;
        this.password = cleanPassword.passwordEncoder();
    }

    public LocalDateTime getCreationMoment() {
        return creationMoment;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
