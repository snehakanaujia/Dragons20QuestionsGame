import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

/**
 * The model class that hold the binary tree of question and answers read in from the XML File,
 * has several getter methods for the current node the user is on and the binary tree, a method
 * to create a string of binary tree leaf node values, and methods that traverse through the
 * tree updating the current node value as the user clicks buttons etc, as well as a method
 * to check is a node is a leaf or not
 * 
 * @author Sneha Kanaujia
 *
 */
public class DragonModel extends DragonFileReader {

	//Default Binary Tree object to hold the tree taken in from the XML file
	private static DefaultBinaryTree<String> dragonTree = new DefaultBinaryTree<String>();
	//Default Binary Tree node used to traverse through the tree as the user desires
	public static DefaultBinaryTreeNode<String> currentNode = new DefaultBinaryTreeNode<String>();
	//String of dragons the user can choose from
	private static String dragons = "";

	/**
	 * Constructor that calls to the file reader class to get the binary tree that's formed
	 */
	public DragonModel()
	{
		//Gets the binary tree from reading in the XM file
		dragonTree = DragonReader();
		//Sets the instance variable to the tree root
		currentNode = dragonTree.root;
	}

	/**
	 * Getter method for the binary tree
	 * @return dragonTree the binary tree that was taken from the XML file
	 */
	public DefaultBinaryTree<String> getTree()
	{
		return dragonTree;

	}

	/**
	 * Getter method to recursively develop and return a string of the data of all the leaf/answer/dragon nodes
	 * @param node of the binary tree
	 * @return dragons a string of the data of all the leaf/answer/dragon nodes
	 */
	public String getDragons(DefaultBinaryTreeNode<String> node)
	{
		//Checks if the node is a leaf and if so, adds that data to a collective string of those answer/dragon nodes
		if(node.isLeaf())
		{
			dragons += node.getData() + ", ";
		}
		//If not, recursively performs this method on the children nodes
		else
		{
			getDragons(node.getRightChild());
			getDragons(node.getLeftChild());
			
		}
		
		return dragons;
	}
	
	/**
	 * Getter method for the current node the user is on while traversing through the binary tree
	 * @return currentNode the node the user is currently on while traversing through the binary tree
	 */
	public DefaultBinaryTreeNode<String> getCurrentNode()
	{
		return currentNode;
	}

	/**
	 * Traverses to the current BTN's right child if the user chose yes as their answer
	 */
	public void choiceYes()
	{
		if(currentNode.getRightChild() != null)
		{
			currentNode = currentNode.getRightChild();
		}
	}

	/**
	 * Traverses to the current BTN's left child if the user chose no as their answer
	 */
	public void choiceNo()
	{
		if(currentNode.getLeftChild() != null)
		{
			currentNode = currentNode.getLeftChild();
		}
	}

	/**
	 * Checks if this node is a leaf (has no children).
	 * @return true if leaf node.
	 */
	public boolean isDragon(BinaryTreeNode<String> node)
	{
		return node.isLeaf();
	}

}
