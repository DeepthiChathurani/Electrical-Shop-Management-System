package lk.ijse.electricalshop.model;

import lk.ijse.electricalshop.dao.custom.PaymentDAO;
import lk.ijse.electricalshop.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.electricalshop.dto.*;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PaymentModel {
    static PaymentDAO paymentDAO = new PaymentDAOImpl();

    public boolean add(Payment payment) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("INSERT INTO payment VALUES(?,?,?)");
//        pstm.setString(1, payment.getPId());
//        pstm.setString(2, String.valueOf(payment.getDate()));
//        pstm.setString(3, payment.getSupId());
//
//        return pstm.executeUpdate() > 0;

        return paymentDAO.add(new lk.ijse.electricalshop.entity.Payment(payment.getPId(),
                payment.getDate(),payment.getSupId()));
    }
    public static ResultSet getIds() throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT pId FROM payment ORDER BY LENGTH (pId),pId");
        return paymentDAO.getPaymentIds();
    }

    public static boolean setPayment(Payment payment) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("INSERT INTO payment VALUES (?,?,?)",
//                payment.getPId(),
//                payment.getDate(),
//                payment.getSupId()
//        );
        return paymentDAO.setToPayment(new lk.ijse.electricalshop.entity.Payment(payment.getPId(),
                payment.getDate(),payment.getSupId()));
    }



}
