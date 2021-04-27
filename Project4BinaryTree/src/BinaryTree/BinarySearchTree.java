package BinaryTree;

/**
 * AddressBook Project 4 Qi Wang
 * @author John Koch
 * @Version 2.0
 * @param <t> Generic 
 */



public class BinarySearchTree<t extends Comparable<t>> extends BaseBinaryTree<t> {

	/**
	 * Reference to our classes TreeIterator
	 */
    private TreeIterator<t> Iterator;

    /**
     * Default // Blank Constructor
     */
    public BinarySearchTree() {
        Iterator = new TreeIterator<t>(this);
    }

    /**
     * Regular Constructor which initializes the Root Value
     * @param root is being passed into our BinarySearchTree
     */
    public BinarySearchTree(TreeNode<t> root) {
    	/**
    	 * Calls Super Constructor of BaseBinaryTree, and passes Root into it
    	 */
        super(root);
        /**
         * Initializes a new TreeIterator and passes in this Instance of the Class
         */
        Iterator = new TreeIterator<t>(this);
    }

    /**
     * This method is called  to get a reference to an iterator with a reference  to this Instance of the Class
     * @return TreeIterator that has a reference to this BinarySearchTree Instance
     */
    public TreeIterator<t> iterator() {return new TreeIterator<t>(this);}

    /**
     * Is Empty Method returns a boolean regarding Emptiness of BinarySearchTree
     * @param boolean value of the status of the emptiness of BinarySearchTree
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Empties the BinarySearchTree
     */
    @Override
    public void empty() {
    	/**
    	 * Since we already created this method in the Base class, we call the super method
    	 */
        super.empty();
    }

    /**
     * Returns root node of BinarySearchTree
     */
    @Override
    public TreeNode<t> getRoot() {
        return super.getRoot();
    }

    /**
     * Sets the root node of this BinarySearchTree
     */
    @Override
    public void setRoot(TreeNode<t> root) { 
    	super.setRoot(root);
    	}

    /**
     * Inserts an element into the BinarySearchTree
     * @param element is the Tree Node which is being inserted into the BinarySearchTree
     */
    public void insert(TreeNode<t> element) {
    	/**
    	 * Creates a Boolean which will operate our While-Loop
    	 */
        boolean done = false;
        /**
         * Sets Current reference to Root for the beggining of our While-Loop
         */
        TreeNode<t> current = super.root();
        /**
         * Checks to see if Root was Null
         */
        if(current ==  null)
        {
        	/**
        	 * Root was null, set the root
        	 */
        	super.setRoot(element);
        	/**
        	 * Since we are done, we can skip the while-loop
        	 */
            done = true;
        }
        /**
         *  Algorithm for Node Insertion
         */
        while (!done) {
        	/**
        	 * Roe is a parameter I use for comparing two objects
        	 */
            int roe = current.getElement().compareTo(element.getElement());

            /**
             * Since roe is greater than 0, we need to move element to the left
             */
            if (roe > 0)  
            {
            	/**
            	 * Finding where to insert this element is complete
            	 */
                if (current.getLeft() == null) {
                	/**
                	 * Set this element to the Left
                	 */
                    current.setLeft(element);
                    /**
                     * Set the While-Loop Flag to true to break the loop
                     */
                    done = true;
                } else {  /** The element would be moved again to the left */
                    current = current.getLeft();
                }          
                /**
                 * Since roe is less than 0, we need to move element to the right
                 */
            } else if (roe < 0)
            {
             	/**
            	 * Finding where to insert this element is complete
            	 */
                if (current.getRight() == null) {
                	/**
                	 * Set this element to the Right
                	 */
                    current.setRight(element);
                    /**
                     * Set the While-Loop Flag to true to break the loop
                     */
                    done = true;
                } else { /** The element would be moved again to the right */
                    current = current.getRight();
                }
            } else if (roe == 0) {   /**  I think the best option is to move it left, so it gets moved Right. Duplicate elements should be stored Left of the Origin Node. */
                if (current.getLeft() == null) {
                	/**
                	 * Insert to the left
                	 */
                    current.setLeft(element);
                    /**
                     * Set the While-Loop Flag to true to break the loop
                     */
                    done = true;
                } else {
                	/**
                	 * Move this element left
                	 */
                    current = current.getLeft();
                }
            }
        }
    }

    /**
     * Get will return a reference to a node with equal data
     * @param element is the data being searched for
     * @return the TreeNode reference with element's data
     */
    private TreeNode<t> get(t element) {
    	/**
    	 * Initialize a boolean field for our while-loop algorithm
    	 */
        boolean done = false;
        /**
         * Initialize current node to the root
         */
        TreeNode<t> current = super.root();

        /**
         * Algorithm for Get Method
         */
        while (!done) {
        	/**
        	 * First, we should always check every loop to see if the element is not in the Tree
        	 */
            if (current == null)
            {
                return null; // Element was not found
            }
            /**
             * ret will tell us where the element is in relation to the current node
             */
            int ret = current.getElement().compareTo(element);
            /**
             * Since ret is 0, we found our element
             */
            if (ret == 0)
            {
                return current;
            }
            /**
             * Our element is less than the current, move the current to the left
             */
            if (ret > 0)  // 
            {
                current = current.getLeft();
            } 
            /**
             * Our element is greater than the current, move the current to the right
             */
            else if (ret < 0) 
            {
                current = current.getRight();
            }
        }
        return null;
    }
    /**
     * Public reference to a BinarySearchTree Removal on <t> element
     * @param element is the element we will try to remove 
     * @throws TreeException when the element is not found
     */
    public void remove(t element) throws TreeException {
        recRemove(super.root, null, element);
        
    }
    
