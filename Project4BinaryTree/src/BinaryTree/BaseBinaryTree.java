package BinaryTree;

public abstract class BaseBinaryTree<t> {

	/**
	 * Root holds reference to the  entire  tree
	 */
    protected TreeNode<t> root;

    /**
     * Empty Constructor
     */
    public BaseBinaryTree() {}
    
    /**
     * Default Constructor to initialize Base Binary Tree
     * @param root Initializes root
     */
    public BaseBinaryTree(TreeNode<t> root) {
        this.root= root;
    }

    /**
     * Standard isEmpty method will return true/false regarding the status of emptiness of BaseBinaryTree
     * @return a boolean value regarding the status of emptiness of BaseBinaryTree
     */
    public boolean isEmpty() {return this.root==null;}

    /**
     * Makes Empty the BaseBinaryTree
     */
    public void empty() {this.root = null;}

    /**
     * Setter Method for BaseBinaryTrees root value
     * @param root sets value root
     */
    public void setRoot(TreeNode<t> root) {
        this.root = root;
    }
    
    /**
     * Getter Method for BaseBinaryTrees root value
     * @return Root Value
     */
    public TreeNode<t> getRoot(){return this.root;}
    
    protected TreeNode<t> root() {
    	return this.root;
    }
}
