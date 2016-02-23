package nr.co.ahmedeid.pos.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;

import nr.co.ahmedeid.pos.model.Order;

public class OrdersResourceAssembler  implements ResourceAssembler<Order, Resource<Order>>{

	@Override
	public Resource<Order> toResource(Order order) {
		 Resource<Order> resource = new Resource<Order>(order);
		 resource.add(linkTo(OrdersController.class).slash(order.getOrderId()).withSelfRel());
		 return null;
	}

}
