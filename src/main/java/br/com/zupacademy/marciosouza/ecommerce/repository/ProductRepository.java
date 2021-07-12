package br.com.zupacademy.marciosouza.ecommerce.repository;

import br.com.zupacademy.marciosouza.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
