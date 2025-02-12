package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class loginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    void login(ActionEvent event) {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if(email.equals("admin@gmail.com") && password.equals("admin123")) {
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Login Status");
            successAlert.setHeaderText("Login Successful");
            successAlert.showAndWait();
//
        }else{
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Login Status");
            errorAlert.setHeaderText("Login Failed");
            errorAlert.setContentText("Invalid email or password. Please try again.");
            errorAlert.showAndWait();
//
        }

    }
}
