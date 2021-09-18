package poly.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.edu.dao.RoleDao;
import poly.edu.entity.Role;
import poly.edu.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {
	@Autowired
	RoleDao rdao;

	
	public List<Role> findAll() {
		return rdao.findAll();
	}

}
