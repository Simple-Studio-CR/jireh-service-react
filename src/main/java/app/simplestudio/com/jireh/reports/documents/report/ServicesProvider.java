package app.simplestudio.com.jireh.reports.documents.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document
public class ServicesProvider {
    @Id
    String id;

    String clientId;

    String clientName;

    String clientAddress;

    String warehouseId;

    Date createAt;

    String startTime;

    String endTime;

    String fumigationFrequency;

    String identifier;
}
