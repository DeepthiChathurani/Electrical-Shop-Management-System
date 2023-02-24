package lk.ijse.electricalshop.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.dao.CrudDAO;
import lk.ijse.electricalshop.dao.SuperDAO;
import lk.ijse.electricalshop.dto.Payment;
import lk.ijse.electricalshop.entity.Supplierdetail;
import lk.ijse.electricalshop.view.tm.PaymentTm;

import java.sql.SQLException;

public interface SupplierDetailDAO extends CrudDAO<Supplierdetail,String>, SuperDAO {
     boolean setPayment(Payment payment, ObservableList<PaymentTm> paymentList) throws SQLException, ClassNotFoundException;

}
