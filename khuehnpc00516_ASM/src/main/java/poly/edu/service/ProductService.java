package poly.edu.service;

import java.util.List;
import java.util.Optional;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import poly.edu.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);
	
	Page<Product> findAll(Pageable page);

	Page<Product> findByBrandId(String id, Pageable page);

	Page<Product> findAllAvailable(Pageable page);

	

}
