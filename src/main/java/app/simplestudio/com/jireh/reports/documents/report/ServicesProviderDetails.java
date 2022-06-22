package app.simplestudio.com.jireh.reports.documents.report;

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
public class ServicesProviderDetails {

    @Id
    String id;

    private String productId;

    private String productName;

    private String sanitaryPermission;

    private String activeIngredient;

    private String productDose;

    private String productLabelColor;

    private Long equipmentId;

    private String equipmentName;

    private String equipmentType;

    private String serviceProviderId;
}
