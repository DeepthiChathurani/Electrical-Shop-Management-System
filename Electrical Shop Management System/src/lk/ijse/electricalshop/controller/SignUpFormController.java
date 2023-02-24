package lk.ijse.electricalshop.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.electricalshop.model.SingUpModel;
import lk.ijse.electricalshop.dto.User;
import lk.ijse.electricalshop.util.Navigation;
import lk.ijse.electricalshop.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpFormController {
    public TextField txtUsername;
    public TextField txtPassword;
    public AnchorPane ancSignUpForm;
    public TextField txtEId;
    public TextField txtRole;
    public TextField txtEmail;


    public void btnSingUp(ActionEvent actionEvent) throws RuntimeException, SQLException, ClassNotFoundException, IOException {
        String username =txtUsername.getText();
        String password= txtPassword.getText();
        String email = txtEmail.getText();
        String role=txtRole.getText();


        User user = new User(username,password,email,role);

        boolean isAdded = SingUpModel.save(user);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
            Navigation.navigation(Routes.LOGIN, ancSignUpForm);
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Happened!").show();
        }

    }

    public void btnLogin(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) ancSignUpForm.getScene().getWindow();
        Navigation.navigation(Routes.LOGIN, ancSignUpForm);

    }
}
