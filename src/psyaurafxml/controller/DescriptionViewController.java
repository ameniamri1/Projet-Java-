/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package psyaurafxml.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import psyaurafxml.Question;
import psyaurafxml.TypePersonnalite;

/**
 * FXML Controller class
 *
 * @author amria
 */
public class DescriptionViewController  {//HEDHA CONTROLLER MTAA DEPRESSION, DOUB MATEKHDM L CONTROLLER B SHYH TW TEKHDMLK L INTERFACE
   @FXML
    private Button retournerButton;




    @FXML
    private Label typePersonnaliteLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label scoreLabel;

    // Méthode pour initialiser les valeurs dynamiquement
    public void initialize(TypePersonnalite typePersonnalite, int score) {
        typePersonnaliteLabel.setText(typePersonnalite.getType());
        descriptionLabel.setText(typePersonnalite.getDescription());
        scoreLabel.setText("Score obtenu : " + score);
    }


   


    public void handleRetour() {
        try {
            // Remplacez par le chemin de votre scène précédente
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/psyaurafxml/view/userTests.fxml"))); 
            Stage stage = (Stage) retournerButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}