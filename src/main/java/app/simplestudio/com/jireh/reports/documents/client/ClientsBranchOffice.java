package app.simplestudio.com.jireh.reports.documents.client;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClientsBranchOffice {

	@Id
	private String id;

	private String clientId;
	
	private String name;
	
	private Long province;

	private Long canton;

	private Long district;

	private Long neighborhood;

	private String addressDetails;

	public ClientsBranchOffice() {
	}

	public ClientsBranchOffice(String clientId, String name, Long province, Long canton, Long district, Long neighborhood, String addressDetails) {
		this.name = name;
		this.province = province;
		this.canton = canton;
		this.district = district;
		this.neighborhood = neighborhood;
		this.addressDetails = addressDetails;
		this.clientId = clientId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProvince() {
		return province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}

	public Long getCanton() {
		return canton;
	}

	public void setCanton(Long canton) {
		this.canton = canton;
	}

	public Long getDistrict() {
		return district;
	}

	public void setDistrict(Long district) {
		this.district = district;
	}

	public Long getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Long neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}
}
