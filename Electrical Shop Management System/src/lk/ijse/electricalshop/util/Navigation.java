package lk.ijse.electricalshop.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
     private static AnchorPane ancLogin;
    public static void navigation(Routes route, AnchorPane pane) throws IOException {
        Navigation.ancLogin = pane;
        Navigation.ancLogin.getChildren().clear();
        Stage window = (Stage) Navigation.ancLogin.getScene().getWindow();

        switch (route) {
            case MAINFORM:
                window.setTitle("Main Form");
                initUI("MainForm.fxml");
                break;

            case LOGIN:
                window.setTitle("Login Form");
                initUI("Login.fxml");
                break;
            case SIGNUP:
                window.setTitle("Sing Up Form");
                initUI("SignUpForm.fxml");
                break;
            case ADMIN:
                window.setTitle("Admin Login Form");
                initUI("AdminLogin.fxml");
                break;
            case SUPPLIERUPDATE:
                window.setTitle("Supplier Update Form");
                initUI("SupplierUpdate.fxml");
                break;
            case REPORT:
                window.setTitle("Report Form");
                initUI("Report.fxml");
                break;
            case EMPLOYEE:
                window.setTitle("Employee Manage Form");
                initUI("Login.fxml");
                break;
            case CUSTOMER:
                window.setTitle("Customer Manage Form");
                initUI("CustomerForm.fxml");
                break;
            case ORDER:
                window.setTitle("PlaceOrder Form");
                initUI("PlaceOrderForm.fxml");
                break;
            case ITEM:
                window.setTitle("Item Manage Form");
                initUI("ItemForm.fxml");
                break;
            case SUPPLIERS:
                window.setTitle("Supplier Manage Form");
                initUI("SupplierForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.ancLogin.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/electricalshop/view/" + location)));
    }
}
