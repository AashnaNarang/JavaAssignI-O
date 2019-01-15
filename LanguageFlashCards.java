/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractflashcards;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Aashna Narang
 */
public class LanguageFlashCards extends AbstractFlashCards {

    //Instance variable and static variable for a comma
    private static final String COMMA_DELIMITER = ",";
    private String filename;

    /**
     * 1 argument constructor that initializes the instance variable. Creates a
     * fileReader and buffer to read through file. Each item read in file is
     * added to the the flashCard hash map.
     *
     * @param filename is the name of the file that will be accessed
     * @throws IOException handles failures of input/output operations
     */
    public LanguageFlashCards(String filename) throws IOException, FileNotFoundException {

        this.filename = filename;

        try {
            FileReader reader = new FileReader(this.filename);
            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine();  //this will skip first line
            while ((line = buffer.readLine()) != null) {
                String columns[] = line.split(COMMA_DELIMITER);
                super.addCard(columns[0], columns[1]);
            }
        } catch (FileNotFoundException e2) {
            System.out.println("Trouble reading from file");
        } catch (IOException e1) {
        }

    }
}
