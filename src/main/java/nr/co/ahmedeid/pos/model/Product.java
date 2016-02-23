package nr.co.ahmedeid.pos.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_PRODUCTID_GENERATOR", sequenceName="PRODUCT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_PRODUCTID_GENERATOR")
	@Column(name="PRODUCT_ID")
	private long productId;

	private String barcode;

	private String description;

	private double price;
	
	@ManyToOne
	@JoinColumn(name="CURR_ID")
	private Currency priceCurrency;

	private String serialnum;

	//uni-directional many-to-one association to ProductCat
	@ManyToOne
	@JoinColumn(name="PRODUCT_CAT_ID")
	private ProductCat productCat;

	public Product() {
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSerialnum() {
		return this.serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public ProductCat getProductCat() {
		return this.productCat;
	}

	public void setProductCat(ProductCat productCat) {
		this.productCat = productCat;
	}

	public Currency getPriceCurrency() {
		return priceCurrency;
	}

	public void setPriceCurrency(Currency priceCurrency) {
		this.priceCurrency = priceCurrency;
	}
	
}