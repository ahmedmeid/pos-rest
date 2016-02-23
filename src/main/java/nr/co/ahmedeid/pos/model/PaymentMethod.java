package nr.co.ahmedeid.pos.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PAYMENT_METHOD database table.
 * 
 */
@Entity
@Table(name="PAYMENT_METHOD")
public class PaymentMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAYMENT_METHOD_ID")
	private long paymentMethodId;

	private String description;

	public PaymentMethod() {
	}

	public long getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public void setPaymentMethodId(long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}