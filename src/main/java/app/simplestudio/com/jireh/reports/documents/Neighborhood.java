package app.simplestudio.com.jireh.reports.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Neighborhood {
	
	@Id
	private String id;
	
	private String neighborhood;

	private Long neighborhoodId;

	private Long numberNeighborhood;
	
	private Long districtId;

	public Neighborhood() {
	}

	public Neighborhood(String neighborhood, Long districtId, Long neighborhoodId, Long numberNeighborhood) {
		this.neighborhood = neighborhood;
		this.districtId = districtId;
		this.neighborhoodId = neighborhoodId;
		this.numberNeighborhood = numberNeighborhood;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public Long getNeighborhoodId() {
		return neighborhoodId;
	}

	public void setNeighborhoodId(Long neighborhoodId) {
		this.neighborhoodId = neighborhoodId;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Long getNumberNeighborhood() {
		return numberNeighborhood;
	}

	public void setNumberNeighborhood(Long numberNeighborhood) {
		this.numberNeighborhood = numberNeighborhood;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long district) {
		this.districtId = district;
	}

}
