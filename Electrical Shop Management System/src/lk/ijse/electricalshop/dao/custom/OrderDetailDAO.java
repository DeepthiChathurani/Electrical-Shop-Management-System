package lk.ijse.electricalshop.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.dao.CrudDAO;
import lk.ijse.electricalshop.dao.SuperDAO;
import lk.ijse.electricalshop.entity.Orderdetail;
import lk.ijse.electricalshop.dto.Orders;
import lk.ijse.electricalshop.view.tm.PlaceOrderTm;

import java.sql.SQLException;

public interface OrderDetailDAO extends CrudDAO<Orderdetail,String>, SuperDAO {
    public boolean setOrders(Orders orders, ObservableList<PlaceOrderTm> list) throws SQLException, ClassNotFoundException;
}
