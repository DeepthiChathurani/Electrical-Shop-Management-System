package lk.ijse.electricalshop.model;

import lk.ijse.electricalshop.dao.custom.ItemDAO;
import lk.ijse.electricalshop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.electricalshop.dto.Item;

import java.sql.SQLException;

public class ItemModel {
    private static ItemDAO itemDAO = new ItemDAOImpl();
    public static boolean add(Item item) throws SQLException, ClassNotFoundException {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("INSERT INTO Item VALUES(?,?,?,?)");
//        pstm.setString(1, item.getItemId());
//        pstm.setString(2, item.getDescription());
//        pstm.setDouble(3, item.getUnitprice());
//        pstm.setInt(4, item.getQtyOnHand());
//
//
//        return pstm.executeUpdate() > 0;
        return itemDAO.add(new lk.ijse.electricalshop.entity.Item(item.getItemId(),item.getDescription(),
                item.getUnitprice(),item.getQtyOnHand()));
    }

//
//    public static boolean updateQty(ArrayList<Orderdetail> orderDetails) throws SQLException, ClassNotFoundException {
//        for (Orderdetail orderDetail : orderDetails) {
//            if (!updateQty(new Item(orderDetail.getItemId(), orderDetail.getDescription(),
//                    orderDetail.getUnitPrice(), orderDetail.getQtyOnHand()))) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static boolean updateQty(Item item) throws SQLException, ClassNotFoundException {
//        String sql = "UPDATE Item SET qtyOnHand = qtyOnHand - ? WHERE code = ?";
//        return CrudUtil.execute(sql, item.getQtyOnHand(), item.getItemId());
//    }
//
//    public static boolean updateQTY(ArrayList<SupplierDetails> supplierDetails) throws SQLException, ClassNotFoundException {
//        for (SupplierDetails supplierDetails1 : supplierDetails) {
//            if (!updateQTY(new Item(supplierDetails1.getItemId(), supplierDetails1.getDescription(),
//                    supplierDetails1.getUnitPrice(), supplierDetails1.getQtyOnHand()))) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static boolean updateQTY(Item item) throws SQLException, ClassNotFoundException {
//        String sql = "UPDATE Item SET qtyOnHand = qtyOnHand + ? WHERE code = ?";
//        return CrudUtil.execute(sql, item.getQtyOnHand(), item.getItemId());
//    }
//    public static Item search(String code) {
//        return null;
//    }

//    public static ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
//        String sql = "SELECT itemId FROM Item";
//        ResultSet result = CrudUtil.execute(sql);
//
//        ArrayList<String> codeList = new ArrayList<>();
//
//        while (result.next()) {
//            codeList.add(result.getString(1));
//        }
//        return codeList;
//    }

//    public static ResultSet laad(String id) throws SQLException, ClassNotFoundException {
//        return CrudUtil.execute("SELECT * FROM item WHERE itemId=?", id);
//    }

//    public static boolean updateItems(ObservableList<PlaceOrderTm> list) throws SQLException, ClassNotFoundException {
//        for (int i = 0; i < list.size(); i++) {
//            if (CrudUtil.execute("UPDATE item SET qtyOnHand=qtyOnHand-? WHERE itemId=?",
//                    list.get(i).getQty(),
//                    list.get(i).getItemId()
//            )) {
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
//    public static boolean items(ObservableList<PaymentTm> paymentList) throws SQLException, ClassNotFoundException {
//
//        for (int i = 1; i<paymentList .size(); i++) {
//            if (CrudUtil.execute("UPDATE item SET qtyOnHand=qtyOnHand+ ? WHERE itemId=?",
//
//                    paymentList.get(i).getQty(),
//                    paymentList.get(i).getItemId())) {
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
}
