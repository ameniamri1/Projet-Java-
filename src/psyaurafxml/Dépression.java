/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psyaurafxml;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amria
 */
public class Dépression {
     private List<Question> questions;

    public Dépression() {
        
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

    public List<Question> getQuestions() {
        return questions;
    }
    public void ajouter(Question question) {
        questions.add(question);
    }

    public void modifier(int index, String texte) {
        questions.get(index).setTexte(texte);
    }

    public void supprimer(int index) {
        questions.remove(index);
    }
}
