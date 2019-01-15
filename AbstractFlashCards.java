/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractflashcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Aashna Narang
 */
public abstract class AbstractFlashCards {

    private HashMap<String, String> flashCards;
    private ArrayList<String> unansweredCards;
    private int score;
    private Scanner scanner;
    private Random random;

    /**
     * Default constructor that initializes all of the variables for any class
     * that extends this abstract class. All variables are empty/set to 0
     */
    public AbstractFlashCards() {
        flashCards = new HashMap<String, String>();
        unansweredCards = new ArrayList();
        score = 0;
        scanner = new Scanner(System.in);
        random = new Random();
    }

    /**
     * Protected method that adds another flash card to the current stash of
     * questions. The question and answer are added to our hash map
     *
     * @param question A string of the question that will be added
     * @param answer A string of the answer to the question
     */
    protected void addCard(String question, String answer) {
        flashCards.put(question, answer);
        unansweredCards.add(question);
    }

    /**
     * Public method that resets the unanswered arrayList of cards and shuffles
     * them
     */
    public void reset() {
        score = 0;
        //Create new arraylist
        ArrayList<String> newCards = new ArrayList();
        //arraylist can't process at 0
        for (int i = 1; i < unansweredCards.size(); i++) {
            newCards.add(random.nextInt(i), unansweredCards.get(i));
        }
        //Add 0 element
        newCards.add(random.nextInt(unansweredCards.size()), unansweredCards.get(0));
        unansweredCards = newCards;

        /**
         * Other methods: Set<String> keys = flashCards.keySet(); String arr[] =
         * keys.toArray(new String[keys.size()]);
         *
         * for (int i = 0; i < arr.length; i++) { int swapWith = i +
         * random.nextInt(arr.length - i); String saved = arr[i]; arr[i] =
         * arr[swapWith]; arr[swapWith] = saved; }
         *
         * unansweredCards = new ArrayList(Arrays.asList(arr));
         *
         * Another method:
         *
         * for(int i = 0; i < unansweredCards.size(); i++) {
         * newUnansweredCards.add(i, unansweredCards.get(i)); }
         * Collections.shuffle(newUnansweredCards);
         *
         *
         */
    }

    /**
     * Public method that tells user if another question can be asked. I.e. if
     * the unansweredCards array list is empty now
     *
     * @return True if there are more questions to be asked, otherwise false
     */
    public boolean hasNext() {
        return unansweredCards.isEmpty() != true;
    }

    /**
     * This function prints out the unasweredCards arrayList at the beginning of
     * the game, then a question is asked and function receives input from
     * keyboard. Checks if answer is correct and increases score and removes
     * question from unanswered arrayList. If incorrect, question is kept in
     * array list, shuffles the deck of questions, and prints new arrayList.
     *
     * @return returns true if it's possible to ask another question
     */
    public boolean nextCard() {
        if (flashCards.size() == unansweredCards.size()) {
            System.out.println(unansweredCards.toString());
        }
        String question = unansweredCards.get(0);
        System.out.println(question);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase(flashCards.get(question))) {
            System.out.println("Correct!");
            score++;
            unansweredCards.remove(0);

        } else {
            unansweredCards.remove(0);
            unansweredCards.add(random.nextInt(unansweredCards.size()), question);
            System.out.println("Wrong");
            System.out.println(unansweredCards.toString());
        }

        return this.hasNext();

    }

    /**
     * Public getter method that gets the player's current score
     *
     * @return Current score of person playing the game
     */
    public int getScore() {
        return this.score;
    }

}
