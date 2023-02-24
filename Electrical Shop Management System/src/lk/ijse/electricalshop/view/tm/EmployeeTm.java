package lk.ijse.electricalshop.view.tm;

public class EmployeeTm {
    private String id;
    private String name;
    private String address;
    private String contact_num;

    public EmployeeTm() {
    }

    public EmployeeTm(String id, String name, String address, String contact_num) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact_num = contact_num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "EmployeeTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact_num='" + contact_num + '\'' +
                '}';
    }



}
