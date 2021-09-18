package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.entity.Category;
import poly.edu.entity.Role;

public interface RoleDao extends JpaRepository<Role, String>{

}