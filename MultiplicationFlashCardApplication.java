/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractflashcards;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author Aashna Narang
 */
public class MultiplicationFlashCardApplication {

    /**
     * Main method that asks user which multiples they would like to be tested
     * on. Main function that goes through each card, prints current score and
     * asks if player wants to continue. If game was stopped before all
     * questions were successfully answered, current score is printed
     *
     * @param args not used
     */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String keepGoing = "Y";
        int multiples[];
        String input;
        System.out.println("What times tables would you like to test? (Between 1 and 12 inclusive, leave a space between each)");
        input = scan.nextLine();
        String multiplesStr[] = input.split(" ");
        multiples = new int[multiplesStr.length];
        for (int i = 0; i < multiplesStr.length; i++) {
            multiples[i] = parseInt(multiplesStr[i]);
        }
        MultiplicationFlashCards cards = new MultiplicationFlashCards(multiples);
        //shuffles cards
        cards.reset();
        //go through cards
        do {
            cards.nextCard();
            if (!cards.hasNext()) {
                System.out.println("Congrats! YOu got them all");
                System.exit(0);
            }
            System.out.println("Current score: " + cards.getScore());
            System.out.println("Next?(Y or N)");
            keepGoing = scan.nextLine();
        } while (keepGoing.equalsIgnoreCase("Y"));
        //output score ig user exited game
        if (keepGoing.equalsIgnoreCase("N")) {
            System.out.println("You've got a score of " + cards.getScore() + " so far");
        }

    }
}
