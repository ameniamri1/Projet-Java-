/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psyaurafxml;

/**
 *
 * @author amria
 * @param <T>
 */
public class Resultat<T> {
    private T valeur;

    public Resultat(T valeur) {
        this.valeur = valeur;
    }

    public T obtenirValeur() {
        return valeur;
    }

    public void definirValeur(T valeur) {
        this.valeur = valeur;
    }
}
