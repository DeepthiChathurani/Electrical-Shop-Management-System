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
import lk.ijse.electricalshop.bo.custom.ItemBO;
import lk.ijse.electricalshop.db.DBConnection;
import lk.ijse.electricalshop.dto.Item;
import lk.ijse.electricalshop.util.Navigation;
import lk.ijse.electricalshop.util.Routes;
import lk.ijse.electricalshop.view.tm.ItemTm;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemFormController {

    public static TextField txtDescription;
    public static TextField txtUnitprice;
    public static TextField txtQtyOnHand;
    public  AnchorPane ancItemForm;
    public static TextField txtItemId;
    public JFXTextField txtSearch;
    public TableView tblItem;
    public TableColumn<ItemTm,String> colItemId;
    public TableColumn<ItemTm,String> colDescription;
    public TableColumn<ItemTm,Double> colUnitPrice;
    public TableColumn<ItemTm,Integer> colQtyOnHand;
    public  String searchText= "";

//    static ItemDAO itemDAO = new ItemDAOImpl();

    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);

    public void initialize(){
        colItemId.setCellValueFactory(new PropertyValueFactory<>("ItemId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));

        txtSearch(searchText);
        txtSearch.textProperty().addListener((observable,oldValue,newValue) -> {
            searchText=newValue;
            txtSearch(searchText);
        });
    }

    private void txtSearch(String text) {
        String searchText = "%" + text + "%";
        try {
            ObservableList<ItemTm> list = FXCollections.observableArrayList();
            PreparedStatement pstm = DBConnection.getInstance().getConnection()
                    .prepareStatement("SELECT * FROM Item WHERE itemId LIKE ?");

            pstm.setString(1, searchText);

            ResultSet set = pstm.executeQuery();
            while (set.next()) {
                ItemTm itemTm = new ItemTm(
                        set.getString(1),
                        set.getString(2),
                        set.getDouble(3),
                        set.getInt(4));

                list.add(itemTm);
            }
            tblItem.setItems(list);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void btnDelete(ActionEvent actionEvent) {
        String code= txtItemId.getText();

        try{
            if (itemBO.deleteItem(code)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!.").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
            }
            txtSearch(searchText);
        } catch (Exception e) {

        }

    }


    public void btnBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.LOGIN, ancItemForm);
    }

    public void btnAdd(ActionEvent actionEvent) throws RuntimeException,SQLException, ClassNotFoundException {
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
        Matcher priceMatcher = pricePattern.matcher(txtUnitprice.getText());
        boolean isPriceMatcher = priceMatcher.matches();
        if(isPriceMatcher){
            System.err.println(" matched Price");
        }else {
            txtUnitprice.setStyle("-fx-border-color: #B22222");
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
        Double unitPrice  = Double.parseDouble(txtUnitprice.getText());
        Integer qtyOnHand= Integer.parseInt(txtQtyOnHand.getText());

        Item item = new Item(id,description,unitPrice,qtyOnHand);

        boolean isAdded = itemBO.addItem(item);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Item Added!").show();

        } else {
            new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
        }
        txtSearch(searchText);
    }

    public boolean btnUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        String id =txtItemId.getText();
//        String description= txtDescription.getText();
//        Double unitPrice  = Double.parseDouble(txtUnitprice.getText());
//        Integer qtyOnHand= Integer.parseInt(txtQtyOnHand.getText());

        PreparedStatement pstm = DBConnection.getInstance().getConnection()
                .prepareStatement("UPDATE Item SET discription=?, unitprice=?,qtyOnHand=? where itemId=?");

        try {

            pstm.setObject(1,txtDescription.getText());
            pstm.setObject(2,txtUnitprice.getText());
            pstm.setObject(3,txtQtyOnHand.getText());
            pstm.setObject(4,txtItemId.getText());

            int executeUpdate = pstm.executeUpdate();

            if (executeUpdate>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated!.").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
            }
            txtSearch(searchText);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;

    }
}
