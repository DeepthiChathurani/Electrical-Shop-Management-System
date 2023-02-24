package lk.ijse.electricalshop.dao;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.view.tm.PaymentTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T,ID>  {
    boolean add(T object) throws SQLException, ClassNotFoundException;

    boolean update(T object) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadAll() throws SQLException, ClassNotFoundException;

    ResultSet load(ID id) throws SQLException, ClassNotFoundException;

     ResultSet search(ID searchText) throws SQLException, ClassNotFoundException;

    ResultSet getId() throws SQLException, ClassNotFoundException;




}
