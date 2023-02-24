package lk.ijse.electricalshop.dto;

import java.util.ArrayList;

public class CartDetail {
    private String supId;
    private String itemId;
    private static ArrayList<SupplierDetails> supplierDetails = new ArrayList<>();

    public CartDetail() {
    }

    public CartDetail(String supId, String itemId) {
        this.supId = supId;
        this.itemId = itemId;
    }

    public static ArrayList<SupplierDetails> getSupplierDetails() {
        return supplierDetails;
    }

    public static void setSupplierDetails(ArrayList<SupplierDetails> supplierDetails) {
        CartDetail.supplierDetails = supplierDetails;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    @Override
    public String toString() {
        return "CartDetail{" +
                "supId='" + supId + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}
