package br.com.zupacademy.marciosouza.ecommerce.controller;

import br.com.zupacademy.marciosouza.ecommerce.controller.dto.QuestionRequest;
import br.com.zupacademy.marciosouza.ecommerce.controller.dto.QuestionResponse;
import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import br.com.zupacademy.marciosouza.ecommerce.model.Question;
import br.com.zupacademy.marciosouza.ecommerce.model.User;
import br.com.zupacademy.marciosouza.ecommerce.repository.ProductRepository;
import br.com.zupacademy.marciosouza.ecommerce.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class QuestionController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping(value = "/produto/{id}/pergunta")
    private ResponseEntity<?> saveQuestion(@PathVariable Long id, @RequestBody @Valid QuestionRequest questionRequest, @AuthenticationPrincipal User user){

        Product product = productRepository.getById(id);

        Question question = questionRequest.toModel(product, user);

        questionRepository.save(question);

        System.out.println("ENVIO DE EMAIL: Vendedor o produto "+product.getName()+" tem uma nova pergunta!");

        return ResponseEntity.ok(new QuestionResponse(question));
    }
}
