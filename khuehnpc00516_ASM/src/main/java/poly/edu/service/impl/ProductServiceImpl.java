package poly.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poly.edu.dao.ProductDao;
import poly.edu.entity.Product;
import poly.edu.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired 
	ProductDao pdao ;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return pdao.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		// TODO Auto-generated method stub
		return pdao.findByCategoryId(cid);
	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 pdao.deleteById(id);
	}

	@Override
	public Page<Product> findAll(Pageable page) {
		return pdao.findAll(page);
	}

	@Override
	public Page<Product> findByBrandId(String id, Pageable page) {
		return pdao.findByCategoryId(id, page);
	}

	@Override
	public Page<Product> findAllAvailable(Pageable page) {
		return pdao.findByAvailable(page);
	}
	
}
