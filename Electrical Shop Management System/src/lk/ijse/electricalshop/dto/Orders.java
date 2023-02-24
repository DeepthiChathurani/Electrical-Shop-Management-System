package lk.ijse.electricalshop.dto;

import java.time.LocalDate;

public class Orders {
    private String oId;
    private LocalDate date;
    private String cusId;



    public Orders(String oId,LocalDate date, String cusId) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
                "oId='" + oId + '\'' +
                ", date=" + date +
                ", cusId='" + cusId + '\'' +
                '}';
    }
}
