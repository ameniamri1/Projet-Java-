package psyaurafxml;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Utilisateur implements Gestionnaire {
    private List<Question> questions;
    private Scanner scanner;

    // Constructeur
    public Admin(int id, String nom, String email) {
        super(id, nom, email);
        this.questions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Méthode pour ajouter une nouvelle question (dynamique)
    @Override
    public void ajouter() {
        System.out.println("Ajout d'une nouvelle question :");
        
        // Saisie du texte de la question
        System.out.print("Entrez le texte de la question : ");
        String texteQuestion = scanner.nextLine();

        // Saisie des options
        System.out.print("Combien d'options souhaitez-vous ajouter ? ");
        int nbOptions = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        List<String> options = new ArrayList<>();
        List<Integer> points = new ArrayList<>();

        for (int i = 0; i < nbOptions; i++) {
            System.out.print("Entrez l'option " + (i + 1) + " : ");
            String option = scanner.nextLine();
            options.add(option);

            System.out.print("Entrez les points pour l'option " + (i + 1) + " : ");
            int point = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante
            points.add(point);
        }

        // Création et ajout de la question
        Question nouvelleQuestion = new Question(texteQuestion, options, points);
        questions.add(nouvelleQuestion);

        System.out.println("La question a été ajoutée avec succès !");
    }

    // Méthode pour modifier une question (dynamique)
    @Override
    public void modifier() {
        if (questions.isEmpty()) {
            System.out.println("Aucune question à modifier.");
            return;
        }

        // Affichage des questions disponibles
        consulter();

        System.out.print("Entrez l'index de la question à modifier (1 à " + questions.size() + ") : ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consommer la ligne restante

        if (index >= 0 && index < questions.size()) {
            Question questionAModifier = questions.get(index);

            // Modification du texte de la question
            System.out.print("Entrez le nouveau texte de la question : ");
            String nouveauTexte = scanner.nextLine();
            questionAModifier.setTexte(nouveauTexte);

            // Modification des options
            System.out.print("Combien d'options souhaitez-vous modifier ? ");
            int nbOptions = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            List<String> nouvellesOptions = new ArrayList<>();
            List<Integer> nouveauxPoints = new ArrayList<>();

            for (int i = 0; i < nbOptions; i++) {
                System.out.print("Entrez la nouvelle option " + (i + 1) + " : ");
                String option = scanner.nextLine();
                nouvellesOptions.add(option);

                System.out.print("Entrez les nouveaux points pour l'option " + (i + 1) + " : ");
                int point = scanner.nextInt();
                scanner.nextLine(); // Consommer la ligne restante
                nouveauxPoints.add(point);
            }

            questionAModifier.definirOptions(nouvellesOptions, nouveauxPoints);

            System.out.println("La question a été modifiée avec succès !");
        } else {
            System.out.println("Index de question invalide.");
        }
    }

    // Méthode pour supprimer une question
    @Override
    public void supprimer() {
        if (questions.isEmpty()) {
            System.out.println("Aucune question à supprimer.");
            return;
        }

        // Affichage des questions disponibles
        consulter();

        System.out.print("Entrez l'index de la question à supprimer (1 à " + questions.size() + ") : ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consommer la ligne restante

        if (index >= 0 && index < questions.size()) {
            questions.remove(index);
            System.out.println("La question a été supprimée avec succès !");
        } else {
            System.out.println("Index de question invalide.");
        }
    }

    // Méthode pour consulter toutes les questions
    @Override
    public void consulter() {
        if (questions.isEmpty()) {
            System.out.println("Aucune question disponible.");
            return;
        }

        System.out.println("Liste des questions :");
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println((i + 1) + ". " + question.getTexte());
        }
    }

    // Getter pour récupérer la liste des questions (optionnel)
    public List<Question> getQuestions() {
        return questions;
    }
}
