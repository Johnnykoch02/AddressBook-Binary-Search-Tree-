package AddressBook;

import BinaryTree.BinarySearchTree;
import BinaryTree.TreeException;
import BinaryTree.TreeIterator;
import BinaryTree.TreeNode;

/**
 * AddressBook Project 4 Qi Wang
 * @author John Koch
 * @Version 2.0 
 */


public class AddressBook implements ADTAddressBook{
	
	/**
	 * This is where our Contacts are heald
	 */
    private BinarySearchTree<Contact> tree;
    
    /**
     * This keeps track of the number of items in our BST
     */
    private int count;

    public AddressBook() {
    	/**
    	 * Initializes Count
    	 */
        count = 0;
        /**
         *Initializes the Data Container 
         */
        tree = new BinarySearchTree<Contact>();
    }
    /**
     * gets the reference to BinarySearchTree tree
     * @return BinarySearchTree tree
     */
    public BinarySearchTree<Contact> getBst(){return tree;}

    /**
     * Inserts new Contact into Addressbook
     * @param contact is the contact being inserted
     */
    @Override
    public void insert(Contact contact) {
        tree.insert(new TreeNode<Contact>(contact));
        count++;
    }

    /**
     * Removes specified contact from Addressbook
     * @param contact is the contact we will be removing from Addressbook
     * @return void
     */
    @Override
    public void remove(Contact contact) {
     	/**
    	 * if element was successfully remove, the count will not be degradated.
    	 */
    	try {
    		tree.remove(contact);
    		count--;
    	}catch(TreeException e) {}
	
    }

    /**
     * Removes specified contact from Addressbook
     * @param contact is the contact we will be removing from Addressbook
     * @return TreeNode<Contact> of the value removed from the Tree.</Contact>
     */
    @Override
    public void remove(String contact) {
    	/**
    	 * if element was successfully remove, the count will not be degradated.
    	 */
    	try {
    		tree.remove(search(contact));
    		count--;
    	}catch(TreeException e) {}
	
    }

    /***
     * Returns boolean for Addressbook being empty
     * @return true if tree-Head is null, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    /**
     * Clears the Addressbook
     */
    @Override
    public void clear() {
    	tree = new BinarySearchTree<Contact>();
    }

    /**
     * Gets a reference to a contact based off of a Name
     * @param contact Is the contact name being searched for
     * @return the Said found contact reference, or null if it is not found
     */
    @Override
    public Contact search(String contact) {
        /**
         * Initialize a boolean field for the while-loop we will produce to false
         */
    	boolean found = false;
    	/**
    	 * Get the Root Node to start the Algorithm
    	 */
        TreeNode<Contact> node = tree.getRoot();
        while(!found)
        {
        	/**
        	 * Check to see if node is null. If node is null, the contact is not in tree. return case null.
        	 */
            if (node == null)
            {
                return null;
            }
            /**
             * Roe is a concept comparator integer, where the value of roe will tell us information of the current "node" value
             */
            int roe  = contact.compareToIgnoreCase(node.getElement().getName());
            /**
             * Roe has found our element, return case node's contact
             */
            if(roe == 0)
            {
                found = true;
                return node.getElement();
            }
            /**
             * Roe tells us the element must be to the right of this element
             */
            else if(roe > 0)
            {
                node = node.getRight();
            }
            /**
             * Roe tells us the element must be to the left of this element
             */
            else if(roe < 0)
            {
                node = node.getLeft();
            }
        }
        /**
         * And if somehow the program makes it this far...? Return null 
         */
        return null;
    }
    
    /**
     * Gets the size of the AddressBook 
     * @return number of elements in AdressBook
     */
    @Override
    public int size() {
    	return count;
    }
    
    /**
     *  AddressBook Iterator String method, derived from the TreeIterator class
     * @param orderNumber 0= InOrder, 1= PreOrder, 2= PostOrder, Else is Default
     * @return toString Value
     */
	@Override
    public String itString(Integer order) {
		/**
		 * Initialize the starting String & the Return Value
		 */
		String ret = "";
		/**
		 * Get new tree Iterator in reference to the Data Container
		 */
		TreeIterator<Contact> iterator = tree.iterator();
		/**
		 * Avoids a NullPointerException
		 */
		if (order == null) order = 0;
		/**
		 * Case 1
		 */
		if(order == 0) iterator.setInorder();
		/**
		 * Case  2
		 */
		else if(order == 1) iterator.setPreorder();
		/**
		 * Case 3
		 */
		else if(order == 2) iterator.setPostorder();
		/**
		 * Default Case
		 */
		else iterator.setInorder();
		/**
		 * Algorithm for Iterator
		 */
    	while(iterator.hasNext())
    	{
    		/**
    		 * Appends The next contact tp the return value
    		 */
    		ret+=iterator.next().toString()+"\n";
    	}
    	
    	return ret;
    }
    
    //    /**
//     * Searches for a particular contact in Addressbook
//     *
//     * @param contact is the Specified contact in question
//     * @return String Location Representation in Left/Right.Left/Right Notation
//     */
//    @Override
//    public boolean search(Contact contact) {
//        return tree.find(contact);
//    }
}
