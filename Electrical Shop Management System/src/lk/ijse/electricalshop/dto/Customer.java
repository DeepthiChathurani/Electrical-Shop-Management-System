package lk.ijse.electricalshop.dto;

public class Customer {
    private String cusId;
    private String name;
    private String address;
    private String email;
    private String contact_num;
    private String eId;


    public Customer() {
    }

    public Customer(String cusId, String name, String address, String email, String contact_num, String eId) {
        this.cusId = cusId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.contact_num = contact_num;
        this.eId = eId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_num() {
        return contact_num;
    }

    public void setContact_num(String contact_num) {
        this.contact_num = contact_num;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId='" + cusId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contact_num='" + contact_num + '\'' +
                ", eId='" + eId + '\'' +
                '}';
    }
}
