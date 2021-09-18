package poly.edu.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.edu.entity.Category;
import poly.edu.entity.Product;
import poly.edu.service.CategoryService;
import poly.edu.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categoties")
public class categoryRestController {
	@Autowired
	CategoryService cservice;
//	@GetMapping("{id}")
//	public Product getOne(@PathVariable("id") Integer id) {
//		return cservice.findById(id);
//	}
	
	@GetMapping()
	public List<Category> getAll() {
		return cservice.findAll();
	}
}
