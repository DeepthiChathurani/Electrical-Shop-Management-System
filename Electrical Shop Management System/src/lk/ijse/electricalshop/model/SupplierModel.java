package lk.ijse.electricalshop.model;


import lk.ijse.electricalshop.dao.custom.SupplierDAO;
import lk.ijse.electricalshop.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.electricalshop.dto.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierModel {
    static SupplierDAO supplierDAO = new SupplierDAOImpl();
    public static boolean add(Supplier supplier) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("INSERT INTO Supplier VALUES(?,?,?,?,?)");
//        pstm.setString(1, supplier.getSupId());
//        pstm.setString(2, supplier.getSupName());
//        pstm.setString(3, supplier.getSupAddress());
//        pstm.setString(4, supplier.getContact_num());
//        pstm.setString(5, supplier.getItemId());
//
//
//        return pstm.executeUpdate() > 0;

        return supplierDAO.add(new lk.ijse.electricalshop.entity.Supplier(supplier.getSupId(),supplier.getSupName(),
                supplier.getSupAddress(),supplier.getContact_num(),supplier.getItemId()));

    }
//    public static boolean save(Supplier supplier) throws SQLException, ClassNotFoundException {
//        String sql = "INSERT INTO Supplier VALUES(?,?,?,?,?)";
//        return CrudUtil.execute(sql, supplier.getSupId(), supplier.getSupName(),
//                supplier.getSupAddress(), supplier.getContact_num(), supplier.getItemId());
//    }
    public static ArrayList<String> loadSupplierIds() throws SQLException, ClassNotFoundException {
//        String sql = "SELECT supId FROM Supplier";
//        ResultSet result = CrudUtil.execute(sql);
//
//        ArrayList<String> idList = new ArrayList<>();
//
//        while (result.next()) {
//            idList.add(result.getString(1));
//        }
//        return idList;
        return supplierDAO.loadAll();
    }
    public static ResultSet load(String id) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT * FROM supplier WHERE supId=?", id);
        return supplierDAO.load(id);
    }
}
