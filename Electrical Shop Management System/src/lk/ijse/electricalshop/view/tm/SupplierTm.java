package lk.ijse.electricalshop.view.tm;

import javafx.scene.control.Button;

public class SupplierTm {
    private String supId;
    private String supName;
    private String supAddress;
    private String contact_num;
    private String itemId;



    public SupplierTm(String supId, String supName, String supAddress, String contact_num, String itemId) {
        this.setSupId(supId);
        this.setSupName(supName);
        this.setSupAddress(supAddress);
        this.setContact_num(contact_num);
        this.setItemId(itemId);
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }

    public String getContact_num() {
        return contact_num;
    }

    public void setContact_num(String contact_num) {
        this.contact_num = contact_num;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    @Override
    public String toString() {
        return "SupplierTm{" +
                "supId='" + supId + '\'' +
                ", supName='" + supName + '\'' +
                ", supAddress='" + supAddress + '\'' +
                ", contact_num='" + contact_num + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }

}
