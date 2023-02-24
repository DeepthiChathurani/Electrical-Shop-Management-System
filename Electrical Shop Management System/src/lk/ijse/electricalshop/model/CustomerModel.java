package lk.ijse.electricalshop.model;

import lk.ijse.electricalshop.dao.custom.CustomerDAO;
import lk.ijse.electricalshop.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.electricalshop.dto.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
private static CustomerDAO customerDAO = new CustomerDAOImpl();

    public boolean add(Customer customer) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("INSERT INTO Customer VALUES(?,?,?,?,?,?)");
//        pstm.setString(1, customer.getCusId());
//        pstm.setString(2, customer.getName());
//        pstm.setString(3, customer.getAddress());
//        pstm.setString(4, customer.getEmail());
//        pstm.setString(5, customer.getContact_num());
//        pstm.setString(6, customer.geteId());
//
//
//        return pstm.executeUpdate() > 0;

//        String sql = "INSERT INTO Customer VALUES (?,?,?,?.?,?)";
//        return CrudUtil.execute(sql, customer.getCusId(), customer.getName(), customer.getAddress(), customer.getEmail(),customer.getContact_num(),customer.geteId());

     return customerDAO.add(new lk.ijse.electricalshop.entity.Customer(customer.getCusId(),customer.getName(),
             customer.getAddress(),customer.getEmail(),customer.getContact_num(),customer.geteId()));
    }


    public static ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
//        String sql = "SELECT cusId FROM Customer";
//        ResultSet result = CrudUtil.execute(sql);
//
//        ArrayList<String> idList = new ArrayList<>();
//
//        while (result.next()) {
//            idList.add(result.getString(1));
//        }
        return customerDAO.loadAll();
   }
    public static ResultSet load(String id) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT * FROM customer WHERE cusId=?", id);
        return customerDAO.load(id);
    }
}
