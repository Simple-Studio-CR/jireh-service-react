package app.simplestudio.com.jireh.reports.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Feedlots {

    @Id
    private String id;

    private String idControlReport;

    private String idWarehouse;

    private String numberFeedlot;

    private Boolean eats;

    private Date createAt;

    public Feedlots() {
    }

    public Feedlots(String idControlReport, String idWarehouse, String numberFeedlot, Boolean eats, Date createAt) {
        this.idControlReport = idControlReport;
        this.idWarehouse = idWarehouse;
        this.numberFeedlot = numberFeedlot;
        this.eats = eats;
        this.createAt = createAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdControlReport() {
        return idControlReport;
    }

    public void setIdControlReport(String idControlReport) {
        this.idControlReport = idControlReport;
    }

    public String getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(String idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public String getNumberFeedlot() {
        return numberFeedlot;
    }

    public void setNumberFeedlot(String numberFeedlot) {
        this.numberFeedlot = numberFeedlot;
    }

    public Boolean getEats() {
        return eats;
    }

    public void setEats(Boolean eats) {
        this.eats = eats;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
