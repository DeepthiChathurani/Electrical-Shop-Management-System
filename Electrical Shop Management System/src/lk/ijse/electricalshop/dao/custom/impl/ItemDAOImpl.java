package lk.ijse.electricalshop.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.dao.custom.ItemDAO;
import lk.ijse.electricalshop.entity.Item;
import lk.ijse.electricalshop.util.CrudUtil;
import lk.ijse.electricalshop.view.tm.PaymentTm;
import lk.ijse.electricalshop.view.tm.PlaceOrderTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("DELETE FROM Item where itemId=?");
//        pstm.setObject(1,code);
//
//       return pstm.executeUpdate()>0;
        return CrudUtil.execute("DELETE FROM Item where itemId=?",code);
    }

    @Override
    public ArrayList<String> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet load(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet search(String searchText) throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean add(Item item) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("INSERT INTO Item VALUES(?,?,?,?)");
//        pstm.setString(1, item.getItemId());
//        pstm.setString(2, item.getDescription());
//        pstm.setDouble(3, item.getUnitprice());
//        pstm.setInt(4, item.getQtyOnHand());
//
//
//        return pstm.executeUpdate() > 0;
        return CrudUtil.execute("INSERT INTO Item VALUES(?,?,?,?)",item.getItemId(),
                item.getDiscription(),item.getUnitPrice(),item.getQtyOnHand());
    }

    @Override
    public boolean update(Item object) throws SQLException, ClassNotFoundException {
        return false;
    }

    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        ArrayList<String> codeList = new ArrayList<>();

        ResultSet result = CrudUtil.execute("SELECT itemId FROM Item");

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }
    public  ResultSet laad(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM item WHERE itemId=?", id);
    }

    public  boolean updateItems(ObservableList<PlaceOrderTm> list) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < list.size(); i++) {
            if (CrudUtil.execute("UPDATE item SET qtyOnHand=qtyOnHand-? WHERE itemId=?",
                    list.get(i).getQty(),
                    list.get(i).getItemId()
            )) {
            } else {
                return false;
            }
        }
        return true;
    }
    public  boolean items(ObservableList<PaymentTm> paymentList) throws SQLException, ClassNotFoundException {

        for (int i = 1; i<paymentList .size(); i++) {
            if (CrudUtil.execute("UPDATE item SET qtyOnHand=qtyOnHand+ ? WHERE itemId=?",

                    paymentList.get(i).getQty(),
                    paymentList.get(i).getItemId())) {
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public ResultSet getId() throws SQLException, ClassNotFoundException {
        return null;
    }

    public int updateItem(Item item) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("UPDATE Item SET discription=?, unitprice=?,qtyOnHand=? where itemId=?");
//        pstm.setObject(1,item);
//        pstm.setObject(2,item);
//        pstm.setObject(3,item);
//        pstm.setObject(4,item);
//
//        return pstm.executeUpdate();
        return CrudUtil.execute("UPDATE Item SET discription=?, unitprice=?,qtyOnHand=? where itemId=?",
                item);
    }
}
