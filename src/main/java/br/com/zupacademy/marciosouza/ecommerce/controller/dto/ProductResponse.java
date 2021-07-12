package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Category;
import br.com.zupacademy.marciosouza.ecommerce.model.Feature;
import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import br.com.zupacademy.marciosouza.ecommerce.model.User;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductResponse {


    private String name;
    private BigDecimal price;
    private int availableQuantity;
    private String description;
    private LocalDateTime registrationDate = LocalDateTime.now();
    private CategoryResponse category;
    private Set<FeatureResponse> features = new HashSet<>();
    private UserResponse user;

    public ProductResponse(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.availableQuantity = product.getAvailableQuantity();
        this.description = product.getDescription();
        this.registrationDate = product.getRegistrationDate();
        this.category = new CategoryResponse(product.getCategory());
        this.features = product.getFeatures().stream().map(FeatureResponse::new).collect(Collectors.toSet());
        this.user = new UserResponse(product.getUser());
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public CategoryResponse getCategory() {
        return category;
    }

    public Set<FeatureResponse> getFeatures() {
        return features;
    }

    public UserResponse getUser() {
        return user;
    }
}
