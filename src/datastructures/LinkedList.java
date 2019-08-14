package datastructures;
/**
 * 
 * @author Sneha Kanaujia
 *
 * @param <T> a generic placeholder for any non-primitive Object
 */
public class LinkedList<T> implements List<T> {
	
	/**
	 * An instance variable to hold the first node in the list
	 */
	LinkedListNode<T> head;
	
	/**
	 * Helper method to access the node at index. 
	 * If the index is invalid (negative or >= size of list), return null pointer.
	 * @param index is the index at which we are trying to find the desired node
	 **/
	private LinkedListNode<T> getNode( int index )
	{
		//Creates a temporary node called current node
		LinkedListNode<T> currentNode;
		//Sets this temporary node to the same node as the head
		currentNode = head;
		
		//Checks that the index given isn't within the bounds of the list and thus would return null
		if(index < 0 || index >= size())
		{
			return null;
		}
		else
		{
			//Creates an index counter to keep track of the index being checked while cycling through the list
			int currentIndex = 0;
			
			//As long as the temporary node is not null then keep cycling through the list
			while(currentNode != null)
			{
				//Checks if the index counter is the same as the index given
				if(currentIndex == index)
				{
					//Returns the node at that index
					return currentNode;
				}
				else
				{
					//Updates the temporary node to the next node in the list
					currentNode = currentNode.getNext();
					//Increments the index counter
					currentIndex++;
				}
			}
		}
		
		return null;
		
	}
	
	/**
	 * Add (insert) data at specific index in list,
	 * e.g., add( 0, data ) inserts data to front/head of list
	 * @param index is the index at which we are trying to add a new node
	 * @param data is the Object we are trying to assign to the new node
	 **/
	public void add( int index, T data )
	{
		//Creates the node and sets the data with the data given
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		newNode.setData(data);
		
		//Checks if the first node is being changed and thus sets the new 'head'
		if(index == 0)
		{
			//Sets the new node pointer to the old head
			newNode.setNext(head);
			//Changes the head instance variable to the new head node
			head = newNode;
		}
		//Checks if the new node is being added between two existing nodes
		else if(index > 0 && index < size())
		{
			//Gets and saves the previous node
			LinkedListNode<T> lastNode = getNode(index - 1);
			//Sets the pointer of the new node to that of the previous node
			newNode.setNext(lastNode.getNext());
			//Sets the pointer of the previous node to the new node
			lastNode.setNext(newNode);
		}
		//Checks if the node is being added to the end of the list
		else if(index == size())
		{
			//Gets and saves the previous node
			LinkedListNode<T> lastNode = getNode(index - 1);
			//Sets the pointer of the previous node to the new node
			lastNode.setNext(newNode);
		}
		
		
	}
 
	/**
	 * Get data stored at specific index in list.
	 * @param index is to specify which node we want the data of
	 **/
	public T get( int index )
	{
		//Creates a node to hold the node at the index specified
		LinkedListNode<T> node = new LinkedListNode<T>();
		node = getNode(index);
		
		//Gets and returns the data of that node at that index
		return node.getData();
		
	}
 
	/**
	 * Delete data at specific index in list,
	 * e.g., delete( 0 ) removes the first element from the list
	 * @param index is the index at which we are trying to delete the node
	 **/
	public void delete( int index )
	{
		//Checks if the list isn't empty and if the index given is within the bounds of the list size
		if(!isEmpty() && index > -1 && index < size()+1)
		{
			//Checks if the first element is being deleted
			if(index == 0)
			{
				//Checks if the is pointing to another node
				if(head.getNext() != null)
				{
					//Sets the next node in the list as the new head
					head = head.getNext();
				}
				//Else this means the head isn't pointing to anything so there's nothing else in the list so the head can be set to null to delete it
				else
				{
					head = null;
				}
				
			}
			//Checks if the node being deleted is between other nodes
			else if(index > 0 && index < size())
			{
				//Gets and saves the node prior to the one being deleted
				LinkedListNode<T> lastNode = getNode(index - 1);
				//Gets and saves the node being deleted
				LinkedListNode<T> currentNode = getNode(index);
				//Sets the pointer of the previous node to that of the one being deleted so it skips over the node being deleted and goes to the next node
				lastNode.setNext(currentNode.getNext());
			}
			//Checks is the node being deleted is the one at the end of the list
			else if(index == size())
			{
				//Gets and saves the node prior to the one being deleted
				LinkedListNode<T> lastNode = getNode(index - 1);
				//Sets the pointer of the previous node to null so it doesn't point to the last one anymore and is hence not on the list
				lastNode.setNext(null);
			}
		}
	}
 
	/**
	 * Get the number of elements in this list.
	 * @return counter the number of nodes in the list
	 **/
	public int size()
	{
		
		//Creates a temporary node called current node
		LinkedListNode<T> currentNode;
		//Sets this temporary node to the same node as the head
		currentNode = head;
		
		//Initializes a counter variable
		int counter = 0;
		
		//Counts number nodes that aren't null therefore the number of nodes in a list
		while(currentNode != null)
		{
			counter++;
			//Increments the temporary node to the next node it points to
			currentNode = currentNode.getNext();
		}
		
		return counter;
	}
 
	/**
	 * Check if the list is empty.
	 * @return true if the list is empty and false if it's not
 	 **/
	public boolean isEmpty()
	{
		//If the head is null meaning there is no first value, that means the list is empty
		if(head == null)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Creates a string interpretation of the list
	 * @return a string interpretation of the list
	 */
	public String toString()
	{
		//Creates a String that will hold the string interpretation of the list
		String output = "";
		

		//Creates a temporary node called current node
		LinkedListNode<T> currentNode;
		//Sets this temporary node to the same node as the head
		currentNode = head;
		
		//Checks if the head exists
		if(currentNode != null)
		{
			//Cycles through the list
			for(int x = 0; x < size(); x++)
			{
				//Checks if the node has a node after it just so it can add the arrow after the string interpretation of the node
				if(currentNode.getNext() != null)
				{
					output += currentNode.toString() + " -> ";
				}
				//Otherwise it means this node is the last in the list and doesn't need an arrow at the end
				else
				{
					output += currentNode.toString();
				}
				
				//Increments the temporary node to the next node it points to
				currentNode = currentNode.getNext();
			}
		}
		
		return output;
	}

	
}
