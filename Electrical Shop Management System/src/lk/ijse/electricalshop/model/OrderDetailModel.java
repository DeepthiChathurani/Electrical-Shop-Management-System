package lk.ijse.electricalshop.model;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.dao.custom.OrderDetailDAO;
import lk.ijse.electricalshop.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.electricalshop.dto.Orderdetail;
import lk.ijse.electricalshop.dto.Orders;
import lk.ijse.electricalshop.view.tm.PlaceOrderTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailModel {
    static OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();

    public static boolean saveOrderDetails(ArrayList<Orderdetail> orderDetails) throws SQLException, ClassNotFoundException {

        for (Orderdetail orderDetail : orderDetails) {
            if (!save(orderDetail)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(Orderdetail orderDetail) throws SQLException, ClassNotFoundException {
//        String sql = "INSERT INTO OrderDetail VALUES(?, ?, ?, ?)";
//        return CrudUtil.execute(sql, Orderdetail.getOrderId(), orderDetail.getItemId(), orderDetail.getQtyOnHand(),
//                orderDetail.getUnitPrice());

        return orderDetailDAO.add(new lk.ijse.electricalshop.entity.Orderdetail(orderDetail.getOrderId(),
                orderDetail.getItemId(),orderDetail.getQtyOnHand(),orderDetail.getUnitPrice()));
    }


    public static boolean setOrder(Orders orders, ObservableList<PlaceOrderTm> list) throws SQLException, ClassNotFoundException {
//        for (int i = 0; i < list.size(); i++) {
//
//            if (CrudUtil.execute("INSERT INTO orderdetail VALUES (?,?,?,?)",
//                    orders.getoId(),
//                    list.get(i).getItemId(),
//                    list.get(i).getQty(),
//                    list.get(i).getUnitPrice()
//            ))
//                {
//            } else {
//                return false;
//            }
//        }
//
        return orderDetailDAO.setOrders(orders, list);
   }
}
