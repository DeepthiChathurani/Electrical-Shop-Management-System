package lk.ijse.electricalshop.dao.custom;

import lk.ijse.electricalshop.dao.CrudDAO;
import lk.ijse.electricalshop.dao.SuperDAO;
import lk.ijse.electricalshop.entity.Orders;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<Orders,String>, SuperDAO {
    boolean setOrders(Orders orders) throws SQLException, ClassNotFoundException;
}
