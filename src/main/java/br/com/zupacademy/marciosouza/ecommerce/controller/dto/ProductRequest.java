package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Category;
import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import br.com.zupacademy.marciosouza.ecommerce.model.User;
import br.com.zupacademy.marciosouza.ecommerce.repository.CategoryRepository;
import org.hibernate.validator.constraints.Length;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductRequest {

    @NotBlank
    private String name;
    @NotNull @Positive
    private BigDecimal price;
    @Positive
    private int availableQuantity;
    @NotBlank @Length(max = 1000)
    private String description;
    @NotNull
    private Long idCategory;
    @Valid @Size(min = 3)
    private List<FeatureRequest> features = new ArrayList<>();

    public ProductRequest(String name, BigDecimal price, int availableQuantity, String description, Long idCategory, List<FeatureRequest> features) {
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.description = description;
        this.idCategory = idCategory;
        this.features.addAll(features);
    }

    public Product toModel(CategoryRepository categoryRepository, User user){
        Category category = categoryRepository.findById(this.idCategory).get();

        return new Product(this.name, this.price, this.availableQuantity, this.description, category, this.features, user);
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", availableQuantity=" + availableQuantity +
                ", description='" + description + '\'' +
                ", idCategory=" + idCategory +
                ", features=" + features.toString() +
                '}';
    }
}
