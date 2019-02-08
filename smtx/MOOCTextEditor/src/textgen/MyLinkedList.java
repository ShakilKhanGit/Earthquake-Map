package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) throws NullPointerException {
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Adding null is not allowed");
		}
		
		LLNode<E> newNode = new LLNode(element);
		
		newNode.next = tail;
		newNode.prev = newNode.next.prev;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;

		this.size++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO: Implement this method.
		if (index < 0 || index > size-1)
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		
		LLNode <E> currentNode = (LLNode<E>) head.next;
		
		int i = 0;
		while(i < index) {
			currentNode = currentNode.next;
			i++;
		}
			
		return currentNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) throws IndexOutOfBoundsException {
		
		// TODO: Implement this method
		if (element == null)
			throw new NullPointerException("NullPointerException!!!");

		if (index < 0 || index > size-1)
			throw new IndexOutOfBoundsException("Index is out of bounds!!!");
	
		LLNode <E> prevNode = head;
		int i = 0;
		
		while (i < index) {
			prevNode = prevNode.next;
			i++;
		}
		LLNode <E> newNode = new LLNode <E>(element);
		
		newNode.prev = prevNode;
		newNode.next = newNode.prev.next;
		newNode.prev.next = newNode;
		newNode.next.prev = newNode;
		
		this.size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index)  throws IndexOutOfBoundsException {
		// TODO: Implement this method
		if (index < 0 || index > size-1)
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		
		LLNode <E> currentNode = head;
		int i = 0;
		
		while (i <= index) {
			currentNode = currentNode.next;
			i++;
		}
		
		E element = currentNode.data;
		currentNode.next.prev = currentNode.prev;
		currentNode.prev.next = currentNode.next;
			
		this.size--;
		return element;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (element == null)
			throw new NullPointerException("NullPointerException!!!");

		if (index < 0 || index > size-1)
			throw new IndexOutOfBoundsException("Index is out of bounds!!!");
		
		E previousElement = get(index);
		
		LLNode <E> currentNode = head;
		int i = 0;
		
		while (i <= index) {
			currentNode = currentNode.next;
			i++;
		}
		currentNode.data = element;
		
		return previousElement;
	}   
	
	/*public String toString() {
		LLNode <E> currentNode = head.next;
		String s = null;
		
		while(currentNode.next != null) {
			s += (String)currentNode.data + ", ";
			currentNode = currentNode.next;
		}
		
		return s;
	}*/
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	
/*	
	public LLNode(E e, LLNode<E> prevNode, LLNode<E> nextNode) {
		LLNode<E> newNode = new LLNode(e);
		
		newNode.next = nextNode;
		newNode.prev = newNode.next.prev;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
	}
	*/
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
