package nr.co.ahmedeid.pos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="POS_ORDER")
public class Order {
	
	@Id
	@Column(name="ORDER_ID")
	Long orderId;
	
	@Column(name="USERNAME")
	String username;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	Customer customer;
	
	@OneToMany(mappedBy="orderId")
	List<OrderDetail> details;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderDetail> getDetails() {
		return details;
	}
	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}
}
