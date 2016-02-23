package nr.co.ahmedeid.pos.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

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

import nr.co.ahmedeid.pos.exception.CustomerDoesNotExistException;
import nr.co.ahmedeid.pos.model.Customer;
import nr.co.ahmedeid.pos.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomersController {
	 
	 @Autowired
	 private CustomerRepository customerRepository;
	 
	 @Autowired
	 private CustomerResourceAssembler customerResourceAssembler;
	 
	 
	  @RequestMapping(method = RequestMethod.POST, value = "")
	  ResponseEntity<Void> createCustomer(@RequestBody Customer customer)
	  {
		  customerRepository.save(customer);
		  HttpHeaders headers = new HttpHeaders();
		  headers.setLocation(linkTo(CustomersController.class).slash(customer.getCustomerId()).toUri());
		  return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	  }
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/{customerId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE })
	  ResponseEntity<Resource<Customer>> getCustomer(@PathVariable Long customerId) throws CustomerDoesNotExistException {
	        Customer customer = this.customerRepository.findOne(customerId);
	        if(customer== null)
	        {
	        	throw new CustomerDoesNotExistException(customerId);
	        }
	        Resource<Customer> resource = this.customerResourceAssembler.toResource(customer);
	        return new ResponseEntity<Resource<Customer>>(resource, HttpStatus.OK);
	    }
	  
	  @ExceptionHandler(CustomerDoesNotExistException.class)
	  ResponseEntity<String> handleNotFounds(Exception e) {
          return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
      }
	  
	  @ExceptionHandler(IllegalArgumentException.class)
      ResponseEntity<String> handleBadRequests(Exception e) {
          return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }

}
