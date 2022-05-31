package br.com.project.biblioteca.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.biblioteca.models.Books;
import br.com.project.biblioteca.services.BooksService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/books")
public class BooksResource {

	@Autowired
	private BooksService booksService;
	
	@GetMapping
	public ResponseEntity<List<Books>> findAll(){
		return ResponseEntity.ok().body(booksService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Books> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(booksService.findById(id));
	}

}