import javax.xml.parsers.*;
import org.xml.sax.SAXException;

import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

import org.w3c.dom.*;
import java.io.*;

/**
 * Class that reads through the XML file and generates a binary tree of question and answer node from that file.
 * 
 * @author Sneha Kanaujia
 * @param <T> a generic placeholder for any non-primitive Object
 *
 */
public class DragonFileReader {

	private static DefaultBinaryTree<String> dragonBT = new DefaultBinaryTree<String>();

	public DefaultBinaryTree<String> DragonReader() {
		//Setup XML Document
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		File xmlFile = new File( "Dragons.xml" );
		Document document;

		try {
			//code that may cause an exception
			builder = factory.newDocumentBuilder();
			document = builder.parse( xmlFile );
			//Calls method to parse through the document
			parseDragonFile(document);
			//dragonTree.preorderTraversal();
			return dragonBT;
		}
		catch (ParserConfigurationException pce) {
			//what to do if this exception happens
			System.err.println("Caught ParserConfigurationException: " + pce.getMessage());
		}
		catch (SAXException saxe) {
			//what to do if this exception happens
			System.err.println("Caught SAXException: " + saxe.getMessage());
		}
		catch (IOException ioe) {
			//what to do if this exception happens
			System.err.println("Caught IOException: " + ioe.getMessage());

		}
		return dragonBT;


	}

	/**
	 * Reads/parses through XML file/a Document object
	 * @param document that is being read/parsed
	 */
	private static void parseDragonFile( Document document )
	{
		//Gets the first element from the document and saves it in a Node
		Node docRoot =  document.getDocumentElement();
		//Sends the node to be parsed
		dragonBT.setRoot(parseNode(docRoot));
	}

	private static DefaultBinaryTreeNode<String> parseNode(Node n)
	{
		//Creates a new node
		DefaultBinaryTreeNode<String> newNode = new DefaultBinaryTreeNode<String>();

		//Checks that the node is an element note rather than say, a text node
		if( n.getNodeType() == Node.ELEMENT_NODE )
		{
			//Saves the node as an element
			Element currentElt = (Element) n;

			//Gets the name and value of the element node
			String name = currentElt.getNodeName();

			newNode.setData(currentElt.getAttribute("text"));

			//Checks if the DragonTree is null and the first element is a question, if so it sets it as the head
			if(name.equals("dragon"))
			{
				return newNode;
			}

		}

		//Saves the list of child nodes in a variable
		NodeList list = n.getChildNodes();

		//Cycles through the list of child nodes and parses them
		for (int i = 0; i < list.getLength(); i++)
		{
			Node node = list.item(i);

			//Checks that the node is an element note rather than say, a text node
			if( node.getNodeType() == Node.ELEMENT_NODE )
			{
				//Saves the node as an element
				Element currentElt = (Element) node;

				//Checks if the Element Node has an "text" attribute
				if(currentElt.hasAttribute("text") && currentElt.getAttribute("text") != null)
				{

					//Checks if the right child is null and if not, is where the next/first child node (yes answer node) will be stored
					if(newNode.getRightChild() == null)
					{
						newNode.setRightChild(parseNode(node));
					}
					//Checks if the left child is null and if not, is where the next/second child node (no answer node) will be stored
					else if(newNode.getLeftChild() == null)
					{
						newNode.setLeftChild(parseNode(node));
					}
				}
			}
		}

		return newNode;
	}

}

