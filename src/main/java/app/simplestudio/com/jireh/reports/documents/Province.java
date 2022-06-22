package app.simplestudio.com.jireh.reports.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Province {
	
	@Id
	private String id;
	
	private Long numberProvince;
	
	private String province;

	public Province() {
	}

	public Province(String province, Long numberProvince) {
		this.province = province;
		this.numberProvince = numberProvince;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getNumberProvince() {
		return numberProvince;
	}

	public void setNumberProvince(Long numberProvince) {
		this.numberProvince = numberProvince;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
