package nr.co.ahmedeid.pos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nr.co.ahmedeid.pos.model.Order;

public interface OrderRepository  extends CrudRepository<Order, Long>{
	
	List<Order> getOrderByUsername(String username);
     
}
