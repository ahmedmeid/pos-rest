package nr.co.ahmedeid.pos.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRODUCT_CAT database table.
 * 
 */
@Entity
@Table(name="PRODUCT_CAT")
public class ProductCat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_CAT_PRODUCTCATID_GENERATOR", sequenceName="PRODUCT_CAT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_CAT_PRODUCTCATID_GENERATOR")
	@Column(name="PRODUCT_CAT_ID")
	private long productCatId;

	private String description;

	public ProductCat() {
	}

	public long getProductCatId() {
		return this.productCatId;
	}

	public void setProductCatId(long productCatId) {
		this.productCatId = productCatId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}