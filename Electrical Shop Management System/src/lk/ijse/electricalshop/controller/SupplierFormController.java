package lk.ijse.electricalshop.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.electricalshop.bo.BOFactory;
import lk.ijse.electricalshop.bo.custom.ItemBO;
import lk.ijse.electricalshop.model.*;
import lk.ijse.electricalshop.dto.Payment;
import lk.ijse.electricalshop.util.Navigation;
import lk.ijse.electricalshop.util.Routes;
import lk.ijse.electricalshop.view.tm.PaymentTm;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SupplierFormController implements Initializable {

    public TextField txtUnitPrice;
    public TextField txtQty;
    public TextField txtItemId;
    public TextField txtContactNo;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSupplierId;

    public AnchorPane pane;
    public TableView tblSupplierDetails;
    public TableColumn colDescription;
    public TableColumn colQtyOnHand;
    public TableColumn colUnitPrice;
    public TableColumn colTotal;
    public TableColumn colDelete;
    public JFXComboBox cmbSupId;
    public JFXComboBox cmbItemId;
    public Label lblName;
    public Label lblDescription;
    public Label lblAddress;
    public Label lblContactNum;
    public Label lblUnitPrice;
    public Label lblQtyOnHand;
    public Label lblPaymentId;
    public Label lblDate;
    public TableColumn colItemId;
    public Label lblTotal;

    //private ItemDAO itemDAO = new ItemDAOImpl();

       ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);

    private final ObservableList<PaymentTm> paymentList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colItemId.setCellValueFactory(new PropertyValueFactory("itemId"));
        colDescription.setCellValueFactory(new PropertyValueFactory("description"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        colDelete.setCellValueFactory(new PropertyValueFactory("btnDelete"));

        tblSupplierDetails.setItems(paymentList);
        lblPaymentId.setText(nextId());
        loadOrderDate();
        loadSupplierIds();
        loadItemCodes();
        setFinalTotal();


    }

    public void btnAdd(ActionEvent actionEvent) {
        Button button = new Button();
        button.setText("Delete");

        PaymentTm paymentTm = new PaymentTm(
                String.valueOf(cmbItemId.getValue()),
                lblDescription.getText(),
                Integer.parseInt(txtQty.getText()),
                Double.parseDouble(lblUnitPrice.getText()),
                Double.parseDouble(lblUnitPrice.getText()) * Double.valueOf(txtQty.getText()),
                button
        );
        paymentList.add(paymentTm);
        tblSupplierDetails.refresh();
        clearField();
        cmbItemId.getSelectionModel().clearSelection();
        cmbItemId.requestFocus();
        setFinalTotal();

        button.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Are your delete ", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult().equals(ButtonType.YES)) {
                paymentList.remove(paymentTm);
                clearField();
                setFinalTotal();
            }
        });

    }
    private void clearField() {
        txtQty.setText("");
    }

    private void setFinalTotal() {
        double setTotal = 0;

//        for (int i = 0; i < paymentList.size(); i++) {
//            setTotal += Double.parseDouble(String.valueOf(paymentList.size()));
//        }
//        lblTotal.setText(String.valueOf(setTotal));
        for (PaymentTm tm : paymentList
        ) {
            setTotal += tm.getTotal();
        }
        lblTotal.setText(String.valueOf(setTotal));

    }

    private void loadOrderDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    public void btnPayment(ActionEvent actionEvent) {
        try {
            if (PlacePaymentModel.setPayment(new Payment(
                            nextId(),
                            LocalDate.parse(lblDate.getText()),
                            String.valueOf(cmbSupId.getValue())),
                    paymentList)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Payment Successfully! ").show();

            }else {
                new Alert(Alert.AlertType.ERROR, "Payment has not been placed successfully").show();
            }
            tblSupplierDetails.getItems().clear();
            txtQty.clear();;
            setFinalTotal();
            paymentList.clear();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private String nextId() {
        String id = null;
        try {
            ResultSet set = PaymentModel.getIds();
            while (set.next()) {
                id = set.getString(1);
            }
            try {
                String[] O = id.split("P0");
                int nextId = Integer.parseInt(O[1]);
                nextId++;
                return "P0" + nextId;

            } catch (NullPointerException e) {
                return "P01";
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void cmbItemOnAction(ActionEvent actionEvent) {
        try {
            ResultSet set = itemBO.laad(String.valueOf(cmbItemId.getValue()));
            if (set.next()) {
                lblDescription.setText(set.getString(2));
                lblQtyOnHand.setText(set.getString(4));
                lblUnitPrice.setText(set.getString(3));

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        txtQty.requestFocus();
    }


    public void btnBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.LOGIN, pane);
    }

    public void cmbsupOnAction(ActionEvent actionEvent) {
        try {
            ResultSet set = SupplierModel.load(String.valueOf(cmbSupId.getValue()));
            if (set.next()) {
                lblName.setText(set.getString(2));
                lblAddress.setText(set.getString(3));
                lblContactNum.setText(set.getString(4));

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    private void loadItemCodes() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> itemList = itemBO.loadItemCodes();

            for (String code : itemList) {
                observableList.add(code);
            }
            cmbItemId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadSupplierIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = SupplierModel. loadSupplierIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbSupId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
