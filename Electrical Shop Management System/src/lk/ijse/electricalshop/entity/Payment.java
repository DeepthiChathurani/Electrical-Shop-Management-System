package lk.ijse.electricalshop.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class Payment {
    private String payId;
    private Time time;
    private Date date;
    private String oId;

    public Payment(String pId, LocalDate date, String supId) {
    }

    public Payment(String payId, Time time, Date date, String oId) {
        this.payId = payId;
        this.time = time;
        this.date = date;
        this.oId = oId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }
}
