package poly.edu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.entity.Product;
import poly.edu.service.ProductService;

@Controller
public class ProductController {
@Autowired 
ProductService prService;
@RequestMapping("/product/list" )
public String list(Model model, @RequestParam("cid") Optional<String> cid ,
		@RequestParam("page") Optional<Integer> pageNum,@RequestParam("sort")Optional<String> sort) {
	
	if (cid.isPresent()) {
		Pageable page = PageRequest.of(pageNum.orElse(0),8);
		Page<Product> list = prService.findByBrandId(cid.get(),page);
		model.addAttribute("items" , list.getContent());
		model.addAttribute("currentPage", pageNum.orElse(0));
		model.addAttribute("totalPages", list.getTotalPages());
		model.addAttribute("totalItems", list.getTotalElements());
		
	} else {
		Pageable page = PageRequest.of(pageNum.orElse(0), 6);
		Page<Product> list = prService.findAllAvailable(page);
		
		model.addAttribute("items" , list);
		model.addAttribute("currentPage", pageNum.orElse(0));
		model.addAttribute("totalPages", list.getTotalPages());
		model.addAttribute("totalItems", list.getTotalElements());
		
	}
	
	return "product/list";
	
}



@RequestMapping("/product/detail/{id}")
public String detail(Model model , @PathVariable("id") Integer id) {
	Product item = prService.findById(id);
	model.addAttribute("item" , item);
	return "product/detail";
}

}
