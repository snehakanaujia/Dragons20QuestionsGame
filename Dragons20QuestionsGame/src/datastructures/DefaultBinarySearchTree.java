package datastructures;
/**
 * Can insert, search for, 
 * @author Sneha Kanaujia
 *
 * @param <T> a generic placeholder for any non-primitive Object
 */
public class DefaultBinarySearchTree<T extends Comparable<T>> extends DefaultBinaryTree<T> implements BinarySearchTree<T> {

	/**
	 * Constructor calls super
	 */
	public DefaultBinarySearchTree()
	{
		super();
	}

	/**
	 * Insert the data into the tree, maintaining the
	 * search tree invariant.
	 * @param data being inserted into the tree
	 */  
	@Override
	public void insert(T data) {
		
		if(data != null)
		{
			if(root.getData() == null)
			{
				root.setData(data);
			}
			else
			{
				insert(root, data);
			}
		}
	}

	/**
	 * Insert the data into the tree, maintaining the
	 * search tree invariant by recursively checking .
	 * @param node the node being checked for the data/having it's data compared to find correct placement of data to be inserted
	 * @param data is the data being inserted into the tree
	 */
	private void insert(BinaryTreeNode<T> node, T data) {

		//Checks if the current node element is greater than the data being inserted
		if((node.getData()).compareTo(data) > 0)
		{
			//Checks if the left child is null
			if(node.getLeftChild() == null)
			{
				//Creates a new node and sets its data to the data being inserted
				BinaryTreeNode<T> newNode = new DefaultBinaryTreeNode<T>();
				newNode.setData(data);
				//Sets the new left child to the new node with the newly inserted data
				node.setLeftChild(newNode);
			}
			//If not, recurses to the next left child
			else
			{
				insert(node.getLeftChild(), data);
			}

		}
		//Checks if the current node element is less than or equal to the data being inserted
		else if((node.getData()).compareTo(data) <= 0)
		{
			//Checks if the right child is null
			if(node.getRightChild() == null)
			{
				//Creates a new node and sets the data to what's been given
				BinaryTreeNode<T> newNode = new DefaultBinaryTreeNode<T>();
				newNode.setData(data);
				//Sets the new right child to the new node with the newly inserted data
				node.setRightChild(newNode);
			}
			//If not, recurses to the next right child
			else
			{
				insert(node.getRightChild(), data);
			}

		}

	}

	/**
	 * Search for data in the tree, finding the node
	 * containing it, or null if the data is not present
	 * in the tree.
	 * @param data that is being looked for in the tree
	 * @return the node containing data or null if none exists.
	 */
	@Override
	public BinaryTreeNode<T> search(T data) {

		if(root != null)
		{
			return search(root, data);
		}
		return null;

	}

	/**
	 * Search recursively for data in the tree, finding the node
	 * containing it, or null if the data is not present
	 * in the tree.
	 * @param node being checked for the data
	 * @param data that is being looked for in the tree
	 * @return the node containing data or null if none exists.
	 */
	private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T data) {

		//Checks if the node is null
		if (node == null)
		{
			return null;
		}

		//Checks if the current node element is equal to the data given and if so returns that node
		if ((node.getData()).compareTo(data) == 0)
		{
			return node;
		}
		//Checks if the current node element is greater than the data given and if so, recurses with the left child since it should be smaller than the current node
		else if ((node.getData()).compareTo(data) > 0)
		{
			return search(node.getLeftChild(), data);
		}
		//Checks if the current node element is less than the data given and if so, recurses with the right child since it should be greater than the current node
		else if ((node.getData()).compareTo(data) < 0)
		{
			return search(node.getRightChild(), data);
		}
		
		return null;
	}

	/**
	 * Find the minimum element in the tree.
	 * @return the minimum element in the tree 
	 */
	@Override
	public T minElement() {
		//Sets a temporary DefaultBinaryTreeNode object called node to start from the root and cycle through the tree
		DefaultBinaryTreeNode<T> node = root;

		//Cycles through the tree with the node till its at the left most node in the tree
		while(node.getLeftChild() != null && !node.isLeaf())
		{
			node = node.getLeftChild();
		}

		//Returns the element at the left most node in the tree
		return node.getData();
	}

	/**
	 * Find the maximum element in the tree.
	 * @return the maximum element in the tree 
	 */
	@Override
	public T maxElement() {
		//Sets a temporary DefaultBinaryTreeNode object called node to start from the root and cycle through the tree
		DefaultBinaryTreeNode<T> node = root;

		//Cycles through the tree with the node till its at the right most node in the tree
		while(node.getRightChild() != null && !node.isLeaf())
		{
			node = node.getRightChild();
		}

		//Returns the element at the right most node in the tree
		return node.getData();
	}


}
