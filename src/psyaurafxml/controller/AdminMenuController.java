/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package psyaurafxml.controller;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import psyaurafxml.Question;
import psyaurafxml.Optimisme;
import psyaurafxml.Pessimisme;
import psyaurafxml.Dépression;
import psyaurafxml.Confiance;


public class AdminMenuController implements Initializable {


    @FXML
    private ComboBox<String> typeTestComboBox;
    @FXML
    private ListView<Question> questionListView;
    @FXML
    private TextField questionField;
    @FXML
    private Button ajouterButton, modifierButton, supprimerButton,retournerButton;
   
   

    private Map<String, Object> testTypes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        testTypes = Map.of(
                "Optimisme", new Optimisme(),
                "Pessimisme", new Pessimisme(),
                "Dépression", new Dépression(),
                "Confiance", new Confiance()
                
        );
        retournerButton.setOnAction(event -> handleRetour());

        typeTestComboBox.getItems().addAll(testTypes.keySet());
        typeTestComboBox.setOnAction(event -> handleTypeTestSelection());

        ajouterButton.setOnAction(event -> handleAjouterQuestion());
        modifierButton.setOnAction(event -> handleModifierQuestion());
        supprimerButton.setOnAction(event -> handleSupprimerQuestion());
    }

    public void handleTypeTestSelection() {
        String typeSelected = typeTestComboBox.getValue();
        if (typeSelected != null) {
            afficherQuestions(typeSelected);
        }
    }

    public void afficherQuestions(String typeTest) {
        Object testInstance = testTypes.get(typeTest);
        if (testInstance instanceof Optimisme) {
            questionListView.getItems().setAll(((Optimisme) testInstance).getQuestions());
        } else if (testInstance instanceof Pessimisme) {
            questionListView.getItems().setAll(((Pessimisme) testInstance).getQuestions());
        } else if (testInstance instanceof Dépression) {
            questionListView.getItems().setAll(((Dépression) testInstance).getQuestions());
        } else if (testInstance instanceof Confiance) {
            questionListView.getItems().setAll(((Confiance) testInstance).getQuestions());
        }
    }

    public void handleAjouterQuestion() {
        String typeTest = typeTestComboBox.getValue();
        if (typeTest != null && !questionField.getText().isEmpty()) {
            Object testInstance = testTypes.get(typeTest);
            if (testInstance instanceof Optimisme) {
                ((Optimisme) testInstance).ajouter(new Question(questionField.getText(), List.of("Oui", "Non"), List.of(1, -1)));
            } else if (testInstance instanceof Pessimisme) {
                ((Pessimisme) testInstance).ajouter(new Question(questionField.getText(), List.of("Oui", "Non"), List.of(-1, 1)));
            } else if (testInstance instanceof Dépression) {
                ((Dépression) testInstance).ajouter(new Question(questionField.getText(), List.of("Oui", "Non"), List.of(-1, 1)));
            } else if (testInstance instanceof Confiance) {
                ((Confiance) testInstance).ajouter(new Question(questionField.getText(), List.of("Oui", "Non"), List.of(1, -1)));
            }
            afficherAlerte("Question ajoutée avec succès.");
            questionField.clear();
            afficherQuestions(typeTest);
        }
    }

    public void handleModifierQuestion() {
        Question selectedQuestion = questionListView.getSelectionModel().getSelectedItem();
        String typeTest = typeTestComboBox.getValue();
        if (selectedQuestion != null && typeTest != null) {
            String newQuestionText = questionField.getText();
            Object testInstance = testTypes.get(typeTest);
            if (testInstance instanceof Optimisme) {
                ((Optimisme) testInstance).modifier(questionListView.getSelectionModel().getSelectedIndex(), newQuestionText);
            } else if (testInstance instanceof Pessimisme) {
                ((Pessimisme) testInstance).modifier(questionListView.getSelectionModel().getSelectedIndex(), newQuestionText);
            } else if (testInstance instanceof Dépression) {
                ((Dépression) testInstance).modifier(questionListView.getSelectionModel().getSelectedIndex(), newQuestionText);
            } else if (testInstance instanceof Confiance) {
                ((Confiance) testInstance).modifier(questionListView.getSelectionModel().getSelectedIndex(), newQuestionText);
            }
            afficherAlerte("Question modifiée avec succès.");
            questionField.clear();
            afficherQuestions(typeTest);
        }
    }

    public void handleSupprimerQuestion() {
        Question selectedQuestion = questionListView.getSelectionModel().getSelectedItem();
        String typeTest = typeTestComboBox.getValue();
        if (selectedQuestion != null && typeTest != null) {
            Object testInstance = testTypes.get(typeTest);
            if (testInstance instanceof Optimisme) {
                ((Optimisme) testInstance).supprimer(questionListView.getSelectionModel().getSelectedIndex());
            } else if (testInstance instanceof Pessimisme) {
                ((Pessimisme) testInstance).supprimer(questionListView.getSelectionModel().getSelectedIndex());
            } else if (testInstance instanceof Dépression) {
                ((Dépression) testInstance).supprimer(questionListView.getSelectionModel().getSelectedIndex());
            } else if (testInstance instanceof Confiance) {
                ((Confiance) testInstance).supprimer(questionListView.getSelectionModel().getSelectedIndex());
            }
            afficherAlerte("Question supprimée avec succès.");
            afficherQuestions(typeTest);
        }
    }

    public void afficherAlerte(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
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


    