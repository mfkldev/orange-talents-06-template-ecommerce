package br.com.zupacademy.marciosouza.ecommerce.controller;

import br.com.zupacademy.marciosouza.ecommerce.controller.dto.OpinionResponse;
import br.com.zupacademy.marciosouza.ecommerce.controller.dto.OpinionRequest;
import br.com.zupacademy.marciosouza.ecommerce.model.Opinion;
import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import br.com.zupacademy.marciosouza.ecommerce.model.User;
import br.com.zupacademy.marciosouza.ecommerce.repository.OpinionRepository;
import br.com.zupacademy.marciosouza.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class OpinionController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OpinionRepository opinionRepository;

    @PostMapping(value = "produto/{id}/opiniao")
    @Transactional
    public ResponseEntity<?> saveOpinion(@PathVariable Long id, @RequestBody @Valid OpinionRequest opinionRequest, @AuthenticationPrincipal User user){

        Product product = productRepository.getById(id);

        Opinion opinion = opinionRequest.toModel(product, user);

        opinionRepository.save(opinion);

        return ResponseEntity.ok(new OpinionResponse(opinion));
    }
}
