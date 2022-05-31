package br.com.project.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.biblioteca.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByName(String username);
	
}
