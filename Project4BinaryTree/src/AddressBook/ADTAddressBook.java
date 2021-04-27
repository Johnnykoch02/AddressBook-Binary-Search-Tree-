package AddressBook;

import BinaryTree.TreeNode;

/**
 * AddressBook Project 4 Qi Wang
 * @author John Koch
 * @Version 2.0
 */

public interface ADTAddressBook {

    /**
     * Inserts new Contact into addressbook
     * @param contact is the contact being inserted
     */
    public void insert(Contact contact);

    /**
     * Removes specified contact from addressbook
     * @param contact is the contact we will be removing from addressbook
     */
    public void remove(Contact contact);
    /**
     * Removes specified contact from addressbook
     *
     * @param contact is the contact we will be removing from addressbook
     * @return true if object is in addressbook, false if item was not found in addressbook
     */
    public void remove(String contact);

    /***
     * Returns boolean for Addressbook being empty
     * @return true if tree-Head is null, false otherwise
     */

    public boolean isEmpty();

    /**
     * Gets a reference to a contact based off of a contact name
     * @param contact Is the contact name being searched for
     * @return the Said found contact reference, or null if it is not found
     */
    public Contact search(String contact);



    /**
     * Clears the Addressbook
     */
    public void clear();
    
    /**
     * Gets the size of the AddressBook 
     * @return number of elements in AdressBook
     */
    public int size();

	/**
	 * AddressBook toString method, derived from the TreeIterator class
	 * @param orderNumber 0= InOrder, 1= PreOrder, 2= 
	 * @return toString Value
	 */
	public String itString(Integer order);
    
    //    /**
//     * Searches for a particular contact in Addressbook
//     * @param contact is the Specified contact in question
//     * @return String Location Representation in Left/Right.Left/Right Notation
//     */
//    public boolean search(Contact contact);

    //    /**
//     * Gets a reference to a contact based off of a String representation of the location ie. "Left.Left.Right"
//     * @param location is the String representation of the contact location ie. "Right.Left.Left"
//     * @return a Contact reference to the given String location, or null if there is no Node with that specified Location
//     */
//    public Contact find(String location);
}
