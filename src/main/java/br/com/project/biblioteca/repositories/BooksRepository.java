package br.com.project.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.biblioteca.models.Books;
import br.com.project.biblioteca.models.Users;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

//	List<Books> findByUsers(Users users);
	
}
