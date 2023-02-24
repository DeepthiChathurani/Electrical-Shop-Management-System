package lk.ijse.electricalshop.dto;

import java.util.ArrayList;

public class PlaceOrder {
    private String cusId;
    private String oId;
    public static ArrayList<Orderdetail> orderDetails = new ArrayList<>();

    public PlaceOrder(String orderId, String itemId, String description, int qty, double unitPrice, double total, double finalTotal) {

    }

    public PlaceOrder(String cusId, String oId, ArrayList<Orderdetail> orderDetails) {
        this.cusId = cusId;
        this.oId = oId;
        this.orderDetails = orderDetails;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public static ArrayList<Orderdetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<Orderdetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    @Override
    public String toString() {
        return "PlaceOrder{" +
                "cusId='" + getCusId() + '\'' +
                ", oId='" + getoId() + '\'' +
                ", orderDetails=" + getOrderDetails() +
                '}';
    }

}
