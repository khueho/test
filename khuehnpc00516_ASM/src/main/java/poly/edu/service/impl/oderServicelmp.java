package poly.edu.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import poly.edu.dao.OderDao;
import poly.edu.dao.OrderDetailDao;
import poly.edu.entity.Order;
import poly.edu.entity.OrderDetail;
import poly.edu.service.oderService;

@Service
public class oderServicelmp implements oderService {
	@Autowired 
	OderDao odao;
	
	@Autowired 
	OrderDetailDao oddao;

	@Override
	public Order create(JsonNode oderdata) {
		ObjectMapper mapper = new ObjectMapper();
		Order oder = mapper.convertValue(oderdata, Order.class);
		odao.save(oder);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(oderdata.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(oder)).collect(Collectors.toList());
		oddao.saveAll(details);
		return oder;
		
	}

	@Override
	public Order findById(Long id) {
		
		return odao.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		// TODO Auto-generated method stub
		return odao.findByUsername(username);
	}

}
