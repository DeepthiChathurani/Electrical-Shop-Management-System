package lk.ijse.electricalshop.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.dao.custom.OrderDetailDAO;
import lk.ijse.electricalshop.entity.Orderdetail;
import lk.ijse.electricalshop.dto.Orders;
import lk.ijse.electricalshop.util.CrudUtil;
import lk.ijse.electricalshop.view.tm.PlaceOrderTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    public boolean add(Orderdetail orderDetail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO OrderDetail VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, Orderdetail.getoId(), orderDetail.getItemId(), orderDetail.getQty(),
                orderDetail.getUnitPrice());
    }

    @Override
    public boolean update(Orderdetail object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
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

    @Override
    public ResultSet getId() throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean setOrders(Orders orders, ObservableList<PlaceOrderTm> list) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < list.size(); i++) {

            if (CrudUtil.execute("INSERT INTO orderdetail VALUES (?,?,?,?)",
                    orders.getoId(),
                    list.get(i).getItemId(),
                    list.get(i).getQty(),
                    list.get(i).getUnitPrice()
            ))
            {
            } else {
                return false;
            }
        }

        return true;
    }

}
