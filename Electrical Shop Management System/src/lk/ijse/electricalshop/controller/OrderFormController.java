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
import lk.ijse.electricalshop.bo.custom.PlaceOrderBO;
import lk.ijse.electricalshop.model.CustomerModel;
import lk.ijse.electricalshop.model.OrdersModel;
import lk.ijse.electricalshop.model.PlaceOrderModel;
import lk.ijse.electricalshop.dto.Orders;
import lk.ijse.electricalshop.util.Navigation;
import lk.ijse.electricalshop.util.Routes;
import lk.ijse.electricalshop.view.tm.PlaceOrderTm;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {
    private final ObservableList<PlaceOrderTm> list = FXCollections.observableArrayList();
    public TextField txtPaymentId;
    public TextField txtOrderId;
    public TextField txtDate;
    public TextField txtTime;
    public TableView <PlaceOrderTm>tblOrderDetail;
    public TableColumn colOrderId;
    public TableColumn colItemId;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public TableColumn colTotal;
    public TableColumn colFinalTotal;
    public Label lblOrderId;
    public Label lblDate;
    public Label lblDescription;
    public Label lblUnitPrice;
    public JFXComboBox cmbItemCode;
    public JFXComboBox cmbCusCode;
    public TextField txtQtyType;
    public TableColumn colAction;
    public Label lblTotal;
    public Label lblName;
    public Label lblAddress;
    public AnchorPane ancPlaceOrderForm;
    public Label lblQtyOnHand;


    //private ItemDAO itemDAO = new ItemDAOImpl();
       PlaceOrderBO placeOrderBO = (PlaceOrderBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PLACEORDER);
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colItemId.setCellValueFactory(new PropertyValueFactory("itemId"));
        colDescription.setCellValueFactory(new PropertyValueFactory("description"));
        colQty.setCellValueFactory(new PropertyValueFactory("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        colAction.setCellValueFactory(new PropertyValueFactory("btnDelete"));

        tblOrderDetail.setItems(list);
        lblOrderId.setText(nextId());
        loadOrderDate();
        loadCustomerIds();
        loadItemCodes();
        setFinalTotal();

    }


    public void btnAdd(ActionEvent actionEvent) {
        Button button = new Button();
        button.setText("Remove");

        PlaceOrderTm placeOrderTm = new PlaceOrderTm(
                String.valueOf(cmbItemCode.getValue()),
                lblDescription.getText(),
                Integer.parseInt(txtQtyType.getText()),
                Double.parseDouble(lblUnitPrice.getText()),
                Double.parseDouble(lblUnitPrice.getText()) * Double.valueOf(txtQtyType.getText()),
                button
        );
        list.add(placeOrderTm);
        tblOrderDetail.refresh();
        clearField();
        cmbItemCode.getSelectionModel().clearSelection();
        cmbItemCode.requestFocus();
        setFinalTotal();

        button.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Are your delete ", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult().equals(ButtonType.YES)) {
                list.remove(placeOrderTm);
                clearField();
                setFinalTotal();
            }
        });


    }

    private void clearField() {
        txtQtyType.setText("");
    }

    public void btnBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.LOGIN, ancPlaceOrderForm);
    }

    public void btnPlaceOrder(ActionEvent actionEvent) {

        try {
            if (PlaceOrderModel.setOrder(new Orders(
                            nextId(),
                            LocalDate.parse(lblDate.getText()),
                            String.valueOf(cmbCusCode.getValue())),
                    list)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order Successfully! ").show();

            }else {
                new Alert(Alert.AlertType.ERROR, "Order has not been placed successfully").show();
            }
            tblOrderDetail.getItems().clear();
            txtQtyType.clear();;
            setFinalTotal();
            list.clear();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private String nextId() {
        String id = null;
        try {
            ResultSet set = OrdersModel.getIds();
            while (set.next()) {
                id = set.getString(1);
            }
            try {
                String[] O = id.split("O0");
                int nextId = Integer.parseInt(O[1]);
                nextId++;
                return "O0" + nextId;

            } catch (NullPointerException e) {
                return "O01";
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
//    private DefaultTableModel getTableModel() {
//        return (DefaultTableModel) tblOrderDetail.getSelectionModel().;
//    }
    private void setFinalTotal() {
        double setTotal = 0;

//        for (int i = 0; i < list.size(); i++) {
//            setTotal += list.size();
//
//        }
//       lblTotal.setText(String.valueOf(setTotal));
//        System.out.println(setTotal);
        for (PlaceOrderTm tm : list
        ) {
            setTotal += tm.getTotal();
        }
        lblTotal.setText(String.valueOf(setTotal));
    }

    private void loadOrderDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }


    public void cmbItemOnAction(ActionEvent actionEvent) {
        try {
            ResultSet set = placeOrderBO.laad(String.valueOf(cmbItemCode.getValue()));
            if (set.next()) {
                lblDescription.setText(set.getString(2));
                lblQtyOnHand.setText(set.getString(4));
                lblUnitPrice.setText(set.getString(3));

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        txtQtyType.requestFocus();
    }

    public void cmbCusOnAction(ActionEvent actionEvent) {
        try {
            ResultSet set =CustomerModel.load(String.valueOf(cmbCusCode.getValue()));
            if (set.next()) {
                lblName.setText(set.getString(2));
                lblAddress.setText(set.getString(3));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }


    private void loadItemCodes() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> itemList = placeOrderBO.loadItemCode();

            for (String code : itemList) {
                observableList.add(code);
            }
            cmbItemCode.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomerIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = CustomerModel.loadCustomerIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbCusCode.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
