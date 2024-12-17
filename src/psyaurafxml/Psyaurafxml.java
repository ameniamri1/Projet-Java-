/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package psyaurafxml;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author amria
 */
public class Psyaurafxml extends Application {
    
     @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/psyaurafxml/view/FXMLDocument.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);


            stage.setTitle("PsyAURA - AMRI Ameni & CHAKER Hela");

            stage.show();

            // Add a close request event
            stage.setOnCloseRequest(event -> System.out.println("Application is closing..."));

        } catch (IOException e) {
            System.err.println("Erreur : " + e.getMessage());
            e.printStackTrace(); // To get more details about the exception
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
    

