package app.simplestudio.com.jireh.reports.documents.report;

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
public class ServicesProviderPestTypeDetail {
    @Id
    String id;

    String serviceProviderId;

    String pestTypeId;

    Boolean apply;

    Integer level;
}
