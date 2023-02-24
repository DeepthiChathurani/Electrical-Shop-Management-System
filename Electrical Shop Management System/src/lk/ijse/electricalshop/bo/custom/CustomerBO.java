package lk.ijse.electricalshop.bo.custom;

import lk.ijse.electricalshop.bo.SuperBO;
import lk.ijse.electricalshop.dto.Customer;

import java.sql.SQLException;

public interface CustomerBO extends SuperBO {
    boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    void addCustomer(Customer customer) throws SQLException, ClassNotFoundException;
}
