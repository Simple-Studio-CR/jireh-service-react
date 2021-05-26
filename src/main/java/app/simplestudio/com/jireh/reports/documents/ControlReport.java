package app.simplestudio.com.jireh.reports.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class ControlReport {

    @Id
    private String id;

    private String idClients;

    private String idWarehouse;

    private Date createAt;

    private Integer month;

    private Integer week;

    private Integer year;

    private Double total;

    public ControlReport() {
    }

    public ControlReport(String idWarehouse,String idClients, Date createAt, Integer month, Integer week, Integer year, Double total) {
        this.idWarehouse = idWarehouse;
        this.createAt = createAt;
        this.month = month;
        this.week = week;
        this.year = year;
        this.total = total;
        this.idClients = idClients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdWarehouse() {
        return idWarehouse;
    }

    public String getIdClients() {
        return idClients;
    }

    public void setIdClients(String idClients) {
        this.idClients = idClients;
    }

    public void setIdWarehouse(String idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getMonth() {

        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getWeek() {

        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getYear() {

        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
