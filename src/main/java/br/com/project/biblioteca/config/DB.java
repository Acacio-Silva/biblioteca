package br.com.project.biblioteca.config;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.project.biblioteca.models.Books;
import br.com.project.biblioteca.models.Categories;
import br.com.project.biblioteca.models.Users;
import br.com.project.biblioteca.repositories.BooksRepository;
import br.com.project.biblioteca.repositories.CategoriesRepository;
import br.com.project.biblioteca.repositories.UsersRepository;

@Transactional
@Configuration
public class DB implements CommandLineRunner{

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	@Autowired
	private BooksRepository booksRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categories c1 = new Categories();
		c1.setName("Tecnologia da Informação");
		Categories c2 = new Categories();
		c2.setName("Ficção cientifica");
		Categories c3 = new Categories();
		c3.setName("Musica");
		
		
		Books b1 = new Books();
		b1.setTitle("Logida de Programação I");
		b1.setNumberPages(230);
		b1.setPointsPages(3);
		b1.setCategory(c1);
		
		Books b2 = new Books();
		b2.setTitle("Logida de Programação II");
		b2.setNumberPages(150);
		b2.setPointsPages(2);
		b2.setCategory(c1);
		
		Books b3 = new Books();
		b3.setTitle("Programação Web I");
		b3.setNumberPages(400);
		b3.setPointsPages(4);
		b3.setCategory(c1);
		
		Books b4 = new Books();
		b4.setTitle("Programação Web II");
		b4.setNumberPages(860);
		b4.setPointsPages(9);
		b4.setCategory(c1);
		
		Books b5 = new Books();
		b5.setTitle("Orienteção Objetos");
		b5.setNumberPages(800);
		b5.setPointsPages(8);
		b5.setCategory(c1);
		
		//c1.setBooks(Arrays.asList(b1,b2,b3,b4,b5));
		
		Books b6 = new Books();
		b6.setTitle("Harry potter e a pedra filosofal");
		b6.setNumberPages(400);
		b6.setPointsPages(4);
		b6.setCategory(c2);
		
		Books b7 = new Books();
		b7.setTitle("Harry potter e a camara secreta");
		b7.setNumberPages(500);
		b7.setPointsPages(5);
		b7.setCategory(c2);
		
		Books b8 = new Books();
		b8.setTitle("Harry potter e o prisioneiro de askarbam");
		b8.setNumberPages(730);
		b8.setPointsPages(8);
		b8.setCategory(c2);
		
		Books b9 = new Books();
		b9.setTitle("Harry potter e o calice de fogo");
		b9.setNumberPages(430);
		b9.setPointsPages(5);
		b9.setCategory(c2);
		
		Books b10 = new Books();
		b10.setTitle("Harry potter e a ordem da fenix");
		b10.setNumberPages(470);
		b10.setPointsPages(5);
		b10.setCategory(c2);
		
		//c2.setBooks(Arrays.asList(b6,b7,b8,b9,b10));
		
		Books b11 = new Books();
		b11.setTitle("Introdução a Música");
		b11.setNumberPages(130);
		b11.setPointsPages(2);
		b11.setCategory(c3);
		
		Books b12 = new Books();
		b12.setTitle("Introdução ao campo harmonico");
		b12.setNumberPages(92);
		b12.setPointsPages(1);
		b12.setCategory(c3);
		
		Books b13 = new Books();
		b13.setTitle("Escalas");
		b13.setNumberPages(400);
		b13.setPointsPages(4);
		b13.setCategory(c3);
		
		Books b14 = new Books();
		b14.setTitle("Modos Gregos");
		b14.setNumberPages(330);
		b14.setPointsPages(4);
		b14.setCategory(c3);
		
		Books b15 = new Books();
		b15.setTitle("Improvisação com escalas");
		b15.setNumberPages(270);
		b15.setPointsPages(3);
		b15.setCategory(c3);
		
		//c3.setBooks(Arrays.asList(b11,b12,b13,b14,b15));
		
		
		Users u1 = new Users();
		u1.setName("Acácio");
		u1.setPassowrd(encoder.encode("123456"));
		u1.setRoles(Arrays.asList("CLIENT"));
		//u1.setBooks(Arrays.asList(b1));
		u1.setBooks(Arrays.asList(b1,b2,b3,b4));
		u1.setPoints(u1.getBooks().stream().mapToInt(p -> p.getPointsPages()).sum() + u1.getBooks().size());
		
		
		Users u2 = new Users();
		u2.setName("Francisco");
		u2.setPassowrd(encoder.encode("123456"));
		u2.setRoles(Arrays.asList("CLIENT"));
		u2.setBooks(Arrays.asList(b2));
		u2.setPoints(u2.getBooks().stream().mapToInt(p -> p.getPointsPages()).sum() + u2.getBooks().size());
		//u2.setBooks(Arrays.asList(b1,b2));
		
		Users u3 = new Users();
		u3.setName("Maria");
		u3.setPassowrd(encoder.encode("123456"));
		u3.setRoles(Arrays.asList("CLIENT"));
		u3.setBooks(Arrays.asList(b8));
		u3.setPoints(u3.getBooks().stream().mapToInt(p -> p.getPointsPages()).sum() + u3.getBooks().size());
		//u3.setBooks(Arrays.asList(b6,b7,b8));
		
		Users u4 = new Users();
		u4.setName("Aparecida");
		u4.setPassowrd(encoder.encode("123456"));
		u4.setRoles(Arrays.asList("CLIENT"));
		u4.setBooks(Arrays.asList(b6));
		u4.setPoints(u4.getBooks().stream().mapToInt(p -> p.getPointsPages()).sum() + u4.getBooks().size());
		//u4.setBooks(Arrays.asList(b6,b7,b8,b9));
		
		Users u5 = new Users();
		u5.setName("Goretti");
		u5.setPassowrd(encoder.encode("123456"));
		u5.setRoles(Arrays.asList("CLIENT"));
		u5.setBooks(Arrays.asList(b13));
		u5.setPoints(u5.getBooks().stream().mapToInt(p -> p.getPointsPages()).sum() + u5.getBooks().size());
		//u5.setBooks(Arrays.asList(b11,b12,b13));
		
		
		usersRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));
		booksRepository.saveAll(Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b12,b14,b15));
		categoriesRepository.saveAll(Arrays.asList(c1,c2,c3));
		
	}

}
