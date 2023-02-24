package lk.ijse.electricalshop.dao.custom.impl;

import lk.ijse.electricalshop.dao.custom.SupplierDAO;
import lk.ijse.electricalshop.entity.Supplier;
import lk.ijse.electricalshop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {
    public boolean add(Supplier supplier) throws SQLException, ClassNotFoundException {
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
        return CrudUtil.execute("INSERT INTO Supplier VALUES(?,?,?,?,?)",supplier.getSupId(),
                supplier.getSupname(),supplier.getSupaddress(),supplier.getContact_num(),supplier.getItemId());
    }

    @Override
    public boolean update(Supplier object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    public ArrayList<String> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<String> idList = new ArrayList<>();

        ResultSet result = CrudUtil.execute("SELECT supId FROM Supplier");

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
    public ResultSet load(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM supplier WHERE supId=?", id);

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
