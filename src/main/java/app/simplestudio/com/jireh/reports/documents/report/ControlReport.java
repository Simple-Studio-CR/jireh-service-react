package app.simplestudio.com.jireh.reports.documents.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document
public class ControlReport {

    @Id
    private String id;

    private Boolean enabled;

    private String idClients;

    private String clientName;

    private String clientAddress;

    private String idWarehouse;

    private Date createAt;

    private String startTime;

    private String endTime;

    private Double total;

    String identifier;

}
