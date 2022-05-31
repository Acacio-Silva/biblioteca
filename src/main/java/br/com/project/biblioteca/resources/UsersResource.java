package br.com.project.biblioteca.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.biblioteca.models.Books;
import br.com.project.biblioteca.models.Users;
import br.com.project.biblioteca.security.dtos.Login;
import br.com.project.biblioteca.security.dtos.Sessao;
import br.com.project.biblioteca.services.UsersService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/users")
public class UsersResource {

	@Autowired
	private UsersService usersService;
	
	@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		return ResponseEntity.ok().body(usersService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Users> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(usersService.findById(id));
	}
	
	
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<Users> findByName(@PathVariable String name){
		return ResponseEntity.ok().body(usersService.findByName(name));
	}
	
	@GetMapping(value = "/addBook/{id}/{name}")
	public ResponseEntity<Users> addBooks(@PathVariable Long id, @PathVariable String name){
		return ResponseEntity.ok().body(usersService.addBook(id, name));
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<Sessao> login(@RequestBody Login login){
		return ResponseEntity.ok().body(usersService.login(login));		
	}	

}
