package lk.ijse.electricalshop.bo.custom;

import lk.ijse.electricalshop.bo.SuperBO;
import lk.ijse.electricalshop.dto.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {
    boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    boolean deleteEmployee(String eId) throws SQLException, ClassNotFoundException;
    ResultSet searchEmployee(String id) throws SQLException, ClassNotFoundException;
}
