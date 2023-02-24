package lk.ijse.electricalshop.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.bo.custom.SupplierPaymentBO;
import lk.ijse.electricalshop.dao.DAOFactory;
import lk.ijse.electricalshop.dao.custom.ItemDAO;
import lk.ijse.electricalshop.db.DBConnection;
import lk.ijse.electricalshop.model.PaymentModel;
import lk.ijse.electricalshop.model.SupplierDetailModel;
import lk.ijse.electricalshop.dto.Payment;
import lk.ijse.electricalshop.view.tm.PaymentTm;

import java.sql.Connection;
import java.sql.SQLException;

public class SupplierPaymentBOImpl implements SupplierPaymentBO {
    public boolean payment(Payment payment, ObservableList<PaymentTm> paymentList) throws SQLException {
        ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            if (PaymentModel.setPayment(payment)) {
                if (SupplierDetailModel.setToPayment(payment, paymentList)) {
                    if (itemDAO.items(paymentList)) {
                        connection.commit();
                        return true;
                    } else {
                        connection.rollback();
                    }
                } else {
                    connection.rollback();
                }

            } else {
                connection.rollback();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }
        return false;

    }
}
