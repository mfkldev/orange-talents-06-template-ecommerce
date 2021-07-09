package br.com.zupacademy.marciosouza.ecommerce.repository;

import br.com.zupacademy.marciosouza.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
