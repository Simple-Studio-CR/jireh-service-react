package app.simplestudio.com.jireh.reports.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class District {
	
	@Id
	private String id;
	
	private String district;

	private Long districtId;

	private Long numberDistrict;
	
	private Long cantonId;

	public District() {
	}

	public District(String district, Long cantonId, Long districtId, Long numberDistrict) {
		this.district = district;
		this.cantonId = cantonId;
		this.districtId = districtId;
		this.numberDistrict = numberDistrict;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) { this.districtId = districtId; }

	public Long getNumberDistrict() {return numberDistrict;	}

	public void setNumberDistrict(Long numberDistrict) {this.numberDistrict = numberDistrict;}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Long getCantonId() {
		return cantonId;
	}

	public void setCantonId(Long cantonId) {
		this.cantonId = cantonId;
	}

}
