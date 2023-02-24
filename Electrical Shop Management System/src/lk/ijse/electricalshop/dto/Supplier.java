package lk.ijse.electricalshop.dto;

public class Supplier {
    private String supId;
    private String supName;
    private String supAddress;
    private String contact_num;
    private String itemId;


    public Supplier() {
    }

    public Supplier(String supId, String supName, String supAddress, String contact_num, String itemId) {
        this.supId = supId;
        this.supName = supName;
        this.supAddress = supAddress;
        this.contact_num = contact_num;
        this.itemId = itemId;
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
        return "Supplier{" +
                "supId='" + supId + '\'' +
                ", supName='" + supName + '\'' +
                ", supAddress='" + supAddress + '\'' +
                ", contact_num='" + contact_num + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}
