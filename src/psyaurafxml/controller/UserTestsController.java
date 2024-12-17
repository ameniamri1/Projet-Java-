package psyaurafxml.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserTestsController implements Initializable {

    @FXML
    private Button pessimisme;

    @FXML
    private Button optimisme;

    @FXML
    private Button depression;

    @FXML
    private Button confiance;
    @FXML
    private Button retournerButton;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        optimisme.setOnAction(event -> navigateToQuestions("optimismeQuestions.fxml"));
        pessimisme.setOnAction(event -> navigateToQuestions("pessimismeQuestions.fxml"));
        depression.setOnAction(event -> navigateToQuestions("depressionQuestions.fxml"));
        confiance.setOnAction(event -> navigateToQuestions("confianceQuestions.fxml"));
        retournerButton.setOnAction(event -> handleRetour());
        pessimisme.setFocusTraversable(false);
        optimisme.setFocusTraversable(false);
        depression.setFocusTraversable(false);
        confiance.setFocusTraversable(false);
        retournerButton.setFocusTraversable(false);

    }

    public void navigateToQuestions(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/psyaurafxml/view/" + fxmlFileName));
            Scene questionScene = new Scene(loader.load());

            // Get the stage from any button's scene
            Stage stage = (Stage) optimisme.getScene().getWindow();
            stage.setScene(questionScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void handleRetour() {
        try {
            // Remplacez par le chemin de votre scène précédente
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/psyaurafxml/view/secondinterface.fxml"))); 
            Stage stage = (Stage) retournerButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}