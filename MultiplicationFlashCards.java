/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractflashcards;

/**
 * Extends Abstract Flash Cards class
 *
 * @author Aashna Narang
 */
public class MultiplicationFlashCards extends AbstractFlashCards {

    /**
     * One version of 1-arg constructor, takes one int and creates cards for
     * multiples of the int and numbers b/n 1-12 (inclusive)
     *
     * @param multipliers integer used to create 12 cards with multiple times a
     * number b/n 1-12
     */
    public MultiplicationFlashCards(int multipliers) {
        for (int i = 1; i <= 12; i++) {
            super.addCard(String.valueOf(multipliers) + "*" + String.valueOf(i), String.valueOf(i * multipliers));
        }
    }

    /**
     * Another version of 1 argument constructor, but instead takes in multiple
     * integers and creates a set of cards for each.
     *
     * @param multipliers an array of integers, create a set of cards of their
     * multiples for each
     */
    public MultiplicationFlashCards(int[] multipliers) {
        for (int j = 0; j < multipliers.length; j++) {
            for (int i = 1; i <= 12; i++) {
                super.addCard(String.valueOf(multipliers[j]) + "*" + String.valueOf(i), String.valueOf(i * multipliers[j]));
            }
        }

    }
}
