package lk.ijse.electricalshop.dto;

public class SupplierDetails {
    private static String supId;
    private static String itemId;
    private static int qtyOnHand;
    private String description;
    private static double unitPrice;

    public SupplierDetails() {
    }

    public SupplierDetails(String supId, String itemId, int qtyOnHand, String description, double unitPrice) {
        this.supId = supId;
        this.itemId = itemId;
        this.qtyOnHand = qtyOnHand;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public static String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public static String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public static int getQtyOnHand() {
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

    public static double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }



    @Override
    public String toString() {
        return "SupplierDetails{" +
                "supId='" + supId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }


}
