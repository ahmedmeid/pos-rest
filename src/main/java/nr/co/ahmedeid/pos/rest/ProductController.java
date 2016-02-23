package nr.co.ahmedeid.pos.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nr.co.ahmedeid.pos.exception.ProductDoesNotExistException;
import nr.co.ahmedeid.pos.model.Product;
import nr.co.ahmedeid.pos.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
   @Autowired
   private ProductRepository productRepository;
   
      @RequestMapping(method = RequestMethod.POST, value = "")
	  ResponseEntity<Void> createProduct(@RequestBody Product product)
	  {
	    productRepository.save(product);
	    HttpHeaders headers = new HttpHeaders();
		headers.setLocation(linkTo(ProductController.class).slash(product.getProductId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	  }
      
      @RequestMapping(method = RequestMethod.GET, value = "/{barcode}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE })
	  ResponseEntity<Resource<Product>> getProductByBarcode(@PathVariable String barcode) throws ProductDoesNotExistException
	  {
    	  List<Product> products = productRepository.findByBarcode(barcode);
    	  if(products.size()==0)
    	  {
    		  throw new ProductDoesNotExistException(barcode);
    	  }
    	  Product product = products.get(0);
    	  Resource<Product> resource = new Resource<Product>(product);
    	  resource.add(linkTo(ProductController.class).slash(product.getProductId()).withSelfRel());
    	  return new ResponseEntity<Resource<Product>>(resource, HttpStatus.OK);
	  }
      
      @ExceptionHandler(ProductDoesNotExistException.class)
      ResponseEntity<String> handleNotFounds(Exception e) {
          return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
      }
      
      @ExceptionHandler(IllegalArgumentException.class)
      ResponseEntity<String> handleBadRequests(Exception e) {
          return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
}
