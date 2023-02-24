package lk.ijse.electricalshop.entity;

public class Orderdetail {
    private static String oId;
    private String itemId;
    private int qty;
    private double unitPrice;

    public Orderdetail() {
    }

    public Orderdetail(String oId, String itemId, int qty, double unitPrice) {
        this.oId = oId;
        this.itemId = itemId;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public static String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
