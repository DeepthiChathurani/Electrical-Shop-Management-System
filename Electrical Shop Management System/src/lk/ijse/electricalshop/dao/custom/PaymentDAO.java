package lk.ijse.electricalshop.dao.custom;

import lk.ijse.electricalshop.dao.CrudDAO;
import lk.ijse.electricalshop.dao.SuperDAO;
import lk.ijse.electricalshop.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<Payment,String>, SuperDAO {
     ResultSet getPaymentIds() throws SQLException, ClassNotFoundException;

    boolean setToPayment(Payment payment) throws SQLException, ClassNotFoundException;
}
