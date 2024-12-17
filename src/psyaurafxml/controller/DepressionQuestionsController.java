/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package psyaurafxml.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
public class DepressionQuestionsController  {

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @FXML
    private Label questionLabel;

    @FXML
    private RadioButton option1;

    @FXML
    private RadioButton option2;

    @FXML
    private RadioButton option3;

    @FXML
    private Label scoreLabel;
    @FXML

    private Button descriptionButton;
    @FXML
    private Button retournerButton;
    
    @FXML

    private ToggleGroup optionsGroup;

    public DepressionQuestionsController (){
        // Initialisation des questions
        questions = new ArrayList<>();
        questions.add(new Question("Vous vous sentez souvent fatigué(e), même après une bonne nuit de sommeil.",
                List.of("Oui", "Parfois", "Non"), List.of(-1, 0, 1)));
        questions.add(new Question("Vous avez perdu de l'intérêt pour les activités que vous aimiez auparavant.",
                List.of("Oui", "Parfois", "Non"), List.of(-1, 0, 1)));
        questions.add(new Question("Vous avez des difficultés à vous lever le matin.",
                List.of("Oui", "Parfois", "Non"), List.of(-1, 0, 1)));
        questions.add(new Question("Vous vous sentez souvent inutile ou coupable.",
                List.of("Oui", "Parfois", "Non"), List.of(-1, 0, 1)));
        questions.add(new Question("Vous avez du mal à prendre des décisions, même les plus simples.",
                List.of("Oui", "Parfois", "Non"), List.of(-1, 0, 1)));
        questions.add(new Question("Vous vous sentez souvent triste sans raison apparente.",
                List.of("Oui", "Parfois", "Non"), List.of(-1, 0, 1)));
    }

    @FXML
    public void initialize() {
        optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);
        retournerButton.setOnAction(event -> handleRetour());
        descriptionButton.setOnAction(event -> handleFinishTest());



        afficherQuestion();
    }

    public void afficherQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question question = questions.get(currentQuestionIndex);
            questionLabel.setText(question.getTexte());
            option1.setText(question.getOptions().get(0));
            option2.setText(question.getOptions().get(1));
            option3.setText(question.getOptions().get(2));
            descriptionButton.setDisable(true);
        } else {
            questionLabel.setText("Quiz terminé !");
            option1.setDisable(true);
            option2.setDisable(true);
            option3.setDisable(true);
            descriptionButton.setDisable(false);

        }
    }

    @FXML
    public void handleNext() {
        if (optionsGroup.getSelectedToggle() == null) {
        showErrorDialog("Sélection requise", "Veuillez sélectionner une option avant de continuer.");
            return;
        }

        RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
        int selectedIndex = List.of(option1, option2, option3).indexOf(selectedOption);

        Question question = questions.get(currentQuestionIndex);
        score += question.getPoints().get(selectedIndex);

        scoreLabel.setText("Score : " + score);

        currentQuestionIndex++;
        optionsGroup.selectToggle(null);
        afficherQuestion();
    }
/*
    @FXML
public void handleFinishTest() {
    // Charger la vue de description du test
    try { 
       Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/psyaurafxml/view/DescriptionView.fxml"))); 
            Stage stage = (Stage) descriptionButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }

}*/
 private void showErrorDialog(String title, String content) {
    javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}
    @FXML
    public void handleRetour() {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/psyaurafxml/view/userTests.fxml"))); 
            Stage stage = (Stage) retournerButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showErrorDialog("Erreur de chargement", "Impossible de charger l'interface utilisateur des tests.");

        }
    }
     public int getScore() {
        return score;
    }
     
     public void terminerTest() {
    // Vérifier si toutes les questions ont été répondues
    if (currentQuestionIndex >= questions.size()) {
        // Déterminer le type de personnalité basé sur le score
        TypePersonnalite typePersonnalite;

        if (score <= -5) {
    typePersonnalite = new TypePersonnalite(
        "Dépression majeure",
        "Votre score élevé indique un risque sérieux de dépression. Il est important de consulter un professionnel pour un soutien approprié."
    );
} else if (score <= -3) {
    typePersonnalite = new TypePersonnalite(
        "Dépression modérée",
        "Vous présentez des symptômes modérés de dépression. Un suivi psychologique ou des changements dans votre quotidien peuvent être bénéfiques."
    );
} else if (score <= -1) {
    typePersonnalite = new TypePersonnalite(
        "Dépression légère",
        "Votre score indique une légère dépression, qui pourrait être liée à des événements passagers. Parler à un proche ou un thérapeute pourrait être utile."
    );
} else {
    typePersonnalite = new TypePersonnalite(
        "Pas de signes de dépression",
        "Vous semblez bien gérer vos émotions et ne présenter aucun signe notable de dépression."
    );
}


        try {
            // Charger la vue de description à partir du fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/psyaurafxml/view/DescriptionView.fxml"));
            Parent root = loader.load();

            // Récupérer le contrôleur de la vue de description
            DescriptionViewController controller = loader.getController();

            // Initialiser la vue de description avec le type de personnalité et le score obtenus
            controller.initialize(typePersonnalite, score);

            // Afficher la nouvelle vue (interface de description)
            Stage stage = (Stage) questionLabel.getScene().getWindow(); // Obtenir la fenêtre actuelle
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            // Gérer les erreurs de chargement de la vue
            e.printStackTrace();
        }
    } else {
        // Message pour demander de compléter toutes les questions avant de terminer
        scoreLabel.setText("Terminez toutes les questions avant de soumettre !");
    }
}
@FXML
public void handleFinishTest() {
    terminerTest();
}

     
     
     
     
     
}
