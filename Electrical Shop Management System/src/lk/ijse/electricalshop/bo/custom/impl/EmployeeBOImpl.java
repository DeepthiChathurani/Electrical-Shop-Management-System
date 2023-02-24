package lk.ijse.electricalshop.bo.custom.impl;

import lk.ijse.electricalshop.bo.custom.EmployeeBO;
import lk.ijse.electricalshop.dao.DAOFactory;
import lk.ijse.electricalshop.dao.custom.EmployeeDAO;
import lk.ijse.electricalshop.dto.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {

    private EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    public boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.add(new lk.ijse.electricalshop.entity.Employee(employee.geteId(),employee.getName(),
                employee.getAddress(),employee.getContact_num()));
    }
    public boolean deleteEmployee(String eId) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(eId);

    }
    public ResultSet searchEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.search(id);
    }
}
