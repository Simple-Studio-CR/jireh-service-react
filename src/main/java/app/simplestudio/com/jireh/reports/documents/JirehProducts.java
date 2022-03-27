package app.simplestudio.com.jireh.reports.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class JirehProducts {

	@Id
	private String id;
	
	private String name;
	
	private String sanitaryPermission;
	
	private String features;
	
	private String activeingredient;

	public JirehProducts() {
	}

	public JirehProducts(String name, String sanitaryPermission, String features, String activeingredient) {
		this.name = name;
		this.sanitaryPermission = sanitaryPermission;
		this.features = features;
		this.activeingredient = activeingredient;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSanitaryPermission() {
		return sanitaryPermission;
	}

	public void setSanitaryPermission(String sanitaryPermission) {
		this.sanitaryPermission = sanitaryPermission;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getActiveingredient() {
		return activeingredient;
	}

	public void setActiveingredient(String activeingredient) {
		this.activeingredient = activeingredient;
	}
}
