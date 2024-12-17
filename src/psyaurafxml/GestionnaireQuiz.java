/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psyaurafxml;

/**
 *
 * @author amria
 */
import java.util.List;

public class GestionnaireQuiz {
    private List<Question> questions;
    private int[] scoresOptimisme;
    private int[] scoresPessimisme;
    private int[] scoresConfiance;
    private int[] scoresDepression;

    public GestionnaireQuiz(List<Question> questions) {
        this.questions = questions;
        this.scoresOptimisme = new int[12]; // 12 questions pour chaque type de personnalité
        this.scoresPessimisme = new int[12];
        this.scoresConfiance = new int[12];
        this.scoresDepression = new int[12];
    }

    public void ajouterScore(int type, int indexOption, int points) {
        switch (type) {
            case 0 -> // Optimisme
                scoresOptimisme[indexOption] += points;
            case 1 -> // Pessimisme
                scoresPessimisme[indexOption] += points;
            case 2 -> // Confiance
                scoresConfiance[indexOption] += points;
            case 3 -> // Dépression
                scoresDepression[indexOption] += points;
        }
    }

    public int[] obtenirScoresOptimisme() {
        return scoresOptimisme;
    }

    public int[] obtenirScoresPessimisme() {
        return scoresPessimisme;
    }

    public int[] obtenirScoresConfiance() {
        return scoresConfiance;
    }

    public int[] obtenirScoresDepression() {
        return scoresDepression;
    }

    public String calculerResultats() {
        int totalOptimisme = 0;
        int totalPessimisme = 0;
        int totalConfiance = 0;
        int totalDepression = 0;

        for (int i = 0; i < 12; i++) {
            totalOptimisme += scoresOptimisme[i];
            totalPessimisme += scoresPessimisme[i];
            totalConfiance += scoresConfiance[i];
            totalDepression += scoresDepression[i];
        }

        int maxScore = Math.max(Math.max(totalOptimisme, totalPessimisme), 
                                Math.max(totalConfiance, totalDepression));
        
        if (maxScore == totalOptimisme) return "Optimisme";
        else if (maxScore == totalPessimisme) return "Pessimisme";
        else if (maxScore == totalConfiance) return "Confiance";
        else return "Dépression";
    }
}
