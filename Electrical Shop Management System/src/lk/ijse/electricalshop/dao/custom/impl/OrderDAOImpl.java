package lk.ijse.electricalshop.dao.custom.impl;

import lk.ijse.electricalshop.dao.custom.OrderDAO;
import lk.ijse.electricalshop.entity.Orders;
import lk.ijse.electricalshop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    public boolean add(Orders order) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("INSERT INTO Orders VALUES(?,?,?)");
//        pstm.setString(1, order.getoId());
//        pstm.setString(2, String.valueOf(order.getDate()));
//        pstm.setString(3, order.getCusId());
//
//        return pstm.executeUpdate() > 0;
        return CrudUtil.execute("INSERT INTO Orders VALUES(?,?,?)",order.getoId(),
                order.getDate(),order.getCusId());
    }

    @Override
    public boolean update(Orders object) throws SQLException, ClassNotFoundException {
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

    public ResultSet getId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT oId FROM orders ORDER BY LENGTH (oId),oId");
    }
    public boolean setOrders(Orders orders) throws SQLException, ClassNotFoundException {
       return CrudUtil.execute("INSERT INTO orders VALUES (?,?,?)",
                orders.getoId(),
                orders.getDate(),
                orders.getCusId()
        );
    }
}
