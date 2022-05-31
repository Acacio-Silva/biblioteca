package br.com.project.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.biblioteca.models.Books;
import br.com.project.biblioteca.repositories.BooksRepository;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;
	
	public List<Books> findAll(){
		return booksRepository.findAll();
	}
	
	public Books findById(Long id) {
		Optional<Books> book = booksRepository.findById(id);
		if(book.isPresent()) {
			return book.get();
		}
		return null;
	}
	
	
	
	
}
