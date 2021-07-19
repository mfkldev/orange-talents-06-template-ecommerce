package br.com.zupacademy.marciosouza.ecommerce.controller.dto;

import br.com.zupacademy.marciosouza.ecommerce.model.Images;
import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DetailedProductResponse {

    private String name;
    private BigDecimal price;
    private int availableQuantity;
    private String description;
    private CategoryResponse category;
    private Set<FeatureResponse> features = new HashSet<>();
    private String seller;
    private Set<String> images;
    private Double productAverage;
    private int totalOpinions;
    private List<OpinionForDetailedProductResponse> opinionResponses = new ArrayList<>();
    private List<QuestionForDetailedProductResponse> questionForDetailedProductResponses = new ArrayList<>();


    public DetailedProductResponse(Product product) {
        this.name = product.getName();
        this.productAverage = product.productAverage();
        this.totalOpinions = product.totalOpinions();
        this.price = product.getPrice();
        this.availableQuantity = product.getAvailableQuantity();
        this.description = product.getDescription();
        this.category = new CategoryResponse(product.getCategory());
        this.features = product.getFeatures().stream().map(FeatureResponse::new).collect(Collectors.toSet());
        this.seller = new UserResponse(product.getUser()).fakeUserName();
        this.images = product.getImages().stream().map(Images::getLink).collect(Collectors.toSet());
        this.opinionResponses = product.getOpinions();
        this.questionForDetailedProductResponses = product.getQuestions();
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
                ", category=" + category +
                ", features=" + features +
                ", user=" + seller +
                '}';
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Double getProductAverage() { return productAverage; }

    public int getTotalOpinions() { return totalOpinions; }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public String getDescription() {
        return description;
    }

    public CategoryResponse getCategory() {
        return category;
    }

    public Set<FeatureResponse> getFeatures() {
        return features;
    }

    public String getSeller() {
        return seller;
    }

    public Set<String> getImages() {
        return images;
    }

    public List<OpinionForDetailedProductResponse> getOpinionResponses() {
        return opinionResponses;
    }

    public List<QuestionForDetailedProductResponse> getQuestionForDetailedProductResponses() {
        return questionForDetailedProductResponses;
    }
}
