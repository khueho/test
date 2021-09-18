package poly.edu.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.edu.dao.AccountDao;
import poly.edu.dao.RoleDao;
import poly.edu.entity.Authority;
import poly.edu.entity.Category;
import poly.edu.service.AuthorityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {

	@Autowired
	AuthorityService authorityservice;
	
//	@Autowired
//	RoleDao roleDAO;
//	
//	@Autowired
//	AccountDao accountDAO;
	
	@GetMapping
	public List<Authority> findAll (@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return authorityservice.findAuthoritiesOfAdministrators();
		}
		return authorityservice.findAll();
	}

	 
	@PostMapping
	public Authority post (@RequestBody Authority auth) {
		return authorityservice.creat(auth);
	}
	
	@DeleteMapping
	public void delete (@PathVariable("id") Integer id) {
		 authorityservice.delete(id);
	}
	
	
	
}
