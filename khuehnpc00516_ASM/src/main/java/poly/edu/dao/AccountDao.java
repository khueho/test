package poly.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Account;


public interface AccountDao extends JpaRepository<Account, String> {

	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('DIRE','STAF')")
	List<Account> getadministrators();
	
	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('CUST','')")
	List<Account> getCustistrators();
}
