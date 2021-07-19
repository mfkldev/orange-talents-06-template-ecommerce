package br.com.zupacademy.marciosouza.ecommerce.controller;

import br.com.zupacademy.marciosouza.ecommerce.controller.dto.*;
import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import br.com.zupacademy.marciosouza.ecommerce.model.User;
import br.com.zupacademy.marciosouza.ecommerce.repository.CategoryRepository;
import br.com.zupacademy.marciosouza.ecommerce.repository.ProductRepository;
import br.com.zupacademy.marciosouza.ecommerce.service.ServidorImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ServidorImage servidorImage;

    @PostMapping(value = "/produto")
    @Transactional
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductRequest productRequest,
                                  @AuthenticationPrincipal User user){

        Product product = productRequest.toModel(categoryRepository, user);
        productRepository.save(product);

        return ResponseEntity.ok(new ProductResponse(product));
    }

    @PostMapping(value = "/produto/{id}/imagens")
    @Transactional
    public ResponseEntity<?> saveImage(@PathVariable Long id, @Valid ImagesRequest imagesRequest,
                                       @AuthenticationPrincipal
                                               User user){

        Set<String> links = servidorImage.push(imagesRequest.getImages());

        Product product = productRepository.getById(id);

        product.ownership(user);

        product.connectImage(links);

        productRepository.save(product);

        return ResponseEntity.ok(new ProductResponse(product));
    }

}
