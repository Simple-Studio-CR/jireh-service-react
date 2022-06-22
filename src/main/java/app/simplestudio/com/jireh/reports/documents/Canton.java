package app.simplestudio.com.jireh.reports.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Canton {
	
	@Id
	private String id;
	
	private String canton;

	private Long cantonId;
	
	private Long numberCanton;
	
	private Long numberProvince;

	public Canton() {
	}

	public Canton(String canton, Long numberProvince, Long numberCanton, Long cantonId) {
		this.canton = canton;
		this.numberProvince = numberProvince;
		this.numberCanton = numberCanton;
		this.cantonId = cantonId;
	}

	public Long getCantonId() {
		return cantonId;
	}

	public void setCantonId(Long cantonId) {
		this.cantonId = cantonId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public Long getNumberCanton() {
		return numberCanton;
	}

	public void setNumberCanton(Long numberCanton) {
		this.numberCanton = numberCanton;
	}

	public Long getNumberProvince() {
		return numberProvince;
	}

	public void setNumberProvince(Long province) {
		this.numberProvince = province;
	}

}
