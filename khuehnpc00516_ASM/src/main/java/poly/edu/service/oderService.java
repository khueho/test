package poly.edu.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import poly.edu.entity.Order;

public interface oderService {

    Order create(JsonNode oderdata) ;

    Order findById(Long id);

	List<Order> findByUsername(String username);




	

	

}
