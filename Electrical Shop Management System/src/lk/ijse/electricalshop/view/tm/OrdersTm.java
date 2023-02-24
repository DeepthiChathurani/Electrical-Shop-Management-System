package lk.ijse.electricalshop.view.tm;

import java.sql.Date;

public class OrdersTm {
    private String id;
    private Date date;
    private String cusId;

    public OrdersTm() {
    }

    public OrdersTm(String id, Date date, String cusId) {
        this.id = id;
        this.date = date;
        this.cusId = cusId;
    }

    public String getId() {
        return id;
    }

    public void setId(String oId) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", cusId='" + cusId + '\'' +
                '}';
    }
}
