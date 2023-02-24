package lk.ijse.electricalshop.entity;

public class Supplier {
    private String supId;
    private String supname;
    private String supaddress;
    private String contact_num;
    private String itemId;

    public Supplier() {
    }

    public Supplier(String supId, String supname, String supaddress, String contact_num, String itemId) {
        this.supId = supId;
        this.supname = supname;
        this.supaddress = supaddress;
        this.contact_num = contact_num;
        this.itemId = itemId;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getSupaddress() {
        return supaddress;
    }

    public void setSupaddress(String supaddress) {
        this.supaddress = supaddress;
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
}
