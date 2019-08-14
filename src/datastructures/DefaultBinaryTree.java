package datastructures;
/**
 * Creates the tree that has a root and can get and set the root data as well as perform inorder, preorder and postorder traversals on the tree nodes.
 * @author Sneha Kanaujia
 *
 * @param <T> a generic placeholder for any non-primitive Object
 */
public class DefaultBinaryTree<T> implements BinaryTree<T>{

	/**
	 * An instance variable to hold the first node in the list
	 */
	public DefaultBinaryTreeNode<T> root = new DefaultBinaryTreeNode<T>();

	/**
	 * SetUp method to create an example tree
	 * @param args are the arguments
	 */
	public void setUp(String[] args)
	{
		//Creates a new instance of BinaryTree
		BinaryTree<String> tree = new DefaultBinaryTree<String>();

		//Creates and sets data for DefaultBinaryTreeNode for the dwarf Happy
		BinaryTreeNode<String> happy = new DefaultBinaryTreeNode<String>();
		happy.setData("Happy");

		//Creates and sets data for DefaultBinaryTreeNode for the dwarf Doc
		BinaryTreeNode<String> doc = new DefaultBinaryTreeNode<String>();
		doc.setData("Doc");

		//Creates and sets data for DefaultBinaryTreeNode for the dwarf Bashful
		BinaryTreeNode<String> bashful = new DefaultBinaryTreeNode<String>();
		bashful.setData("Bashful");

		//Creates and sets data for DefaultBinaryTreeNode for the dwarf Grumpy
		BinaryTreeNode<String> grumpy = new DefaultBinaryTreeNode<String>();
		grumpy.setData("Grumpy");

		//Creates and sets data for DefaultBinaryTreeNode for the dwarf Dopey
		BinaryTreeNode<String> dopey = new DefaultBinaryTreeNode<String>();
		dopey.setData("Dopey");

		//Creates and sets data for DefaultBinaryTreeNode for the dwarf Sleepy
		BinaryTreeNode<String> sleepy = new DefaultBinaryTreeNode<String>();
		sleepy.setData("Sleepy");

		//Creates and sets data for DefaultBinaryTreeNode for the dwarf Sneezy
		BinaryTreeNode<String> sneezy = new DefaultBinaryTreeNode<String>();
		sneezy.setData("Sneezy");

		//Sets the dwarf DefaultBinaryTree Happy as the root
		tree.setRoot(happy);
		//Sets the left child of Happy to Doc
		happy.setLeftChild(doc);
		//Sets the left child of Doc to Bashful
		doc.setLeftChild(bashful);
		//Sets the right child of Doc to Grumpy
		doc.setRightChild(grumpy);
		//Sets the left child of Grumpy to Dopey
		grumpy.setLeftChild(dopey);
		//Sets the right child of Happy to Sleepy
		happy.setRightChild(sleepy);
		//Sets the right child of Sleepy to Sneezy
		sleepy.setRightChild(sneezy);

		//Outputs string interpretation of each traversal type
		System.out.println("Inorder: " + tree.inorderTraversal().toString());
		System.out.println("Preorder: " + tree.preorderTraversal().toString());
		System.out.println("Postorder: " + tree.postorderTraversal().toString());
	}

	/**
	 * Constructor - Does nothing...
	 */
	public DefaultBinaryTree() {}

	/**
	 * Get the root node for this tree.
	 * @return root or null if tree is empty.
	 */
	@Override
	public BinaryTreeNode<T> getRoot()
	{
		return root;
	}

	/**
	 * Set the root node for this tree.
	 * @param root node of the binary tree
	 */
	@Override
	public void setRoot(BinaryTreeNode root)
	{
		this.root = (DefaultBinaryTreeNode<T>) root;
	}

	/**
	 * Test if the tree is empty.
	 * 
	 * @return true if tree has no data (the root is null).
	 */
	@Override
	public boolean isEmpty()
	{
		//Checks if the root is null as returns if it is or not
		if(root == null)
		{
			return true;
		}
		return false;
	}

	/**
	 * Get the data of this tree using inorder traversal. (left-node-right)
	 * 
	 * @return inorder LinkedList.
	 */
	@Override
	public LinkedList<T> inorderTraversal()
	{
		//Creates a new LinkedList to hold all the elements
		LinkedList<T> listI = new LinkedList<T>();
		//Calls for a recursive inorder traversal
		inorderTraversal(root, listI);
		//Returns inorder LinkedList
		return listI;
	}

	/**
	 * Get the data of this tree using inorder traversal recursively. (left-node-right)
	 */
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal)
	{
		//Checks to make sure the node isn't null
		if(node != null)
		{
			//Checks if its a leaf and if so, saves that value
			if(node.isLeaf())
			{
				traversal.add(traversal.size(), node.getData());
			}
			else
			{
				//Recursively calls to save the left most node
				inorderTraversal(node.getLeftChild(), traversal);
				//Saves the current node
				traversal.add(traversal.size(), node.getData());
				//Recursively calls to save the right most node
				inorderTraversal(node.getRightChild(), traversal);
			}

		}
	}

	/**
	 * Get the data of this tree using preorder traversal. (node-left-right)
	 * 
	 * @return preorder LinkedList.
	 */
	@Override
	public LinkedList<T> preorderTraversal()
	{
		//Creates a new LinkedList to hold all the elements
		LinkedList<T> listPre = new LinkedList<T>();
		//Calls for a recursive preorder traversal
		preorderTraversal(root, listPre);
		//Returns preorder LinkedList
		return listPre;
		
	}

	/**
	 * Get the data of this tree using preorder traversal recursively. (node-left-right)
	 */
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal)
	{
		//Checks to make sure the node isn't null
		if(node != null)
		{
			//Checks if its a leaf and if so, saves that value
			if(node.isLeaf())
			{
				traversal.add(traversal.size(), node.getData());
			}
			else
			{
				//Saves the current node
				traversal.add(traversal.size(), node.getData());
				//Recursively calls to save the left most node
				preorderTraversal(node.getLeftChild(), traversal);
				//Recursively calls to save the right most node
				preorderTraversal(node.getRightChild(), traversal);
			}

		}
	}

	/**
	 * Get the data of this tree using postorder traversal. (left-right-node)
	 * 
	 * @return postorder LinkedList.
	 */
	@Override
	public LinkedList<T> postorderTraversal()
	{
		//Creates a new LinkedList to hold all the elements
		LinkedList<T> listPost = new LinkedList<T>();
		//Calls for a recursive postorder traversal
		postorderTraversal(root, listPost);
		//Returns postorder LinkedList
		return listPost;
	}

	/**
	 * Get the data of this tree using postorder traversal recursively. (left-right-node)
	 */
	private void postorderTraversal(DefaultBinaryTreeNode<T> node, LinkedList<T> traversal)
	{
		//Checks to make sure the node isn't null
		if(node != null)
		{
			//Checks if its a leaf and if so, saves that value
			if(node.isLeaf())
			{
				traversal.add(traversal.size(), node.getData());
			}
			else
			{
				//Recursively calls to save the left most node
				postorderTraversal(node.getLeftChild(), traversal);
				//Recursively calls to save the right most node
				postorderTraversal(node.getRightChild(), traversal);
				//Saves the current node
				traversal.add(traversal.size(), node.getData());
			}
		}
	}


}
