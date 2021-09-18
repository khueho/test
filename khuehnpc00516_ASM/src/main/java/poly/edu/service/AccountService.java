package poly.edu.service;

import java.util.List;

import poly.edu.entity.Account;
import poly.edu.entity.Product;

public interface AccountService {

public	Account findById(String username);

public List<Account> getAdministrators();

 List<Account> getCustistrators();

 List<Account> findAll();

 Account create(Account account);

 Account update(Account account);

 void delete(String username);
}
