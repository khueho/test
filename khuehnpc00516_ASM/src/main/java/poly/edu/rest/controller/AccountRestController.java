package poly.edu.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.edu.entity.Account;
import poly.edu.entity.Product;
import poly.edu.entity.Role;
import poly.edu.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountService accountservice;
	
//	@GetMapping
//	public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
//		if(admin.orElse(false)) {
//			return accountservice.getAdministrators() ;
//			
//		}
//		return accountservice.findAll();
//	}
	
	@GetMapping
	public List<Account> getAccountscust(@RequestParam("user") Optional<Boolean> user){
		if(user.orElse(false)) {
			return accountservice.getCustistrators() ;
			
		}
		return accountservice.findAll();
	}
	
	@PostMapping
	public Account create(@RequestBody Account account) {
		return accountservice.create(account);
	}
	
	@PutMapping("{username}")
	public Account update(@PathVariable("username") String username ,@RequestBody Account account) {
		return accountservice.update(account);
	}
	
	@DeleteMapping("{username}")
	public void delete(@PathVariable("username") String username ) {
		 accountservice.delete(username);
	}
	
	
}
