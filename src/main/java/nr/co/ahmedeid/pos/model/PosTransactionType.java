package nr.co.ahmedeid.pos.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the POS_TRANSACTION_TYPE database table.
 * 
 */
@Entity
@Table(name="POS_TRANSACTION_TYPE")
@NamedQuery(name="PosTransactionType.findAll", query="SELECT p FROM PosTransactionType p")
public class PosTransactionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANSACTION_TYPE_ID")
	private long transactionTypeId;

	private String description;

	public PosTransactionType() {
	}

	public long getTransactionTypeId() {
		return this.transactionTypeId;
	}

	public void setTransactionTypeId(long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}