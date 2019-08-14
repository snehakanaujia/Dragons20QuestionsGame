package datastructures;
/**
 * Creates the nodes to save and change data, left and right children, also checks if it's a leaf (has no children nodes) and to be added to Trees (and indirectly lists).
 * @author Sneha Kanaujia
 *
 * @param <T> a generic placeholder for any non-primitive Object
 */
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode{

	private T data;
	private DefaultBinaryTreeNode<T> leftChild = null;
	private DefaultBinaryTreeNode<T> rightChild = null;

	/**
	 * Get the data stored at this node.
	 * @return data stored at this node
	 */
	@Override
	public T getData() {
		return data;
	}

	/**
	 * Set the data stored at this node.
	 * @param data that will be stored at this node
	 */
	@Override
	public void setData(Object data) {
		this.data = (T) data;
	}

	/**
	 * Get the left child.
	 * @return BinaryTreeNode that is left child,
	 * or null if no child.
	 */
	@Override
	public DefaultBinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * Get the right child.
	 * @return BinaryTreeNode that is right child,
	 * or null if no child.
	 */
	@Override
	public DefaultBinaryTreeNode<T> getRightChild() {
		return rightChild;
	}

	/**
	 * Set the left child.
	 * @param left child node
	 */
	@Override
	public void setLeftChild(BinaryTreeNode left) {
		leftChild = (DefaultBinaryTreeNode<T>) left;
	}

	/**
	 * Set the right child.
	 * @param right child node
	 */
	@Override
	public void setRightChild(BinaryTreeNode right) {
		rightChild = (DefaultBinaryTreeNode<T>) right;

	}

	/**
	 * Tests if this node is a leaf (has no children).
	 * @return true if leaf node.
	 */
	@Override
	public boolean isLeaf() {
		
		//Checks if both the right and left children are null
		if(rightChild == null && leftChild == null)
		{
			return true;
		}
		return false;
	}


}
