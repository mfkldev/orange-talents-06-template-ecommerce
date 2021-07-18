package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Images;
import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime registrationDate = LocalDateTime.now();
    private CategoryResponse category;
    private Set<FeatureResponse> features = new HashSet<>();
    private UserResponse user;
    private Set<String> images;

    public ProductResponse(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.availableQuantity = product.getAvailableQuantity();
        this.description = product.getDescription();
        this.registrationDate = product.getRegistrationDate();
        this.category = new CategoryResponse(product.getCategory());
        this.features = product.getFeatures().stream().map(FeatureResponse::new).collect(Collectors.toSet());
        this.user = new UserResponse(product.getUser());
        this.images = product.getImages().stream().map(Images::getLink).collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", availableQuantity=" + availableQuantity +
                ", description='" + description + '\'' +
                ", registrationDate=" + registrationDate +
                ", category=" + category +
                ", features=" + features +
                ", user=" + user +
                '}';
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

    public Set<String> getImages() {
        return images;
    }
}
