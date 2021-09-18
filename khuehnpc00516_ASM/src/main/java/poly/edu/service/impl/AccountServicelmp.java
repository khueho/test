package poly.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.edu.dao.AccountDao;
import poly.edu.entity.Account;
import poly.edu.service.AccountService;

@Service
public class AccountServicelmp implements AccountService {

	@Autowired
	AccountDao accdao;
	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return accdao.findById(username).get();
	}
	
	public List<Account> getAdministrators() {
		
		return accdao.getadministrators();
	}
	
	public List<Account> findAll() {
		return accdao.findAll();
	}

	
	public List<Account> getCustistrators() {
		return accdao.getCustistrators();
	}

	@Override
	public Account create(Account account) {
		return accdao.save(account);
	}

	@Override
	public Account update(Account account) {
		return accdao.save(account);
	}

	@Override
	public void delete(String username) {
		accdao.deleteById(username);
		
	}

}
