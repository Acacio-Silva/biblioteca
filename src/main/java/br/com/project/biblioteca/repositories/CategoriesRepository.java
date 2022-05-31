package br.com.project.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.biblioteca.models.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}
