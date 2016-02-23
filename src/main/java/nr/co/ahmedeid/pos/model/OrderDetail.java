package nr.co.ahmedeid.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POS_ORDER_DETAIL")
public class OrderDetail {
	
	@Id
	@Column(name="ORDER_DETAIL_ID")
	Long orderDetailId;
	
	@Column(name="ORDER_ID")
	Long orderId;
	
	@Column(name="DESCRIPTION")
	String description;
	
	@Column(name="PRICE")
	Float price;
	
	
	public Long getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
}
