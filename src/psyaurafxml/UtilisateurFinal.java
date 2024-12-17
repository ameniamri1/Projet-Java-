/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psyaurafxml;

/**
 *
 * @author amria
 */
public class UtilisateurFinal extends Utilisateur {
    private GestionnaireQuiz gestionnaireQuiz;

    public UtilisateurFinal(int id, String nom, String email, GestionnaireQuiz gestionnaireQuiz) {
        super(id, nom, email);
        this.gestionnaireQuiz = gestionnaireQuiz;
    }

    public void demarrerTest() {
        System.out.println("Le test a commencé !");
    }

    public void repondreQuestion(int indexOptionChoisie) {
        System.out.println("Réponse sélectionnée : Option " + indexOptionChoisie);
    }

    public void questionSuivante() {
        System.out.println("Passage à la question suivante.");
    }

    public void afficherResultats() {
        System.out.println("Voici vos résultats !");
    }
}
