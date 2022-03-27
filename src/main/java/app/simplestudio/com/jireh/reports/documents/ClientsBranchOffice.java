package app.simplestudio.com.jireh.reports.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClientsBranchOffice {

	@Id
	private String id;

	private String clientId;
	
	private String name;
	
	private String province;

	private String canton;

	private String district;

	private String neighborhood;

	private String addressDetails;

	public ClientsBranchOffice() {
	}

	public ClientsBranchOffice(String clientId, String name, String province, String canton, String district, String neighborhood, String addressDetails) {
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}
}
