package lk.ijse.electricalshop.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.electricalshop.bo.BOFactory;
import lk.ijse.electricalshop.bo.custom.CustomerBO;
import lk.ijse.electricalshop.db.DBConnection;
import lk.ijse.electricalshop.dto.Customer;
import lk.ijse.electricalshop.util.Navigation;
import lk.ijse.electricalshop.util.Routes;
import lk.ijse.electricalshop.view.tm.CustomerTm;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CustomerFormController {
    public TextField txtcustName;
    public TextField txtcustAddress;
    public TextField txtcustEmail;
    public TextField txtcustContactNo;
    public TextField txtCustomerId;
    public AnchorPane acnCustomerForm;
    public TextField txtEmployeeId;
    public JFXTextField txtSearch;
    public TableView tblCustomer;
    public TableColumn<CustomerTm, String> colCusId;
    public TableColumn<CustomerTm, String> colName;
    public TableColumn<CustomerTm, String> colAddress;
    public TableColumn<CustomerTm, String> colEmail;
    public TableColumn<CustomerTm, String> colContactNum;
    public TableColumn<CustomerTm, String> colEId;
    //    private CustomerDAO customerDAO = new CustomerDAOImpl();
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    private String searchText = "";


    public void initialize() throws SQLException, ClassNotFoundException {
        colCusId.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContactNum.setCellValueFactory(new PropertyValueFactory<>("contact_num"));
        colEId.setCellValueFactory(new PropertyValueFactory<>("id"));

        txtSearch(searchText);
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchText = newValue;
            try {
                txtSearch(searchText);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    private void txtSearch(String text) throws SQLException, ClassNotFoundException {
        String searchText = "%" + text + "%";
        ObservableList<CustomerTm> list = FXCollections.observableArrayList();
        PreparedStatement pstm = DBConnection.getInstance().getConnection()
                .prepareStatement("SELECT * FROM Customer WHERE cusId LIKE ?|| name LIKE ?|| address LIKE ?");

        pstm.setString(1, searchText);
        pstm.setString(2, searchText);
        pstm.setString(3, searchText);

        ResultSet set = pstm.executeQuery();

        while (set.next()) {
            CustomerTm customerTm = new CustomerTm(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6));

            list.add(customerTm);
        }

        tblCustomer.setItems(list);

    }

    public void btnCustUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = txtCustomerId.getText();
        String name = txtcustName.getText();
        String address = txtcustAddress.getText();
        String email = txtcustEmail.getText();
        String contactNum = txtcustContactNo.getText();
        String eId = txtEmployeeId.getText();
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("UPDATE Customer SET name=?, address=?,email=?,contact_num=?,eId=?  where cusId=?");

        try {

//            pstm.setObject(1,txtcustName.getText());
//            pstm.setObject(2,txtcustAddress.getText());
//            pstm.setObject(3,txtcustEmail.getText());
//            pstm.setObject(4,txtcustContactNo.getText());
//            pstm.setObject(5,txtEmployeeId.getText());
//            pstm.setObject(6,txtCustomerId.getText());
//
//            int executeUpdate = pstm.executeUpdate();


            if (customerBO.updateCustomer(new Customer(id, name, address, email, contactNum, eId))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!.").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
            }
            txtSearch(searchText);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void btnCustDelete(ActionEvent actionEvent) {
        String id = txtCustomerId.getText();

        try {
//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("DELETE FROM Customer where cusId=?");
//        pstm.setObject(1,txtCustomerId.getText());
//
//        int executeUpdate = pstm.executeUpdate();

            if (customerBO.deleteCustomer(id)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!.").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
            }
            txtSearch(searchText);
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public void btnCustBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.LOGIN, acnCustomerForm);

    }

    public void btnCustAdd(ActionEvent actionEvent) throws RuntimeException, SQLException, ClassNotFoundException {

// id regex add
        Pattern idPattern = Pattern.compile("^(C0)([1-9]{1})([0-9]{0,})$");
        Matcher matcherId = idPattern.matcher(txtCustomerId.getText());
        boolean isMatcherId = matcherId.matches();
        if (isMatcherId) {
            System.out.println("Id is match");
        } else {
            txtCustomerId.setStyle("-fx-border-color: #B22222");
            System.out.println("Id isn't match");
        }
// name regex add
        Pattern namePattern = Pattern.compile("^([A-Z])([a-z]{0,})$");
        Matcher nameMatcher = namePattern.matcher(txtcustName.getText());
        boolean isNameMatcher = nameMatcher.matches();
        if (isNameMatcher) {
            System.out.println("Name is match");
        } else {
            txtcustName.setStyle("-fx-border-color: #B22222");
            System.out.println("Name isn't match");
        }
// address regex add
        Pattern addressPattern = Pattern.compile("^([A-Z])([a-z]{0,})$");
        Matcher addressMatcher = addressPattern.matcher(txtcustAddress.getText());
        boolean isAddressMatcher = addressMatcher.matches();
        if (isAddressMatcher) {
            System.out.println("Address is match");
        } else {
            txtcustAddress.setStyle("-fx-border-color: #B22222");
            System.out.println("Address isn't match");
        }
// email regex add
        Pattern emailPattern = Pattern.compile("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$");
        Matcher emailMatcher = emailPattern.matcher(txtcustEmail.getText());
        boolean isEmailMatcher = emailMatcher.matches();
        if (isEmailMatcher) {
            System.err.println(" matched email");
        } else {
            txtcustEmail.setStyle("-fx-border-color: #B22222");
            System.err.println("not matched email");
        }
// contact number regex add
//        Pattern contactPattern = Pattern.compile("^[1-9]{0,10}$");
//        Matcher contactMatcher = contactPattern.matcher(txtcustContactNo.getText());
//        boolean isContactMatcher = contactMatcher.matches();
//        if (isContactMatcher) {
//            System.err.println(" matched contact number");
//        } else {
//            txtcustContactNo.setStyle("-fx-border-color: #B22222");
//            System.err.println("not matched contact number");
//        }
// employee id regex add
        Pattern eIdPattern = Pattern.compile("^(E0)([1-9]{1})([0-9]{0,})$");
        Matcher matcherEId = eIdPattern.matcher(txtEmployeeId.getText());
        boolean isMatcherEId = matcherEId.matches();
        if (isMatcherEId) {
            System.out.println("EId is match");
        } else {
            txtEmployeeId.setStyle("-fx-border-color: #B22222");
            System.out.println("EId isn't match");
        }

        String id = txtCustomerId.getText();
        String name = txtcustName.getText();
        String address = txtcustAddress.getText();
        String email = txtcustEmail.getText();
        String contactNum = txtcustContactNo.getText();
        String eId = txtEmployeeId.getText();

        Customer customer = new Customer(id, name, address, email, contactNum, eId);
        customerBO.addCustomer(customer);
        boolean isAdded = true;
        //txtSearch(searchText);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();

        } else {
            new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
        }
        txtSearch(searchText);
    }


}

