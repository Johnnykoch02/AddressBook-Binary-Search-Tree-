package Main;

import AddressBook.*;
import BinaryTree.BinarySearchTree;
import BinaryTree.TreeNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * AddressBook Project 4 Qi Wang
 * @author John Koch
 * @Version 2.0
 */

public class Application extends JPanel {

    private ContactReader rdr;
    private AddressBook adb;
    private Scanner s;

    public Application() {
        init();
    }

    public void init() {
    	
        this.setLayout(new BorderLayout());
        s = new Scanner(System.in);
        rdr = new ContactReader();
        adb = rdr.get();

        run();
    }

    public void run() {
    	
    	System.out.println("Welcome to John Koch's Rendition of the AdressBook 2.0!");
    	System.out.println("(The 1.0 was a complete failure, IDK why, ask Steve Jobs \\.'-',/  )");
    	System.out.println("What Can it do you might Ask? Press ENTER and Find Out!");
    	s.nextLine();
        System.out.println("Using the Tree Iterator, get the list of contacts!");
        System.out.println("In Order: ");
        System.out.println(adb.itString(null));
        System.out.println();  System.out.println();
        System.out.println("Pre Order: ");
        System.out.println(adb.itString(1));
        System.out.println(); System.out.println();
        System.out.println("Post Order: ");
        System.out.println(adb.itString(2));
        System.out.println();  System.out.println();  System.out.println("**ehem, press enter**");
        s.nextLine();
        System.out.println("Now, Lets grab a contact using just its name: \"James Butt\"");
        System.out.println(adb.search("James Butt"));
        System.out.println();System.out.println();
        System.out.println("Lets grab Kanisha Waycott too.");
        System.out.println(adb.search("Kanisha Waycott"));
        System.out.println();  System.out.println("You know the drill");  System.out.println(" **press ENTER** ");
        s.nextLine();
        System.out.println();System.out.println();System.out.println();
        
        System.out.println("Now, lets see what happens when we remove root from the AddressBook");
        adb.remove("James Butt");
        System.out.println(adb.itString(0));
        System.out.println("Notice, The order did not change, however James is no longer here!");
        System.out.println(" **press ENTER** ");
        s.nextLine();
        System.out.println();System.out.println();System.out.println();
   
        System.out.println("Say you dont like the Addressbook? No Worries! Let's Clear all contacts: ");
        adb.clear();
        System.out.println(adb.itString(0) + "\t<- theres nothing there! **because its cleared**");
        System.out.println(); System.out.println("\t\t**ehem**"); System.out.println(); 
        s.nextLine();
        System.out.println("Have a new Friend Group? No Worries! ");
        AddressBook newFriends = new AddressBook();
        newFriends.insert(new Contact("Ross Geller", "(518)662-1096", new Address("12 Middle Country Rd", "NYC", "NY,", "10001"))
        		);
        newFriends.insert(new Contact("Rachel Green", "(518)001-1000", new Address("12 Middle Country Rd", "NYC", "NY,", "10001"))
        		);
        newFriends.insert(new Contact("Peter Griffin", "(613)501-9087", new Address("10 N Quohog Rd", "Quohog", "RI,", "67802"))
        		);
        newFriends.insert(new Contact("Tom Hanks", "(518)001-1000", new Address("12 Middle Country Rd", "NYC", "NY,", "10001"))
        		);
        newFriends.insert(new Contact("Billy Joel", "(516)707-1871", new Address("10 Oyster Bay Blvd", "Oyster Bay", "NY,", "11708"))
        		);
        newFriends.insert(new Contact("Jim Carrey", "(000)662-0912", new Address("101 HollyWood Blvd", "Hollywood", "CA,", "95712"))
        		);
        newFriends.insert(new Contact("JAY-Z", "(381)202-1092", new Address("26 W Broadway St", "NYC", "NY,", "11011"))
        		);
        newFriends.insert(new Contact("Dwayne Johnson", "(231)884-2836", new Address("905 Indian Spring Street", "Altamonte Springs", "FL,", "32714"))
        		);
        newFriends.insert(new Contact("David Chappelle", "(231)884-2836", new Address("7 Water St.", "Sidney", "OH", "45365"))
        		);
        
        System.out.println("Look, I just created an entirely new AddressBook to hold all my new, cool friends:\n " + newFriends.itString(0));
        System.out.println("Lit, except I REALLLLLYY don't like Peter Griffin..."); System.out.println(); System.out.println("\t\t**poof**");
        newFriends.remove("Peter Griffin");
        System.out.println(newFriends.itString(0));
        System.out.println("Ehhemm.... Please Go on....");System.out.println();
        s.nextLine();
        System.out.println("Now, even though I have all these new friends.. I still dont like them... SOO...");
        newFriends.clear();
        System.out.println("...ehem.... IS.. my addressbook finally empty like it should be? :: " + newFriends.isEmpty());
        System.out.println();System.out.println();System.out.println();
        s.nextLine();
        System.out.println("Any bussines inquires to potentially buying my freshly created Data Structure please email me at:\n"  
        					+ "\t\t jkoch@albany.edu ");
        System.out.println("SERIOUS INQUIRES ONLY... I manage Lebron's Address Book so you can count on the best updates and more! If you go through the Source Code\n "
        					+ " you can see some of the working and developing features I may add to addressbook, but first, you must buy it of course!");
        System.out.println("BUY NOW FOR ONLY 99.99$! THATS A BARGIAN!");
        System.out.println("** We are not responsible for you not having any friends to put into your address book **");
        System.out.println("** Also a no-money-back warranty policy, if your AddressBook randomly loses your contacts because your computer shuts off, you should have written it down on paper **");
    }
}
