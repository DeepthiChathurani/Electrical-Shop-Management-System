package lk.ijse.electricalshop.dao.custom.impl;

import lk.ijse.electricalshop.dao.custom.EmployeeDAO;
import lk.ijse.electricalshop.entity.Employee;
import lk.ijse.electricalshop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    public boolean delete(String eId) throws SQLException, ClassNotFoundException {

return CrudUtil.execute("DELETE FROM Employee where eId=?",eId);
    }

    @Override
    public ArrayList<String> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet load(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean add(Employee employee) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("INSERT INTO Employee VALUES(?, ?, ?, ?)",employee.geteId(),
                employee.getName(),employee.getAddress(),employee.getContact_num());
    }

    @Override
    public boolean update(Employee object) throws SQLException, ClassNotFoundException {
        return false;
    }


    public ResultSet search(String searchText) throws SQLException, ClassNotFoundException {

              return CrudUtil.execute("SELECT * FROM Employee WHERE eId LIKE ?",
               searchText);
   }

    @Override
    public ResultSet getId() throws SQLException, ClassNotFoundException {
        return null;
    }


}
