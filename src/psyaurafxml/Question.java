package psyaurafxml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {

    private String question; // Texte de la question
    private List<String> options; // Liste des options de réponse
    private List<Integer> points; // Liste des points associés aux options

    // Constructeur
    public Question(String question, List<String> options, List<Integer> points) {
        this.question = question;
        this.options = new ArrayList<>(options);
        this.points = new ArrayList<>(points);
    }

    // Getter pour le texte de la question
    public String getTexte() {
        return question;
    }

    // Setter pour mettre à jour le texte de la question
    public void setTexte(String question) {
        this.question = question;
    }

    // Getter pour les options (liste non modifiable)
    public List<String> getOptions() {
        return Collections.unmodifiableList(options);
    }

    // Getter pour les points (liste non modifiable)
    public List<Integer> getPoints() {
        return Collections.unmodifiableList(points);
    }

    // Méthode pour définir ou mettre à jour les options et les points
    public void definirOptions(List<String> nouvellesOptions, List<Integer> nouveauxPoints) {
        if (nouvellesOptions.size() != nouveauxPoints.size()) {
            throw new IllegalArgumentException("Le nombre d'options doit correspondre au nombre de points.");
        }
        this.options = new ArrayList<>(nouvellesOptions);
        this.points = new ArrayList<>(nouveauxPoints);
    }

    // Méthode pour évaluer une réponse (retourne les points de l'option choisie)
    public int evaluerReponse(int indexOption) {
        if (indexOption < 0 || indexOption >= options.size()) {
            throw new IllegalArgumentException("Index de réponse invalide.");
        }
        return points.get(indexOption);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question: ").append(question).append("\nOptions:\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append(i + 1).append(". ").append(options.get(i))
              .append(" (Points: ").append(points.get(i)).append(")\n");
        }
        return sb.toString();
    }
}
