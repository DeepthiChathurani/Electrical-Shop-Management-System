package lk.ijse.electricalshop.dao.custom.impl;

import lk.ijse.electricalshop.dao.custom.CustomerDAO;
import lk.ijse.electricalshop.entity.Customer;
import lk.ijse.electricalshop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    public boolean add(Customer customer) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("INSERT INTO Customer VALUES(?,?,?,?,?,?)",customer.getCusId(),customer.getName(),
                customer.getAddress(),customer.getEmail(),customer.getContact_num(),customer.geteId());
    }

    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("UPDATE Customer SET name=?, address=?,email=?,contact_num=?,eId=?  where cusId=?",customer.getName(),
                customer.getAddress(),customer.getEmail(),customer.getContact_num(),customer.geteId(),customer.getCusId());
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("DELETE FROM Customer where cusId=?",id);
    }
    public ArrayList<String> loadAll() throws SQLException, ClassNotFoundException {

        ArrayList<String> idList = new ArrayList<>();

        ResultSet result = CrudUtil.execute("SELECT cusId FROM Customer");

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

    @Override
    public ResultSet load(String id) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public ResultSet search(String searchText) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet getId() throws SQLException, ClassNotFoundException {
        return null;
    }


}
