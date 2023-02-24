package lk.ijse.electricalshop.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.electricalshop.dao.custom.SupplierDetailDAO;
import lk.ijse.electricalshop.dto.Payment;
import lk.ijse.electricalshop.entity.Supplierdetail;
import lk.ijse.electricalshop.util.CrudUtil;
import lk.ijse.electricalshop.view.tm.PaymentTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDetailDAOImpl implements SupplierDetailDAO {
    public boolean setPayment(Payment payment, ObservableList<PaymentTm> paymentList) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < paymentList.size(); i++) {
            if (CrudUtil.execute("INSERT INTO supplierdetail VALUES (?,?,?,?)",
                    paymentList.get(i).getItemId(),
                    payment.getSupId(),
                    paymentList.get(i).getQty(),
                    paymentList.get(i).getUnitPrice()
            )) {
            } else {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean add(Supplierdetail object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Supplierdetail object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet load(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet search(String searchText) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet getId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
