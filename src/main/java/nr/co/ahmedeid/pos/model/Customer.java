package nr.co.ahmedeid.pos.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUSTOMER_CUSTOMERID_GENERATOR", sequenceName="CUSTOMER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMER_CUSTOMERID_GENERATOR")
	@Column(name="CUSTOMER_ID")
	private long customerId;

	private String address;

	@Column(name="CUSTOMER_NAME")
	private String customerName;

	@Column(name="TEL_NO")
	private String telNo;

	public Customer() {
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTelNo() {
		return this.telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

}