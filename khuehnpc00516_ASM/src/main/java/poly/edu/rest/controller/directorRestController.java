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
import poly.edu.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/director")
public class directorRestController {
	@Autowired
	AccountService accountservice;
	
	@GetMapping
	public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return accountservice.getAdministrators() ;
			
		}
		return accountservice.findAll();
	}
}
