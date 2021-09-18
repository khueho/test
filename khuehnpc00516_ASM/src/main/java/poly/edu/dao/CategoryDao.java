package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.entity.Category;

public interface CategoryDao extends JpaRepository<Category, String>{

}
