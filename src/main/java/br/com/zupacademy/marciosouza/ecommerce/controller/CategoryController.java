package br.com.zupacademy.marciosouza.ecommerce.controller;

import br.com.zupacademy.marciosouza.ecommerce.controller.dto.CategoryRequest;
import br.com.zupacademy.marciosouza.ecommerce.controller.dto.CategoryResponse;
import br.com.zupacademy.marciosouza.ecommerce.model.Category;
import br.com.zupacademy.marciosouza.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    @Transactional
    private ResponseEntity<?> save(@RequestBody @Valid CategoryRequest categoryRequest){
        Category category = categoryRequest.converter(categoryRepository);

        categoryRepository.save(category);

        return ResponseEntity.ok(new CategoryResponse(category));
    }
}
