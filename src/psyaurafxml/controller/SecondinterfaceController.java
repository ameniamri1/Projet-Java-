package psyaurafxml.controller;

import psyaurafxml.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondinterfaceController implements Initializable {

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnUtilisateur;
    @FXML
    private Button retournerButton;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAdmin.setOnAction(event -> navigateToAdminMenu());
        btnUtilisateur.setOnAction(event -> navigateToUserTests());
        retournerButton.setOnAction(event -> handleRetour());

    }

    public void navigateToAdminMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/psyaurafxml/view/adminMenu.fxml"));
            Scene adminScene = new Scene(loader.load());

            Stage stage = (Stage) btnAdmin.getScene().getWindow();
            stage.setScene(adminScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToUserTests() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/psyaurafxml/view/userTests.fxml"));
            Scene userScene = new Scene(loader.load());

            Stage stage = (Stage) btnUtilisateur.getScene().getWindow();
            stage.setScene(userScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleRetour() {
        try {
            // Remplacez par le chemin de votre scène précédente
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/psyaurafxml/view/FXMLDocument.fxml"))); 
            Stage stage = (Stage) retournerButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
