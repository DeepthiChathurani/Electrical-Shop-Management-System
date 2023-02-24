package lk.ijse.electricalshop.bo.custom;

import lk.ijse.electricalshop.bo.SuperBO;
import lk.ijse.electricalshop.dto.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    boolean addItem(Item item) throws SQLException, ClassNotFoundException;
    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
    int updateItem(Item item) throws SQLException, ClassNotFoundException;

    ResultSet laad(String valueOf) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException;
}
