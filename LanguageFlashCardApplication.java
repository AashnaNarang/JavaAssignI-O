/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractflashcards;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aashna Narang
 */
public class LanguageFlashCardApplication {

    /**
     * Main function that goes through each card, prints current score and asks
     * if player wants to continue. If game was stopped before all questions
     * were successfully answered, current score is printed
     *
     * @param args not used
     * @throws IOException handles failures of input/output operations
     */
    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        String keepGoing = "Y";
        System.out.println("What is the filename containing your flashcards? Exact Letters!");
        String input = scan.nextLine();
        LanguageFlashCards cards = new LanguageFlashCards(input);
        
        //shuffle through cards
        cards.reset();
        //Going through cards
        while (cards.hasNext() && keepGoing.equalsIgnoreCase("Y")) {
            cards.nextCard();
            System.out.println("Current score: " + cards.getScore());
            System.out.println("Next?(Y or N)");
            keepGoing = scan.nextLine();
        }
        //end of game message
        if (cards.hasNext() == false) {
            System.out.println("You got them all! Good Job!");
        } else {
            System.out.println("You've got a score of " + cards.getScore() + " so far");
        }
        
        

    }

}
