package br.com.zupacademy.marciosouza.ecommerce.controller;

import br.com.zupacademy.marciosouza.ecommerce.controller.dto.ProductRequest;
import br.com.zupacademy.marciosouza.ecommerce.controller.dto.ProductResponse;
import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import br.com.zupacademy.marciosouza.ecommerce.model.User;
import br.com.zupacademy.marciosouza.ecommerce.repository.CategoryRepository;
import br.com.zupacademy.marciosouza.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProductController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> save(@RequestBody @Valid ProductRequest productRequest,
                                  @AuthenticationPrincipal User user){

        Product product = productRequest.toModel(categoryRepository, user);
        productRepository.save(product);

        return ResponseEntity.ok(new ProductResponse(product));
    }
}
