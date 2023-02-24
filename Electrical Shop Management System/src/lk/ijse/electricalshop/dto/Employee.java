package lk.ijse.electricalshop.dto;

public class Employee {
    private String eId;
    private String name;
    private String address;
    private String contact_num;

    public Employee(String id, String description, Double unitPrice, Integer qtyOnHand) {
    }

    public Employee(String eId, String name, String address, String contact_num) {
        this.eId = eId;
        this.name = name;
        this.address = address;
        this.contact_num = contact_num;
    }


    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_num() {
        return contact_num;
    }

    public void setContact_num(String contact_num) {
        this.contact_num = contact_num;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId='" + eId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact_num='" + contact_num + '\'' +
                '}';
    }
}
