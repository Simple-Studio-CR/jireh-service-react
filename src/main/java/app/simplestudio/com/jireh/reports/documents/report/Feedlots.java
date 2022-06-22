package app.simplestudio.com.jireh.reports.documents.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Feedlots {

    @Id
    private String id;

    private String idControlReport;

    private String idWarehouse;

    private int numberFeedlot;

    private String type;

    private Boolean eats;

    private Boolean status;

    private String observations;

    private Date createAt;

}
