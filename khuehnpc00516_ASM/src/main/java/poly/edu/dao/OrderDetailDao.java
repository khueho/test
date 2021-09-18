package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.entity.OrderDetail;


public interface OrderDetailDao extends JpaRepository<OrderDetail, Long> {

}
