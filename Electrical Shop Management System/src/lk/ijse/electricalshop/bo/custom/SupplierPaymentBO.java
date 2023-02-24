package lk.ijse.electricalshop.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.bo.SuperBO;
import lk.ijse.electricalshop.dto.Payment;
import lk.ijse.electricalshop.view.tm.PaymentTm;

import java.sql.SQLException;

public interface SupplierPaymentBO extends SuperBO {
    boolean payment(Payment payment, ObservableList<PaymentTm> paymentList) throws SQLException;
}
