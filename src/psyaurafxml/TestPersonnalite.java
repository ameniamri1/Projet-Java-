package psyaurafxml;

import java.util.List;
import java.util.Scanner;

public class TestPersonnalite {
    private List<Question> questions;
    private int score;

    public TestPersonnalite(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    // Afficher les questions et calculer le score
   public void commencerTest() {
    Scanner scanner = new Scanner(System.in);
    for (Question question : questions) {
        System.out.println("\n" + question.getTexte());
        List<String> options = question.getOptions();

        // Afficher les options
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        int reponseIndex;
        while (true) { // Boucle pour valider l'entrée
            System.out.print("Votre réponse (1-" + options.size() + ") : ");
            try {
                reponseIndex = scanner.nextInt() - 1; // Convertir en index (base 0)
                if (reponseIndex >= 0 && reponseIndex < options.size()) {
                    break; // Sortir de la boucle si valide
                } else {
                    System.out.println("Veuillez entrer un numéro valide !");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide, veuillez entrer un numéro.");
                scanner.next(); // Nettoyer le scanner
            }
        }

        // Ajouter le score basé sur le poids de la réponse
        score += question.getPoints().get(reponseIndex);
    }
}


    // Obtenir le score total
    public int getScore() {
        return score;
    }

    // Générer l'analyse de personnalité basée sur le score
    public String genererAnalyse() {
        if (score >= 9) {
            return "Vous avez une personnalité très " + getTypePersonnalite() + ". Vous êtes une personne qui a tendance à " + getComportement() + ".";
        } else if (score >= 4) {
            return "Votre personnalité est " + getTypePersonnalite() + ". Vous avez une approche " + getComportement() + ".";
        } else {
            return "Vous avez une personnalité plutôt " + getTypePersonnalite() + ". Vous êtes " + getComportement() + ".";
        }
    }

    // Identifier le type de personnalité en fonction du score
    private String getTypePersonnalite() {
        if (score >= 9) {
            return "très positive";
        } else if (score >= 6) {
            return "modérée";
        } else {
            return "négative";
        }
    }

    // Définir les comportements en fonction du type de personnalité
    private String getComportement() {
        if (score >= 9) {
            return "faire preuve de résilience et de confiance en soi.";
        } else if (score >= 6) {
            return "gérer les situations avec un certain équilibre.";
        } else if (score >= 4) {
            return "avoir tendance à voir les aspects négatifs et se concentrer sur les défis.";
        } else {
            return "être généralement déprimé et avoir des difficultés à faire face aux défis.";
        }
    }
}
