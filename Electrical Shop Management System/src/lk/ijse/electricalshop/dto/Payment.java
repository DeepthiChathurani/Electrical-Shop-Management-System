package lk.ijse.electricalshop.dto;

import java.time.LocalDate;

public class Payment {
    private String pId;
    private LocalDate date;
    private String supId;

    public Payment() {
    }

    public Payment(String pId, LocalDate date, String supId) {
        this.pId = pId;
        this.date = date;
        this.supId = supId;
    }

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "pId='" + pId + '\'' +
                ", date=" + date +
                ", supId='" + supId + '\'' +
                '}';
    }
}
