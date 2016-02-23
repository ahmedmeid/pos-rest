package nr.co.ahmedeid.pos.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TRANSACTION_PAYMENT database table.
 * 
 */
@Entity
@Table(name="TRANSACTION_PAYMENT")
public class TransactionPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRANSACTION_PAYMENT_PAYMENTID_GENERATOR", sequenceName="TRANSACTION_PAYMENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSACTION_PAYMENT_PAYMENTID_GENERATOR")
	@Column(name="PAYMENT_ID")
	private long paymentId;

	@Column(name="PAYMENT_AMOUNT")
	private double paymentAmount;

	//uni-directional many-to-one association to PaymentMethod
	@ManyToOne
	@JoinColumn(name="PAYMENT_METHOD_ID")
	private PaymentMethod paymentMethod;

	//bi-directional many-to-one association to PosTransaction
	@ManyToOne
	@JoinColumn(name="TRANSACTION_ID")
	private PosTransaction posTransaction;

	public TransactionPayment() {
	}

	public long getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public double getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PosTransaction getPosTransaction() {
		return this.posTransaction;
	}

	public void setPosTransaction(PosTransaction posTransaction) {
		this.posTransaction = posTransaction;
	}

}