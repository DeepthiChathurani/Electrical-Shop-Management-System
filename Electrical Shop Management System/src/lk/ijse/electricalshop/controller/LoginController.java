package lk.ijse.electricalshop.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.electricalshop.bo.BOFactory;
import lk.ijse.electricalshop.bo.custom.EmployeeBO;
import lk.ijse.electricalshop.dto.Employee;
import lk.ijse.electricalshop.util.Navigation;
import lk.ijse.electricalshop.util.Routes;
import lk.ijse.electricalshop.view.tm.EmployeeTm;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {


    public AnchorPane ancEmployee;
    public TextField txtId;
    public TextField txtIName;
    public TextField txtAddress;
    public TextField txtContactNo;
    public AnchorPane ancLogin;
    public Button logoutButton;
    public JFXTextField txtSearch;
    public TableView tblEmployee;
    public TableColumn<EmployeeTm,String> coleId;
    public TableColumn<EmployeeTm,String> colName;
    public TableColumn<EmployeeTm,String> colAddress;
    public TableColumn<EmployeeTm,String> colContactNum;
    public  String searchText= "";

   // private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

     EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    public void initialize(){
        coleId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNum.setCellValueFactory(new PropertyValueFactory<>("contact_num"));

        txtSearch(searchText);
        txtSearch.textProperty().addListener((observable,oldValue,newValue) -> {
            searchText=newValue;
            txtSearch(searchText);
        });
    }

    public void btnEmployee(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.EMPLOYEE,ancLogin);
    }

    public void btnCustomer(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.CUSTOMER, ancLogin);

    }

    public void btnItem(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.ITEM, ancLogin);
    }

    public void btnSupplier(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.SUPPLIERS, ancLogin);
    }

    public void btnLogout(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage)logoutButton.getScene().getWindow();
        stage.close();
    }
    public void btnOrders(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.ORDER, ancLogin);

    }

    public void btnDelete(ActionEvent actionEvent) {
         String eId = txtId.getText();

        try {
//            PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                    .prepareStatement("DELETE FROM Employee where eId=?");
//            pstm.setObject(1,txtId.getText());
//
//            int executeUpdate = pstm.executeUpdate();

            if (employeeBO.deleteEmployee(eId)){
                new Alert(Alert.AlertType.CONFIRMATION,"Deleted!.").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
            }
            txtSearch(searchText);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void btnSearch(ActionEvent actionEvent) {
    }

    public void btnUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
/*        String id =txtId.getText();
        String name= txtIName.getText();
        String address  = txtAddress.getText();
        String contactNum=txtContactNo.getText();

        PreparedStatement pstm = DBConnection.getInstance().getConnection()
                .prepareStatement("UPDATE Employee SET name=?, address=?,contact_num=? where eId=?");

        try {

            pstm.setObject(1,txtIName.getText());
            pstm.setObject(2,txtAddress.getText());
            pstm.setObject(3,txtContactNo.getText());
            pstm.setObject(4,txtId.getText());


            int executeUpdate = pstm.executeUpdate();

            if (executeUpdate>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated!.").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
            }
            txtSearch(searchText);
        }catch (Exception e){
            System.out.println(e);
        }*/

    }

    public void btnAdd(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        String id =txtId.getText();
        String name= txtIName.getText();
        String address  = txtAddress.getText();
        String contactNum=txtContactNo.getText();


         Employee employee = new Employee(id,name,address,contactNum);
        boolean isAdded = employeeBO.addEmployee(employee);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Employee Added!").show();
            ;
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
        }

        txtSearch(searchText);
    }


    private void txtSearch(String text)  {
        String searchText = "%"+text+"%";
        try {
            ObservableList<EmployeeTm> list = FXCollections.observableArrayList();
//            PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                    .prepareStatement("SELECT * FROM Employee WHERE eId LIKE ?|| name LIKE ?|| address LIKE ?");
//
//            pstm.setString(1,searchText);
//            pstm.setString(2,searchText);
//            pstm.setString(3,searchText);

            ResultSet set = (ResultSet) employeeBO.searchEmployee(searchText);
            while (set.next()){
                EmployeeTm employeeTm = new EmployeeTm(
                set.getString(1),
                set.getString(2),
                set.getString(3),
                set.getString(4));

                list.add(employeeTm);
            }
     tblEmployee.setItems(list);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }

    }


}
