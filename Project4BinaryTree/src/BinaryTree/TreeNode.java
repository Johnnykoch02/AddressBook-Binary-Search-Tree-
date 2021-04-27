package BinaryTree;

/**
 * AddressBook Project 4 Qi Wang
 * @author John Koch
 * @Version 2.0
 * @param <t> Generic 
 */

public class TreeNode<t> {

	/**
	 *  Element being stored 
	 */
    private t element;
    /**
     * The children nodes of this node
     */
    private TreeNode<t> left, right;

    /**
     * Default Constructor
     */
    public TreeNode() {}

    /**
     * 
     * @param element
     */
    public TreeNode(t element) {
        this.element = element;
    }

    public t getElement() {
        return element;
    }

    public void setElement(t element) {
        this.element = element;
    }

    public TreeNode<t> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<t> left) {
        this.left = left;
    }

    public TreeNode<t> getRight() {
        return right;
    }

    public void setRight(TreeNode<t> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "["+element.toString()+"]";
    }


}
