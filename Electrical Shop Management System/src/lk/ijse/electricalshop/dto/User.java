package lk.ijse.electricalshop.dto;

public class User {
    private String username;
    private String password;
    private String email;
    private String role;
    private String eId;

    public User(String username, String password, String email, String role) {
    }

    public User(String username, String password, String email, String role, String eId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.eId = eId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", eId='" + eId + '\'' +
                '}';
    }
}
