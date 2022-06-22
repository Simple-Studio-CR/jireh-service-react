package app.simplestudio.com.jireh.reports.documents.client;

import app.simplestudio.com.jireh.reports.documents.Canton;
import app.simplestudio.com.jireh.reports.documents.District;
import app.simplestudio.com.jireh.reports.documents.Neighborhood;
import app.simplestudio.com.jireh.reports.documents.Province;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Clients {
	
	@Id
	private String id;

	@Indexed(unique = true)
	private String identification;

	private String typeOfId;
	
	private String name;
	
	private String mail;
	
	private String contact;

	private String scope;

	private Long province;

	private Long canton;

	private Long district;

	private Long neigh;

	private String address;
}
