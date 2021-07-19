package br.com.zupacademy.marciosouza.ecommerce.controller;

import br.com.zupacademy.marciosouza.ecommerce.controller.dto.DetailedProductResponse;
import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import br.com.zupacademy.marciosouza.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailedProductController {

    @Autowired
    public ProductRepository productRepository;

    @GetMapping(value = "/produto/{id}")
    public ResponseEntity<?> detailOne(@PathVariable Long id){
        Product product =productRepository.getById(id);

        return ResponseEntity.ok(new DetailedProductResponse(product));
    }
}
