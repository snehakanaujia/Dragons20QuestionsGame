package datastructures;
/**
 * List interface for simplest ADT of sequentially stored data with changing length.
 * 
 * @author astjohn
 *
 * @param <T> a generic placeholder for any non-primitive Object
 * 
 */
public interface List<T> {
 
	/**
	 * Add (insert) data at specific index in list,
	 * e.g., add( 0, data ) inserts data to front/head of list
	 * @param index at which the new element is being added in the list
	 * @param data that is being saved to the element being added to the list
	 **/
	public void add( int index, T data );
 
	/**
	 * Get data stored at specific index in list.
	 * @param index at which the data is stored
	 * @return the data stored at specific index in list
	 **/
	public T get( int index );
 
	/**
	 * Delete data at specific index in list,
	 * e.g., delete( 0 ) removes the first element from the list
	 * @param index at which the element is being deleted in the list
	 **/
	public void delete( int index );
 
	/**
	 * Get the number of elements in this list.
	 * @return number of elements in this list
	 **/
	public int size();
 
	/**
	 * Check if the list is empty.
	 * @return if the list is empty or not
 	 **/
	public boolean isEmpty();
	
}
