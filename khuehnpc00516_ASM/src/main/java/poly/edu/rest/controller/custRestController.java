package poly.edu.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.edu.entity.Account;
import poly.edu.entity.Authority;
import poly.edu.service.AccountService;
import poly.edu.service.AuthorityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/cust")
public class custRestController {
	@Autowired
	AccountService accountservice;
	@Autowired
	AuthorityService authorityservice;
	
	@GetMapping
	public List<Authority> findcust (@RequestParam("user") Optional<Boolean> user){
		if(user.orElse(false)) {
			return authorityservice.findAuthoritiesOfCust();
		}
		return authorityservice.findAll();
	}
}
