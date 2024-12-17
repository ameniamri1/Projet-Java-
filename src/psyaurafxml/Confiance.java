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
public class Confiance {
    private List<Question> questions;

    public Confiance() {
        
        questions = new ArrayList<>();
       questions.add(new Question("Vous êtes à l'aise de prendre la parole en public.", 
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Vous faites confiance à vos compétences pour réussir.", 
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Vous aimez relever des défis, même si vous ne savez pas si vous réussirez.", 
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Lorsque vous faites face à une situation inconnue, vous êtes calme et sûr(e) de vous.", 
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Les autres vous disent souvent que vous inspirez confiance.", 
                List.of("Oui", "Parfois", "Non"), List.of(1, 0, -1)));
        questions.add(new Question("Vous êtes capable de prendre des décisions importantes sans hésiter.", 
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
