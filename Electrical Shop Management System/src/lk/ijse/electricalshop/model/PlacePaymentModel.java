package lk.ijse.electricalshop.model;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.bo.custom.impl.SupplierPaymentBOImpl;
import lk.ijse.electricalshop.dto.Payment;
import lk.ijse.electricalshop.view.tm.PaymentTm;

import java.sql.SQLException;

public class PlacePaymentModel {
   static SupplierPaymentBOImpl supplierPaymentBO = new SupplierPaymentBOImpl();
    public static boolean setPayment(Payment payment, ObservableList<PaymentTm> paymentList) throws SQLException {

//        ItemDAOImpl itemDAO = new ItemDAOImpl();
//
//        Connection connection = null;
//        try {
//            connection = DBConnection.getInstance().getConnection();
//            connection.setAutoCommit(false);
//            if (PaymentModel.setPayment(payment)) {
//                if (SupplierDetailModel.setToPayment(payment, paymentList)) {
//                    if (itemDAO.items(paymentList)) {
//                        connection.commit();
//                        return true;
//                    } else {
//                        connection.rollback();
//                    }
//                } else {
//                    connection.rollback();
//                }
//
//            } else {
//                connection.rollback();
//            }
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }finally {
//            connection.setAutoCommit(true);
//        }
//        return false;
        return supplierPaymentBO.payment(payment,paymentList);
    }
}
