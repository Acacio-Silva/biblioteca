package br.com.project.biblioteca.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.project.biblioteca.models.Books;
import br.com.project.biblioteca.models.Users;
import br.com.project.biblioteca.repositories.UsersRepository;
import br.com.project.biblioteca.security.JWTCreator;
import br.com.project.biblioteca.security.JWTObject;
import br.com.project.biblioteca.security.SecurityConfig;
import br.com.project.biblioteca.security.dtos.Login;
import br.com.project.biblioteca.security.dtos.Sessao;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private BooksService booksService;

	public List<Users> findAll() {
		List<Users> list = usersRepository.findAll();
		Collections.sort(list, Comparator.comparing(Users::getPoints).reversed());
		return list;
	}

	public Users findById(Long id) {
		Optional<Users> user = usersRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	public Users findByName(String name) {
		Users user = usersRepository.findByName(name);
		if(user != null) {
			return user;
		}
		throw new RuntimeException("Usuario não encontrado!");
	}

	public Users addBook(Long id, String name) {
		Users u = findByName(name);
		Books book = booksService.findById(id);
		var a = u.getBooks().stream().filter(e -> e.getId().equals(book.getId())).collect(Collectors.toList());
		if (a.isEmpty()) {
			u.getBooks().add(book);
			u.setPoints(u.getBooks().stream().mapToInt(p -> p.getPointsPages()).sum() + u.getBooks().size());
			usersRepository.save(u);
			return u;
		}
		throw new RuntimeException("Livro já cadastrado");
	}
	
	
	
	
	
	public Sessao login(Login login) {
		Users user = usersRepository.findByName(login.getUsername());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getPassword(), user.getPassowrd());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            Sessao sessao = new Sessao();
            sessao.setLogin(user.getName());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }	
	
	

}
