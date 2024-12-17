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
public class Pessimisme {
        private ArrayList<Question> questions;

        public Pessimisme() {
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
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
    }

    public ArrayList<Question> getQuestions() {
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
