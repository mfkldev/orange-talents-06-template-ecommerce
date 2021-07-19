package br.com.zupacademy.marciosouza.ecommerce.repository;

import br.com.zupacademy.marciosouza.ecommerce.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
