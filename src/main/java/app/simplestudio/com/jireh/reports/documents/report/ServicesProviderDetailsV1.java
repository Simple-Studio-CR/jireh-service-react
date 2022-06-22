package app.simplestudio.com.jireh.reports.documents.report;

import app.simplestudio.com.jireh.reports.documents.Equipment;
import app.simplestudio.com.jireh.reports.documents.JirehProducts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document
public class ServicesProviderDetailsV1 {

    @Id
    private String id;

    private JirehProducts products;

    private Equipment equipment;

    private String serviceProviderId;

    private String timeOff;
}
