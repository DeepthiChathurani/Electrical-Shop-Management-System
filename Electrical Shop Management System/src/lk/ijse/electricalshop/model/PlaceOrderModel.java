package lk.ijse.electricalshop.model;


import javafx.collections.ObservableList;
import lk.ijse.electricalshop.bo.custom.impl.PlaceOrderBOImpl;
import lk.ijse.electricalshop.dto.Orders;
import lk.ijse.electricalshop.view.tm.PlaceOrderTm;

import java.sql.SQLException;

public class PlaceOrderModel {

    public static boolean setOrder(Orders orders, ObservableList<PlaceOrderTm> list) throws SQLException {
        PlaceOrderBOImpl placeOrderBO = new PlaceOrderBOImpl();
        return placeOrderBO.placeOrder(orders, list);
    }
 }
