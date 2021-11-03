package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.Message;


public class NewLoginController  implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button submitButton;
    @FXML
    public TextField newLogin;
    @FXML
    public TextField confirmLogin;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    @FXML
    void handleChangeCancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleChangeLogin(ActionEvent event) {
        ChangeListener<? super String> onChange = (observable, oldValue, newValue) -> {
            boolean fieldsEquals = this.newLogin.getText().equals(this.confirmLogin.getText());
            this.submitButton.setDisable(this.newLogin.getText().isEmpty() || this.confirmLogin.getText().isEmpty()|| !fieldsEquals);

        };
       newLogin.textProperty().addListener(onChange);
       confirmLogin.textProperty().addListener(onChange);
        String login = newLogin.getText();
        Stage stage = (Stage) submitButton.getScene().getWindow();
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            //alert.setTitle("successful login change");
            alert.setContentText(newLogin.getText()+" :Login is successfully changed");
            alert.showAndWait();
        }

    }

    protected void initializePopupFields(Object data) {
        // TODO Auto-generated method stub

    }
}
