package lk.ijse.electricalshop.model;

import lk.ijse.electricalshop.dao.custom.OrderDAO;
import lk.ijse.electricalshop.dao.custom.impl.OrderDAOImpl;
import lk.ijse.electricalshop.dto.Orders;

import java.sql.*;


public class OrdersModel {
    static OrderDAO orderDAO = new OrderDAOImpl();
    public void add(Orders order) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("INSERT INTO Orders VALUES(?,?,?)");
//        pstm.setString(1, order.getoId());
//        pstm.setString(2, String.valueOf(order.getDate()));
//        pstm.setString(3, order.getCusId());
//
//        return pstm.executeUpdate() > 0;

     orderDAO.add(new lk.ijse.electricalshop.entity.Orders(order.getoId(),order.getDate(),
             order.getCusId()));
    }


//    public static boolean save(Orders orders) throws SQLException, ClassNotFoundException {
//        String sql = "INSERT INTO Orders VALUES(?, ?, ?)";
//        return CrudUtil.execute(sql, orders.getoId(), orders.getDate(), orders.getCusId());
//    }

    public static ResultSet getIds() throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT oId FROM orders ORDER BY LENGTH (oId),oId");

        return  orderDAO.getId();
    }

    public static boolean setOrder(Orders orders) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("INSERT INTO orders VALUES (?,?,?)",
//                orders.getoId(),
//                orders.getDate(),
//                orders.getCusId()
//                );
        return orderDAO.setOrders(new lk.ijse.electricalshop.entity.Orders(orders.getoId(),orders.getDate(),
                orders.getCusId()));
    }

//    public static String getNextOrderId() throws SQLException, ClassNotFoundException {
//
//        ResultSet result = CrudUtil.execute("SELECT oId FROM orders ORDER BY oId DESC LIMIT 1");
//            if (result.next()) {
//                return generateNextOrderId(result.getString(1));
//            }
//            return generateNextOrderId(result.getString(null));
//        }
//
//    private static String generateNextOrderId(String currentOrderId) {
//        if (currentOrderId != null) {
//            String[] split = currentOrderId.split("D0");
//
//            System.out.println(split[1]);
//            int id = Integer.parseInt(split[1]);
//
//            id += 1;
//            return "D0" + id;
//        }
//        return "O001";
//    }

}
