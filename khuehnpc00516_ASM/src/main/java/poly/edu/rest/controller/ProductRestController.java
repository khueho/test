package poly.edu.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.edu.entity.Product;
import poly.edu.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductService pservice;
	@GetMapping("{id}")
	public Product getOne(@PathVariable("id") Integer id) {
		return pservice.findById(id);
	}
	
	@GetMapping()
	public List<Product> getAll() {
		return pservice.findAll();
	}
	
	@PostMapping
	public Product create(@RequestBody Product product) {
		return pservice.create(product);
	}
	
	@PutMapping("{id}")
	public Product update(@PathVariable("id") Integer id ,@RequestBody Product product) {
		return pservice.update(product);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id ) {
		 pservice.delete(id);
	}
	
	
}
