package lk.ijse.electricalshop.entity;


import java.sql.Date;
import java.time.LocalDate;

public class Orders {
    private String oId;
    private Date date;
    private String cusId;

    public Orders(String oId, LocalDate date, String cusId) {
    }

    public Orders(String oId, Date date, String cusId) {
        this.oId = oId;
        this.date = date;
        this.cusId = cusId;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
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
}
