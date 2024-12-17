/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package psyaurafxml.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import psyaurafxml.Question;
import psyaurafxml.TypePersonnalite;

/**
 * FXML Controller class
 *
 * @author amria
 */
public class PessimismeQuestionsController   {

  

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

    private ToggleGroup optionsGroup; // Création du groupe pour les RadioButtons

    public PessimismeQuestionsController() {
        questions=new ArrayList<>();
        questions.add(new Question("Lorsque quelque chose de bien m'arrive, je pense que cela durera longtemps.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Dans des situations difficiles, je crois qu'une solution positive est possible.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Je pense que mes efforts peuvent m'aider à surmonter les échecs.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Même lorsque tout semble aller mal, je crois qu'une amélioration est possible.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Je me sens capable de faire face aux imprévus avec confiance.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Quand je commence un projet, je me concentre sur les possibilités de réussite plutôt que sur les risques d'échec.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));}

    @FXML
    public void initialize() {
        optionsGroup = new ToggleGroup(); // Initialisation du ToggleGroup
        option1.setToggleGroup(optionsGroup); // Assignation au groupe
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

        // Mettre à jour le score
        scoreLabel.setText("Score : " + score);

        // Passer à la question suivante
        currentQuestionIndex++;
        optionsGroup.selectToggle(null); // Décocher les options
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
}
*/
    
    
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
        "Pessimiste",
        "Votre pessimisme élevé vous pousse à éviter les risques, mais il peut également vous exposer à des états de stress chronique. Vous pourriez bénéficier de techniques de gestion du stress."
    );
} else if (score <= -3) {
    typePersonnalite = new TypePersonnalite(
        "Modérément pessimiste",
        "Votre perception pessimiste vous aide à anticiper les problèmes, mais il est important de ne pas négliger les opportunités positives."
    );
} else if (score <= 0) {
    typePersonnalite = new TypePersonnalite(
        "Legerement pessimiste",
        "Votre tendance au pessimisme est légère, ce qui peut vous rendre prudent tout en laissant place à des approches constructives."
    );
} else {
    typePersonnalite = new TypePersonnalite(
        "Pas de signes de pessimisme ",
        "Vous êtes très peu pessimiste, ce qui est une force, mais soyez attentif à ne pas ignorer complètement les éventuels dangers."
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
