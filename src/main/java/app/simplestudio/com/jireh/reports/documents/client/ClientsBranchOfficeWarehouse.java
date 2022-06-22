package app.simplestudio.com.jireh.reports.documents.client;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClientsBranchOfficeWarehouse {
	
	@Id
	private String id;

	private String branchId;
	
	private String name;

	private String sketch;

	public ClientsBranchOfficeWarehouse() {
	}

	public ClientsBranchOfficeWarehouse(String branchId, String name, String sketch) {
		this.name = name;
		this.sketch = sketch;
		this.branchId = branchId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSketch() {
		return sketch;
	}

	public void setSketch(String sketch) {
		this.sketch = sketch;
	}
}
