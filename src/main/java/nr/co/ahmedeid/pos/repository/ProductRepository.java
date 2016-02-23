package nr.co.ahmedeid.pos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nr.co.ahmedeid.pos.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	List<Product> findByBarcode(String barcode);

}
