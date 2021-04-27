package BinaryTree;



import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TreeIterator<t extends Comparable<t>> implements java.util.Iterator<t> {

	/**
	 * reference to main BinarySearchTree
	 */
    private BaseBinaryTree<t> tree;
    /**
     * List representation of of the BinarySearchTree
     */
    private LinkedList<TreeNode<t>> list;

    /**
     * Blank Iterator Constructor
     */
    public TreeIterator() {}
    
    /**
     * TreeIterator Constructor
     * @param tree take type BinarySearchTree to initialize TreeIterator
     */
    public TreeIterator(BinarySearchTree<t> tree) {
        /**
         * Sets Reference to BinarySearchTree
         */
    	this.tree = tree;
    	/**
    	 * Initializes Iteration List list
    	 */
        list = new LinkedList<TreeNode<t>>();
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
       return !this.list.isEmpty();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public t next() {
     return this.list.remove().getElement();
    }

    /**
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation).  This method can be called
     * only once per call to {@link #next}.
     * <p>
     * The behavior of an iterator is unspecified if the underlying collection
     * is modified while the iteration is in progress in any way other than by
     * calling this method, unless an overriding class has specified a
     * concurrent modification policy.
     * <p>
     * The behavior of an iterator is unspecified if this method is called
     * after a call to the {@link #forEachRemaining forEachRemaining} method.
     *
     * @throws UnsupportedOperationException if the {@code remove}
     *                                       operation is not supported by this iterator
     * @throws IllegalStateException         if the {@code next} method has not
     *                                       yet been called, or the {@code remove} method has already
     *                                       been called after the last call to the {@code next}
     *                                       method
     * @implSpec The default implementation throws an instance of
     * {@link UnsupportedOperationException} and performs no other action.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the Order of the Linked List to Pre Order
     */
    public void setPreorder() {
        this.list.clear();
        this.preorder(this.tree.getRoot());
        
    }
    
    /**
     * Sets the Order of the Linked List to In Order
     */
    public void setInorder() {
        this.list.clear();
        this.inorder(this.tree.getRoot());
        
    }

    /**
     * Sets the Order of the Linked List to Post Order
     */
    public void setPostorder() {
        this.list.clear();
        this.postorder(this.tree.getRoot());
        
    }
    
    /**
     * Private to This Class only, puts the LinkedList in PreOrder
     * @param node is the node being called recursively to set this list in the correct order
     */
    private void preorder(TreeNode<t> node) {
        if( node != null )
        {
        	this.list.add(node);
            inorder(node.getLeft());
            inorder(node.getRight());
        }
    }
    
    /**
     * Private to This Class only, puts the LinkedList in InOrder
     * @param node node is the node being called recursively to set this list in the correct order
     */
    private void inorder(TreeNode<t> node) {
        if( node != null )
        {
           preorder(node.getLeft());
            this.list.add(node);
            preorder(node.getRight()); 
        }
    }

    /**
  	 * Private to This Class only, puts the LinkedList in PostOrder
     * @param node node is the node being called recursively to set this list in the correct order
     */
    private void postorder(TreeNode<t> node) {
        if( node != null )
        {
            postorder(node.getRight());
            postorder(node.getLeft());
            this.list.add(node);
        }
    }


}
