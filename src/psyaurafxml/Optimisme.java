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
public class Optimisme {
    private List<Question> questions;

    public Optimisme() {
        questions = new ArrayList<>();
       questions.add(new Question("Lorsque vous rencontrez un problème, vous êtes confiant(e) de pouvoir le résoudre.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Vous croyez que les choses finiront par s'améliorer, même après un échec.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Vous trouvez des opportunités même dans les situations difficiles.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Vous avez tendance à voir le verre à moitié plein.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Vous avez une attitude positive même lorsqu'il y a des obstacles.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Vous croyez qu'il y a toujours une lumière au bout du tunnel.",
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
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
