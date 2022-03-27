package app.simplestudio.com.jireh.reports.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Clients {
	
	@Id
	private String id;
	
	private String identification;

	private String typeOfId;
	
	private String name;
	
	private String mail;
	
	private String contact;

	private String scope;

	public Clients() {
	}

	public Clients(String identification,String typeOfId, String name, String mail, String contact, String scope) {
		this.identification = identification;
		this.name = name;
		this.mail = mail;
		this.contact = contact;
		this.scope = scope;
		this.typeOfId = typeOfId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getTypeOfId() {
		return typeOfId;
	}

	public void setTypeOfId(String typeOfId) {
		this.typeOfId = typeOfId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
