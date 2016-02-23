package nr.co.ahmedeid.pos.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the POS_TRANSACTION database table.
 * 
 */
@Entity
@Table(name="POS_TRANSACTION")
public class PosTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POS_TRANSACTION_TRANSACTIONID_GENERATOR", sequenceName="TRANSACTION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POS_TRANSACTION_TRANSACTIONID_GENERATOR")
	@Column(name="TRANSACTION_ID")
	private long transactionId;

	private BigDecimal status;

	@Column(name="TRANSACTION_AMOUNT")
	private double transactionAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;

	@Column(name="TRANSACTION_OPEN_AMOUNT")
	private double transactionOpenAmount;

	//uni-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

	//uni-directional many-to-one association to PosTransactionType
	@ManyToOne
	@JoinColumn(name="TRANSACTION_TYPE_ID")
	private PosTransactionType posTransactionType;

	//bi-directional many-to-one association to TransactionPayment
	@OneToMany(mappedBy="posTransaction")
	private List<TransactionPayment> transactionPayments;

	//uni-directional many-to-many association to Product
	@ManyToMany
	@JoinTable(
		name="TRANSACTION_DETAIL"
		, joinColumns={
			@JoinColumn(name="TRANSACTION_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="PRODUCT_ID")
			}
		)
	private List<Product> products;

	public PosTransaction() {
	}

	public long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public double getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionOpenAmount() {
		return this.transactionOpenAmount;
	}

	public void setTransactionOpenAmount(double transactionOpenAmount) {
		this.transactionOpenAmount = transactionOpenAmount;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PosTransactionType getPosTransactionType() {
		return this.posTransactionType;
	}

	public void setPosTransactionType(PosTransactionType posTransactionType) {
		this.posTransactionType = posTransactionType;
	}

	public List<TransactionPayment> getTransactionPayments() {
		return this.transactionPayments;
	}

	public void setTransactionPayments(List<TransactionPayment> transactionPayments) {
		this.transactionPayments = transactionPayments;
	}

	public TransactionPayment addTransactionPayment(TransactionPayment transactionPayment) {
		getTransactionPayments().add(transactionPayment);
		transactionPayment.setPosTransaction(this);

		return transactionPayment;
	}

	public TransactionPayment removeTransactionPayment(TransactionPayment transactionPayment) {
		getTransactionPayments().remove(transactionPayment);
		transactionPayment.setPosTransaction(null);

		return transactionPayment;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}