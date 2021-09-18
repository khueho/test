package poly.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.edu.dao.AccountDao;
import poly.edu.dao.AuthorityDao;
import poly.edu.entity.Account;
import poly.edu.entity.Authority;
import poly.edu.service.AuthorityService;

@Service
public class AuthotitiesServiceImp  implements AuthorityService{
	@Autowired
	AuthorityDao audao;
	@Autowired
	AccountDao accdao;

	
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> account =accdao.getadministrators();
		return audao.authoritiesOf(account);
	}

	
	public List<Authority> findAll() {
		
		return audao.findAll();
	}

	
	public Authority creat(Authority auth) {
		return audao.save(auth);
	}

	
	public void delete(Integer id) {
		audao.deleteById(id);
		
	}


	
	public List<Authority> findAuthoritiesOfCust() {
		List<Account> account =accdao.getCustistrators();
		return audao.authoritiesOfCust(account);
	}

}
