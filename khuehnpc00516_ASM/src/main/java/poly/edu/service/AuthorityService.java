package poly.edu.service;

import java.util.List;

import poly.edu.entity.Authority;

public interface AuthorityService {

	public List<Authority> findAuthoritiesOfAdministrators();

	public List<Authority> findAll() ;

	public Authority creat(Authority auth);

	public void delete(Integer id);

	public List<Authority> findAuthoritiesOfCust();
	

}
