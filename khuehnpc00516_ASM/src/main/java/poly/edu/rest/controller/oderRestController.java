package poly.edu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;


import poly.edu.entity.Order;
import poly.edu.service.ProductService;
import poly.edu.service.oderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/oders")
public class oderRestController {
	@Autowired
	oderService oderservice;
	
	
	@PostMapping()
	public Order create(@RequestBody JsonNode orderData) {
		
		return oderservice.create(orderData);
	}
	
}
