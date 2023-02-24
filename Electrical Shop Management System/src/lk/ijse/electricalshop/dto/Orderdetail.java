package lk.ijse.electricalshop.dto;

public class Orderdetail {
    private static String orderId;
    private String itemId;
    private int qtyOnHand;
    private String description;
    private double unitPrice;

    public Orderdetail(String orderId, String itemId, String description, int qty, double unitPrice) {
    }

    public Orderdetail(String orderId, String itemId, int qtyOnHand, String description, double unitPrice) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.qtyOnHand = qtyOnHand;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    
    public static String getOrderId() {
        return orderId;
    }

    public static void add(Orderdetail orderdetail) {
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "orderId='" + orderId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }



}
