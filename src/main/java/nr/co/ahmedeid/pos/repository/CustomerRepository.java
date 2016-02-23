package nr.co.ahmedeid.pos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nr.co.ahmedeid.pos.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	List<Customer> findByCustomerName(String customerName);
	

}
