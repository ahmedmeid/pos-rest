package nr.co.ahmedeid.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {
	
	@Id
	@Column(name="CURR_ID")
	private Long currencyId;
	
	@Column(name="CURR_CODE")
	private String currencyCode;
	
	@Column(name="CURR_DESC")
	private String currencyDesc;

	public Long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyDesc() {
		return currencyDesc;
	}

	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
	}
	
	

}
