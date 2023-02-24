package lk.ijse.electricalshop.model;

import lk.ijse.electricalshop.dto.Employee;

import java.sql.SQLException;

public class EmployeeModel {

    public static void register(Employee employee) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("INSERT INTO Employee VALUES(?, ?, ?, ?)");
//        pstm.setString(1, employee.geteId());
//        pstm.setString(2, employee.getName());
//        pstm.setString(3, employee.getAddress());
//        pstm.setString(4, employee.getContact_num());
//
//        return pstm.executeUpdate() > 0;


    }

//    public static Employee search(String id) throws SQLException, ClassNotFoundException {
//        /*PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("SELECT  * FROM Customer WHERE id = ?");
//        pstm.setObject(1, id);
//
//        ResultSet result = pstm.executeQuery();*/
//        String sql = "SELECT  * FROM Customer WHERE id = ?";
//        ResultSet result = CrudUtil.execute(sql, id);
//
//        if (result.next()) {
//            return new Employee(
//                    result.getString(1),
//                    result.getString(2),
//                    result.getString(3),
//                    result.getString(4)
//            );
//        }
//        return new Employee();
//    }

//    public static ArrayList<String> loadEmployeeeIds() throws SQLException, ClassNotFoundException {
//        String sql = "SELECT id FROM Employee";
//        ResultSet result = CrudUtil.execute(sql);
//
//        ArrayList<String> idList = new ArrayList<>();
//
//        while (result.next()) {
//            idList.add(result.getString(1));
//        }
//        return idList;
//    }


    public static boolean add(Employee employee) {
        return true;
    }
}
