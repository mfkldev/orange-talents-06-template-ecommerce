package br.com.zupacademy.marciosouza.ecommerce.repository;

import br.com.zupacademy.marciosouza.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
