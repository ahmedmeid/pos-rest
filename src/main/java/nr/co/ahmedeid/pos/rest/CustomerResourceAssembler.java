package nr.co.ahmedeid.pos.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import nr.co.ahmedeid.pos.model.Customer;

@Component
public class CustomerResourceAssembler implements ResourceAssembler<Customer, Resource<Customer>>{

	@Override
	public Resource<Customer> toResource(Customer customer) {

	    Resource<Customer> resource = new Resource<Customer>(customer);
        resource.add(linkTo(CustomersController.class).slash(customer.getCustomerId()).withSelfRel());
        return resource;
	}

}
