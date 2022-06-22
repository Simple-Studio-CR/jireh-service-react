package app.simplestudio.com.jireh.reports.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document
public class JirehProducts {

	@Id
	private String id;
	
	private String name;
	
	private String sanitaryPermission;
	
	private String features;
	
	private String activeingredient;

	private String dose;

	private String labelColor;
}
