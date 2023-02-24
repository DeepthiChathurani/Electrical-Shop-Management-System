package lk.ijse.electricalshop.view.tm;

public class ItemTm {
    private String itemId;
    private String description;
    private double unitprice;
    private int qtyOnHand;


    public ItemTm() {
    }

    public ItemTm(String itemId, String description, double unitprice, int qtyOnHand) {
        this.itemId = itemId;
        this.description = description;
        this.unitprice = unitprice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", description='" + description + '\'' +
                ", unitprice=" + unitprice +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
