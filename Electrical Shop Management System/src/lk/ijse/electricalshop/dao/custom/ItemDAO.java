package lk.ijse.electricalshop.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.dao.CrudDAO;
import lk.ijse.electricalshop.dao.SuperDAO;
import lk.ijse.electricalshop.entity.Item;
import lk.ijse.electricalshop.view.tm.PaymentTm;
import lk.ijse.electricalshop.view.tm.PlaceOrderTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item,String>, SuperDAO {
    ResultSet laad(String id) throws SQLException, ClassNotFoundException;
    int updateItem(Item item) throws SQLException, ClassNotFoundException;
    ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException;

    boolean updateItems(ObservableList<PlaceOrderTm> list) throws SQLException, ClassNotFoundException;

    boolean items(ObservableList<PaymentTm> paymentList) throws SQLException, ClassNotFoundException;
}
