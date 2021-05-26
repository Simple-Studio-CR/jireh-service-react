package app.simplestudio.com.jireh.reports.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class ReportsHeader {

    @Id
    private String id;

    private String clientId;

    private String controlId;

    private String mipId;

    private String productsId;

    private String activitiesId;

    private String schedule;

    private Date createAt;

    private String technician;

    public ReportsHeader() {
    }

    public ReportsHeader(String clientId, String controlId, String mipId, String productsId, String activitiesId, String schedule, Date createAt, String technician) {
        this.clientId = clientId;
        this.controlId = controlId;
        this.mipId = mipId;
        this.productsId = productsId;
        this.activitiesId = activitiesId;
        this.schedule = schedule;
        this.createAt = createAt;
        this.technician = technician;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getControlId() {
        return controlId;
    }

    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public String getMipId() {
        return mipId;
    }

    public void setMipId(String mipId) {
        this.mipId = mipId;
    }

    public String getProductsId() {
        return productsId;
    }

    public void setProductsId(String productsId) {
        this.productsId = productsId;
    }

    public String getActivitiesId() {
        return activitiesId;
    }

    public void setActivitiesId(String activitiesId) {
        this.activitiesId = activitiesId;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }
}
