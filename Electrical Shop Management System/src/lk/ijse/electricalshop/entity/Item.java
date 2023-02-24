package lk.ijse.electricalshop.entity;

public class Item {
        private String itemId;
        private String discription;
        private double unitPrice;
        private int qtyOnHand;

        public Item() {
        }

        public Item(String itemId, String discription, double unitPrice, int qtyOnHand) {
                this.itemId = itemId;
                this.discription = discription;
                this.unitPrice = unitPrice;
                this.qtyOnHand = qtyOnHand;
        }

        public String getItemId() {
                return itemId;
        }

        public void setItemId(String itemId) {
                this.itemId = itemId;
        }

        public String getDiscription() {
                return discription;
        }

        public void setDiscription(String discription) {
                this.discription = discription;
        }

        public double getUnitPrice() {
                return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
                this.unitPrice = unitPrice;
        }

        public int getQtyOnHand() {
                return qtyOnHand;
        }

        public void setQtyOnHand(int qtyOnHand) {
                this.qtyOnHand = qtyOnHand;
        }
}
