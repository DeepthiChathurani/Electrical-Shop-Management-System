package lk.ijse.electricalshop.model;

import lk.ijse.electricalshop.db.DBConnection;
import lk.ijse.electricalshop.dto.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingUpModel {
    public static boolean save(User user) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection()
                .prepareStatement("INSERT INTO User VALUES(?,?,?,?)");
        pstm.setString(1, user.getUsername());
        pstm.setString(2, user.getPassword());
        pstm.setString(3, user.getEmail());
        pstm.setString(4, user.getRole());

        return pstm.executeUpdate() > 0;

    }

}
