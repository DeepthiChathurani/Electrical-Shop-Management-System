package lk.ijse.electricalshop.entity;

public class Supplierdetail {
    private String itemId;
    private String supId;
    private int qty;
    private double unitPrice;

    public Supplierdetail() {
    }

    public Supplierdetail(String itemId, String supId, int qty, double unitPrice) {
        this.itemId = itemId;
        this.supId = supId;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
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