    /**
     * Recursive Method which calls itself in order to process the 
     * three case possibilities of Tree Node Removal: No Children, One Child, or Two Children
     * @param node is the node we are currently checking
     * @param parent is the previous node from where 'node' came from
     * @param element is the element we need to remove
     * @throws TreeException when element is not in the BinarySearchTree
     */
    private void recRemove(TreeNode<t> node,TreeNode<t> parent, t  element) throws TreeException {
    	/**
    	 * Element is not in tree
    	 */
    	if(node == null)
    	{
    		throw new TreeException("Node not Found");
    	}
    	/**
    	 * ret holds information regarding the location of element
    	 */
    	int ret = node.getElement().compareTo(element);
        if (ret > 0)  // move current node to the left
        {
           recRemove(node.getLeft(), node, element);
        }
        else if (ret < 0) // move current node to the right
        {
        	recRemove(node.getRight(), node, element);
        }
        /**
         * We found our element, time to check for the three cases
         */
        else {
        	/**
        	 * Case Three: Left and Right child contain Data
        	 */
        	if(node.getLeft() != null && node.getRight() != null)
        	{
        		/**
        		 * We must find the minimum on the Right, and set its data to this nodes data
        		 */
        		TreeNode<t> min = findMin(node.getRight());
        		node.setElement(min.getElement());
        		/**
        		 * Then, we must recursively call to remove the extra element out of the BST
        		 */
        		recRemove(node.getRight(),node,min.getElement());
        	}
        	/**
        	 * Case One: Node has no children, we can just remove it
        	 */
        	else if (node.getLeft() == null && node.getRight() == null)	//CASE 1: this node is just a Leaf
        	{        		
        		node = null;       	
        	}
        	/**
        	 * Case Two: Left node is empty but Right node contains Data
        	 */
        	else if(node.getLeft() == null && node.getRight() != null)
        	{
        		if(node == parent.getLeft()) parent.setLeft(node.getRight());
        		else parent.setRight(node.getRight());
        	}
        	/**
        	 * Case Two: Right node is empty but Left node contains Data
        	 */
        	else if(node.getLeft() != null && node.getRight() == null)
        	{
        		if(node == parent.getLeft()) parent.setLeft(node.getLeft());
        		else parent.setRight(node.getLeft());
        	}
        	/**
        	 * Should never see this message ;-;
        	 */
        	else {
        		System.out.println("IDFKEEHEHEEEHSHAHAHH");
        		throw new TreeException("What he said ;-; ^");
        	}
        	
        }
		
    }
    
    /**
     * This method gives the minimum-most element on the right side of the Binary Tree // Sub-Binary Tree,
     * *Note* that all Sub-Binary Trees are technically still binary trees
     * @param right is the right element we need a minimum for
     * @return the Minimum-most element on the right side of the parent node
     */
	private TreeNode<t> findMin(TreeNode<t> right) {
		boolean done = false;
		TreeNode<t> temp = right;
		while(!done)
		{
			if(temp.getLeft() == null)
			{
				return temp;
			}
			else {
				temp = temp.getLeft();
			}
		}
		return null;
	}
	
    /**
     * This method gives the minimum-most element on the right side of the Binary Tree // Sub-Binary Tree,
     * *Note* that all Sub-Binary Trees are technically still binary trees
     * @param left is the left element we need a minimum for
     * @return the Maximum-most element on the right side of the parent node
     */
	private TreeNode<t> findMax(TreeNode<t> left) {
		boolean done = false;
		TreeNode<t> temp = left;
		while(!done)
		{
			if(temp.getRight() == null)
			{
				return temp;
			}
			else {
				temp = temp.getRight();
			}
		}
		return null;
	}
    
    
    

//  public String find(t element) {
//      boolean done = false;
//      TreeNode<t> current = super.root();
//      String location = "";
//      while (!done) {
//          if (current == null) {
//              return ("Not In String.");
//          }
//
//          int ret = current.toString().compareToIgnoreCase(element.toString());
//
//          if (ret == 0) {
//              done = true;
//              return location.substring(0, location.length() - 1);
//          }
//          if (ret > 0)  // move element to the left
//          {
//              current = current.getLeft();
//              location += "Left.";
//          } else if (ret < 0) // move the element to the right
//          {
//              current = current.getRight();
//              location += "Right.";
//          }
//      }
//      return "-1";
//  }

}
