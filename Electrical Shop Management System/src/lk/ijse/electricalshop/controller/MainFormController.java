package lk.ijse.electricalshop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.electricalshop.db.DBConnection;
import lk.ijse.electricalshop.util.Navigation;
import lk.ijse.electricalshop.util.Routes;

import java.io.IOException;
import java.sql.*;

public class MainFormController {
    public TextField txtUsername;
    public TextField txtPassword;
    public AnchorPane ancMainForm;
    public Label lblLoginMessage;
    private Stage primaryStage;


    public void btnLogin(ActionEvent actionEvent) throws IOException {
       // Navigation.navigation(Routes.LOGIN, ancMainForm);
        if(txtUsername.getText().isEmpty() == false && txtPassword.getText().isEmpty() == false){
            lblLoginMessage.setText("You Try to login!");
       if(txtUsername.getText().equals("Chandimal")&&txtPassword.getText().equals("1110")){
             Navigation.navigation(Routes.ADMIN, ancMainForm);
        }else if(txtUsername.getText().equals("Dulari")&&txtPassword.getText().equals("1234")){
           Navigation.navigation(Routes.LOGIN, ancMainForm);
       }else if(txtUsername.getText().equals("Gumawardhana")&&txtPassword.getText().equals("5678")){
           Navigation.navigation(Routes.LOGIN, ancMainForm);
       }else{
           lblLoginMessage.setText("Invalid Login, Please try again!");
       }

        }else{
            lblLoginMessage.setText("Please enter username & password!");
        }

    }

    public void btnRegistration(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.SIGNUP, ancMainForm);

    }
}
