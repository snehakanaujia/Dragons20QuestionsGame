package datastructures;
/**
 * Creates the nodes to save and change data and to be added and removed to Lists
 * 
 * @author Sneha Kanaujia
 *
 * @param <T> a generic placeholder for any non-primitive Object
 */
public class LinkedListNode<T> {
	
	private T data;
	private LinkedListNode<T> next;
	
	/**
	 * Set the data stored at this node.
	 * @param data being stored at this node
	 */
	public void setData( T data )
	{
		this.data = data;
	}
	 
	/**
	 * Get the data stored at this node.
	 * @return data stored at this node
	 */
	public T getData()
	{
		return data;
		
	}
	 
	/**
	 * Set the next pointer to passed node.
	 * @param node is the next node in the list that current node should point to
	 */
	public void setNext( LinkedListNode<T> node )
	{
		next = node;
	}
	 
	/**
	 * Get (pointer to) next node.
	 * @return next node in the list
	 */
	public LinkedListNode<T> getNext()
	{
		return next;
		
	}
	 
	/**
	 * Returns a String representation of this node.
	 */
	public String toString()
	{
		return data.toString();
		
	}

}
