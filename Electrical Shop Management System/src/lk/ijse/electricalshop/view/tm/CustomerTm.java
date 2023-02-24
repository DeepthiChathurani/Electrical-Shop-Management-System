package lk.ijse.electricalshop.view.tm;

public class CustomerTm{
    private String cusId;
    private String name;
    private String address;
    private String email;
    private String contact_num;
    private String id;

    public CustomerTm(){
    }

    public CustomerTm(String cusId, String name, String address, String email, String contact_num, String id) {
        this.cusId = cusId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.contact_num = contact_num;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String eId) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomerTm{" +
                "cusId='" + cusId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contact_num='" + contact_num + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
