package lk.ijse.electricalshop.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.electricalshop.db.DBConnection;
import lk.ijse.electricalshop.util.Navigation;
import lk.ijse.electricalshop.util.Routes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupplierUpdateController {
    public JFXTextField txtSupId;
    public JFXTextField txtSupName;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNum;
    public JFXTextField txtItemId;
    public AnchorPane ancSupplierUpdate;

    public void btnUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


// id regex add
        Pattern idPattern = Pattern.compile("^(S0)([1-9]{1})([0-9]{0,})$");
        Matcher matcherId = idPattern.matcher(txtSupId.getText());
        boolean isMatcherId = matcherId.matches();
        if(isMatcherId){
            System.out.println("Id is match");
        }else{
            txtSupId.setStyle("-fx-border-color: #B22222");
            System.out.println("Id isn't match");}
// name regex add
        Pattern namePattern = Pattern.compile("^([A-Z])([a-z]{0,})$");
        Matcher nameMatcher = namePattern.matcher(txtSupName.getText());
        boolean isNameMatcher= nameMatcher.matches();
        if(isNameMatcher){
            System.out.println("Name is match");
        }else{
            txtSupName.setStyle("-fx-border-color: #B22222");
            System.out.println("Name isn't match");}
// address regex add
        Pattern addressPattern = Pattern.compile("^([A-Z])([a-z]{0,})$");
        Matcher addressMatcher = addressPattern.matcher(txtAddress.getText());
        boolean isAddressMatcher= addressMatcher.matches();
        if(isAddressMatcher){
            System.out.println("Address is match");
        }else{
            txtAddress.setStyle("-fx-border-color: #B22222");
            System.out.println("Address isn't match");}

// contact number regex add
        Pattern contactPattern = Pattern.compile("^[1-9]{0,10}$");
        Matcher contactMatcher = contactPattern.matcher(txtContactNum.getText());
        boolean isContactMatcher = contactMatcher.matches();
        if(isContactMatcher){
            System.err.println(" matched contact number");
        }else {
            txtContactNum.setStyle("-fx-border-color: #B22222");
            System.err.println("not matched contact number");}
// employee id regex add
        Pattern eIdPattern = Pattern.compile("^(I0)([1-9]{1})([0-9]{0,})$");
        Matcher matcherEId = eIdPattern.matcher(txtItemId.getText());
        boolean isMatcherEId = matcherEId.matches();
        if(isMatcherEId){
            System.out.println("EId is match");
        }else{
            txtItemId.setStyle("-fx-border-color: #B22222");
            System.out.println("EId isn't match");}

//        String id =txtSupId.getText();
//        String name= txtSupName.getText();
//        String address  = txtAddress.getText();
//        String contactNum= txtContactNum.getText();
//        String itemId=txtItemId.getText();

        PreparedStatement pstm = DBConnection.getInstance().getConnection()
                .prepareStatement("UPDATE Supplier SET supname=?,supaddress=?,contact_num=?,itemId=? where supId=?");

        try {
            pstm.setObject(1,txtSupName.getText());
            pstm.setObject(2,txtAddress.getText());
            pstm.setObject(3,txtContactNum.getText());
            pstm.setObject(4,txtItemId.getText());
            pstm.setObject(5,txtSupId.getText());

            int executeUpdate = pstm.executeUpdate();

            if (executeUpdate>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated!.").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void btnBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.ADMIN, ancSupplierUpdate);
    }
}
