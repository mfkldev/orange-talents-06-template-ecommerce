package br.com.zupacademy.marciosouza.ecommerce.repository;

import br.com.zupacademy.marciosouza.ecommerce.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
