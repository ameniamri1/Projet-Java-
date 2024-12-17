package psyaurafxml.controller;

import psyaurafxml.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnstart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnstart.setOnAction(event -> navigateToNextScreen());
    }

    public void navigateToNextScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/psyaurafxml/view/secondinterface.fxml"));  // Chemin relatif
            Scene nextScene = new Scene(loader.load());

            Stage stage = (Stage) btnstart.getScene().getWindow();
            stage.setScene(nextScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();  
        }
    }
}
