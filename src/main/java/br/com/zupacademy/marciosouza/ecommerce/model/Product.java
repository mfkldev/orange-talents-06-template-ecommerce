package br.com.zupacademy.marciosouza.ecommerce.model;

import br.com.zupacademy.marciosouza.ecommerce.controller.dto.FeatureRequest;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull @Positive
    private BigDecimal price;

    @Positive
    private int availableQuantity;

    @NotBlank @Length(max = 1000)
    private String description;

    private LocalDateTime registrationDate = LocalDateTime.now();

    @NotNull @Valid @ManyToOne
    private Category category;

    @NotNull @Size(min = 3)
    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private Set<Feature> features = new HashSet<>();

    @NotNull @ManyToOne
    private User user;

    @Deprecated
    public Product() {
    }

    public Product(String name, BigDecimal price, int availableQuantity, String description, Category category, Collection<FeatureRequest> featuresRequest, User user) {
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.description = description;
        this.category = category;
        this.user = user;
        this.features.addAll(featuresRequest.stream().map(feature -> feature.toFeature(this)).collect(Collectors.toSet()));
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", availableQuantity=" + availableQuantity +
                ", description='" + description + '\'' +
                ", registrationDate=" + registrationDate +
                ", category=" + category +
                ", features=" + features.toString() +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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

    public Category getCategory() {
        return category;
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public User getUser() {
        return user;
    }
}
