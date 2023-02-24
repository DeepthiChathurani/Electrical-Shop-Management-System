package lk.ijse.electricalshop.model;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.dao.custom.SupplierDetailDAO;
import lk.ijse.electricalshop.dao.custom.impl.SupplierDetailDAOImpl;
import lk.ijse.electricalshop.dto.Payment;
import lk.ijse.electricalshop.view.tm.PaymentTm;

import java.sql.SQLException;

public class SupplierDetailModel {
    static SupplierDetailDAO supplierDetailDAO = new SupplierDetailDAOImpl();

//    private static boolean save(SupplierDetails supplierDetails) throws SQLException, ClassNotFoundException {
//        String sql = "INSERT INTO supplierdetail VALUES(?, ?, ?, ? )";
//        return CrudUtil.execute(sql, SupplierDetails.getItemId(), SupplierDetails.getSupId(), SupplierDetails.getQtyOnHand(),
//                SupplierDetails.getUnitPrice());
//    }


    public static boolean setToPayment(Payment payment, ObservableList<PaymentTm> paymentList) throws SQLException, ClassNotFoundException {
//        for (int i = 0; i < paymentList.size(); i++) {
//            if (CrudUtil.execute("INSERT INTO supplierdetail VALUES (?,?,?,?)",
//                    paymentList.get(i).getItemId(),
//                    payment.getSupId(),
//                    paymentList.get(i).getQty(),
//                    paymentList.get(i).getUnitPrice()
//            )) {
//            } else {
//                return false;
//            }
//        }
//
        return supplierDetailDAO.setPayment(payment,paymentList);
    }
}
