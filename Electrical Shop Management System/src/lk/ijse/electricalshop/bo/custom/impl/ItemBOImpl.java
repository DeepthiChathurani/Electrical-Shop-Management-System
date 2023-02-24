package lk.ijse.electricalshop.bo.custom.impl;

import lk.ijse.electricalshop.bo.custom.ItemBO;
import lk.ijse.electricalshop.dao.DAOFactory;
import lk.ijse.electricalshop.dao.custom.ItemDAO;
import lk.ijse.electricalshop.dto.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    static ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    public boolean addItem(Item item) throws SQLException, ClassNotFoundException {

        return itemDAO.add(new lk.ijse.electricalshop.entity.Item(item.getItemId(),item.getDescription(),
                item.getUnitprice(),item.getQtyOnHand()));
    }
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    public ResultSet laad(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.laad(id);
    }
    public int updateItem(Item item) throws SQLException, ClassNotFoundException {
        return itemDAO.updateItem(new lk.ijse.electricalshop.entity.Item(item.getItemId(),
                item.getDescription(),item.getUnitprice(),item.getQtyOnHand()));
    }

    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {

        return itemDAO.loadItemCodes();
    }
}
