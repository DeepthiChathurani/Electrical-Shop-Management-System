package lk.ijse.electricalshop.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.bo.custom.PlaceOrderBO;
import lk.ijse.electricalshop.dao.DAOFactory;
import lk.ijse.electricalshop.dao.custom.ItemDAO;
import lk.ijse.electricalshop.dao.custom.OrderDetailDAO;
import lk.ijse.electricalshop.db.DBConnection;
import lk.ijse.electricalshop.model.OrdersModel;
import lk.ijse.electricalshop.dto.Orders;
import lk.ijse.electricalshop.view.tm.PlaceOrderTm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);

    public boolean placeOrder(Orders orders, ObservableList<PlaceOrderTm> list) throws SQLException {


        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            if (OrdersModel.setOrder(orders)) {
                if (orderDetailDAO.setOrders(orders, list)) {
                    if (itemDAO.updateItems(list)) {
                        connection.commit();
                        return true;
                    } else {
                        connection.rollback();
                    }
                } else {
                    connection.rollback();
                }

            } else {
                connection.rollback();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }
        return false;
    }
    public ResultSet laad(String id) throws SQLException, ClassNotFoundException{
        return itemDAO.laad(id);
    }
    public ArrayList<String> loadItemCode() throws SQLException, ClassNotFoundException {

        return itemDAO.loadItemCodes();
    }
}
