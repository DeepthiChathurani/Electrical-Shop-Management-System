package lk.ijse.electricalshop.dao.custom.impl;

import lk.ijse.electricalshop.dao.custom.PaymentDAO;
import lk.ijse.electricalshop.entity.Payment;
import lk.ijse.electricalshop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    public boolean add(Payment payment) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("INSERT INTO payment VALUES(?,?,?)");
//        pstm.setString(1, payment.getPId());
//        pstm.setString(2, String.valueOf(payment.getDate()));
//        pstm.setString(3, payment.getSupId());
//
//        return pstm.executeUpdate() > 0;
        return CrudUtil.execute("INSERT INTO payment VALUES(?,?,?)",payment.getPayId(),
                payment.getDate(),payment.getoId());
    }

    @Override
    public boolean update(Payment object) throws SQLException, ClassNotFoundException {
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

    public ResultSet getPaymentIds() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT pId FROM payment ORDER BY LENGTH (pId),pId");
    }
public boolean setToPayment(Payment payment) throws SQLException, ClassNotFoundException {
    return CrudUtil.execute("INSERT INTO payment VALUES (?,?,?)",
            payment.getPayId(),
            payment.getDate(),
            payment.getoId()
    );
}
}
