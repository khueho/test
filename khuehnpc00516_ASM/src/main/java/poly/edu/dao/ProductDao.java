package poly.edu.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Product;


public interface ProductDao extends JpaRepository<Product, Integer> {
	
	
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(String cid);
	
	
	
	@Query("SELECT p FROM Product p Where p.category.id=?1")
	Page<Product> findByCategoryId(String id, Pageable page);

	@Query("SELECT p FROM Product p Where p.available=true")
	Page<Product> findByAvailable(Pageable page);
	
//	@Query(value = "select CreateDate as 'Time' ,count(Id) as 'so luong',sum(amount) as 'tong tien' from orders where status = 2\r\n"
//			+ "group by CreateDate\r\n"
//			+ "order by CreateDate desc", nativeQuery = true)
//	List<Object[]> getStatisticalByDay();
//
//	@Query(value = "select   cast(year(order_date) as varchar) + '-' +cast(month(order_date) as varchar) month, \r\n"
//			+ "count(order_id) as 'count', sum(amount) as 'sum' from orders where status = 2\r\n"
//			+ "group by month(order_date), year(order_date)\r\n"
//			+ "order by month desc", nativeQuery = true)
//	List<Object[]> getStatisticalByMonth();
//
//	@Query(value = "select year(order_date) as 'year',count(order_id) as 'count', sum(amount) as 'sum' from orders where status = 2\r\n"
//			+ "group by year(order_date)\r\n"
//			+ "order by year(order_date) desc", nativeQuery = true)
//	List<Object[]> getStatisticalByYear();

}
