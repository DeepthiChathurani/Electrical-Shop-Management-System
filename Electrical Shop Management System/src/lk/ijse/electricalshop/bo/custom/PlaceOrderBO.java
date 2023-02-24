package lk.ijse.electricalshop.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.bo.SuperBO;
import lk.ijse.electricalshop.dto.Orders;
import lk.ijse.electricalshop.view.tm.PlaceOrderTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO extends SuperBO {
   boolean placeOrder(Orders orders, ObservableList<PlaceOrderTm> list) throws SQLException;
   ResultSet laad(String id) throws SQLException, ClassNotFoundException;
   ArrayList<String> loadItemCode() throws SQLException, ClassNotFoundException;
}
