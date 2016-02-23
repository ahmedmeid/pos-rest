package nr.co.ahmedeid.pos.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nr.co.ahmedeid.pos.model.Order;
import nr.co.ahmedeid.pos.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{username}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE })
	ResponseEntity<Resource<Order>> getLastOrder(@PathVariable String username)
	{
		List<Order> orders = orderRepository.getOrderByUsername(username);
		Order order = orders.get(0);
		Resource<Order> resource = new Resource<Order>(order);
		resource.add(linkTo(OrdersController.class).slash(order.getOrderId()).withSelfRel());
		return new ResponseEntity<Resource<Order>>(resource, HttpStatus.OK);
	}
	

}
