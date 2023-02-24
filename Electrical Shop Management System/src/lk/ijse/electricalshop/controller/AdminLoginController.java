package lk.ijse.electricalshop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.electricalshop.bo.BOFactory;
import lk.ijse.electricalshop.bo.custom.ItemBO;
import lk.ijse.electricalshop.dto.Item;
import lk.ijse.electricalshop.util.Navigation;
import lk.ijse.electricalshop.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminLoginController {

    public AnchorPane ancAdminLogin;
    public JFXTextField txtItemId;
    public JFXTextField txtDescription;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtQtyOnHand;
    public JFXButton logOut;

    private ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);

    public void btnItemOnAction(ActionEvent actionEvent) {
    }

    public void btnSupplierOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.SUPPLIERUPDATE, ancAdminLogin);
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
        Stage stage =(Stage)logOut.getScene().getWindow();
        stage.close();
    }

    public void btnReportsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.REPORT, ancAdminLogin);
    }

    public boolean btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        // id regex add
        Pattern idPattern = Pattern.compile("^(I0)([1-9]{1})([0-9]{0,})$");
        Matcher matcherId = idPattern.matcher(txtItemId.getText());
        boolean isMatcherId = matcherId.matches();
        if(isMatcherId){
            System.out.println("Id is match");
        }else{
            txtItemId.setStyle("-fx-border-color: #B22222");
            System.out.println("Id isn't match");}
// description regex add
        Pattern descriptionPattern = Pattern.compile("^([A-Z])([a-z]{0,})$");
        Matcher descriptionMatcher = descriptionPattern.matcher(txtDescription.getText());
        boolean isDescriptionMatcher= descriptionMatcher.matches();
        if(isDescriptionMatcher){
            System.out.println("Name is match");
        }else{
            txtDescription.setStyle("-fx-border-color: #B22222");
            System.out.println("Name isn't match");}
// unit price regex add
        Pattern pricePattern = Pattern.compile("^[1-9]{2,}\\W[0]{2}$");
        Matcher priceMatcher = pricePattern.matcher(txtUnitPrice.getText());
        boolean isPriceMatcher = priceMatcher.matches();
        if(isPriceMatcher){
            System.err.println(" matched Price");
        }else {
            txtUnitPrice.setStyle("-fx-border-color: #B22222");
            System.err.println("not matched Price");}
// qty regex add
        Pattern qtyPattern = Pattern.compile("^[1-9]{2,3}$");
        Matcher qtyMatcher = qtyPattern.matcher(txtQtyOnHand.getText());
        boolean isQtyMatcher = qtyMatcher.matches();
        if(isQtyMatcher){
            System.err.println(" matched Qty");
        }else {
            txtQtyOnHand.setStyle("-fx-border-color: #B22222");
            System.err.println("not matched Qty");}

        String id =txtItemId.getText();
        String description= txtDescription.getText();
        Double unitPrice  = Double.parseDouble(txtUnitPrice.getText());
        Integer qtyOnHand= Integer.parseInt(txtQtyOnHand.getText());

//        PreparedStatement pstm = DBConnection.getInstance().getConnection()
//                .prepareStatement("UPDATE Item SET discription=?, unitprice=?,qtyOnHand=? where itemId=?");

        try {

//            pstm.setObject(1,txtDescription.getText());
//            pstm.setObject(2,txtUnitPrice.getText());
//            pstm.setObject(3,txtQtyOnHand.getText());
//            pstm.setObject(4,txtItemId.getText());
//
            int executeUpdate = itemBO.updateItem(new Item(id,description,unitPrice,qtyOnHand));

            if (executeUpdate>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated!.").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return false;

    }

}
