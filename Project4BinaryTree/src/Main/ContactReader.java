package Main;

import AddressBook.Address;
import AddressBook.AddressBook;
import AddressBook.Contact;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * AddressBook Project 4 Qi Wang
 * @author John Koch
 * @Version 2.0
 */

public class ContactReader {
	/**
	 * File Scanning Variable
	 */
    private Scanner fileReader;
    /**
     * Path Value holds the location to the file for FileReader
     */
    private String path = "res/addressbook.txt.txt";

    /**
     * Default Constructor
     */
    protected ContactReader() {
    	/**
    	 * Trys to initialize a Scanner Object for A File
    	 */
        try {
            fileReader = new Scanner(new File(path));
        }catch(FileNotFoundException e){e.printStackTrace();}

    }

    /**
     * Method for grabbing the Information from the File
     * @return
     */
    public AddressBook get() {

    	/**
    	 * Creates new AddressBook Variable to be returned after the file contents have been read and processed
    	 */
    	AddressBook addresses = new AddressBook();
    	/**
    	 * Algorithm for reading the information from the text file into AddressBook
    	 */
        while(fileReader.hasNextLine())
        {
        	/**
        	 * Line in Targetted Path File to interperate its information
        	 */
            String line = fileReader.nextLine().strip();
            /**
             * Splits the line up by the delimiter 'tab'
             */
            String[] split = line.split("\t");
            /**
            //split is going to have extra empty tokens, since some content of addressbook.txt is Double Tabbed
             */
            ArrayList<String> tokens = new ArrayList<>();
            for (int i = 0; i< split.length; i++) { // Begin For Loop
                if(split[i].compareToIgnoreCase(" ") > 0) {//Check to see if it is a token
                    tokens.add(split[i]); //It is a token, add it to tokens
                }
            } //End For Loop
           Contact LineInfo = new Contact(      tokens.get(0) +" "+ tokens.get(1), // Name
                                               tokens.get(6),  // Phone Number
                                new Address(    tokens.get(2),  // Street
                                                tokens.get(3),  // City
                                                tokens.get(4), // State
                                                tokens.get(5)  //Zipcode
                                ));
           addresses.insert(LineInfo);
        }
        return addresses;
    }
}
