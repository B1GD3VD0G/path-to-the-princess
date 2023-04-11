package model;

/**
 * This class makes a SinglyLinkedList.
 * SLLs have a head and tail reference, but are only able to be iterated through from the front.
 * 
 * @author Devin Peevy
 * @version 1.0
 * @param <T> The type of element which the Nodes in this SLL will store.
 */
public class SLL<T> {

	/** The first node of this SLL. */
	private Node head;
	
	/** The last node of this SLL. */
	private Node tail;
	
	/** The amount of Nodes in this SLL. */
	private int count;
	
	/**
	 * This constructor creates a new, empty SLL.
	 */
	public SLL() {
		head = null;
		tail = null;
		count = 0;
	}
	
	/**
	 * This method adds a new Node to the front of the SLL.
	 * Updates the head and count of SLL.
	 * 
	 * @param elem The element being stored in the new Node.
	 */
	public void addFront(T elem) {
		//Make a new Node storing the element.
		Node newNode = new Node(elem);
		//If there's already elements in this SLL, reference the head so we don't lose it.
		if (count > 0) {
			newNode.next = head;
		} else {
			//If this is the only element, it should be labeled as the tail as well.
			tail = newNode;
		}
		//This is the new head.
		head = newNode;
		//Add 1 Node.
		count++;
	}
	
	/**
	 * This method adds an element to the end of the SLL.
	 * Updates tail and count of SLL.
	 * 
	 * @param elem The element which the new Node will store.
	 */
	public void addRear(T elem) {
		//Make a new Node storing the element.
		Node newNode = new Node(elem);
		//If there's already elements in this list, link the last Node to this one.
		if (count > 0) {
			tail.next = newNode;
		} else {
			//If this is the only element, it should be labeled as the head as well.
			head = newNode;
		}
		//This new Node is now the tail.
		tail = newNode;
		//Add 1 Node.
		count++;
	}
	
	/**
	 * This method adds a node referencing a new Element to a desired index in the SLL.
	 * Updates count, and head or tail when necessary.
	 * 
	 * @throws IllegalArgumentException if the index is not valid.
	 * @param index The index at which this new element will be placed.
	 * @param elem The element which this new Node will be referencing.
	 */
	public void add(int index, T elem) {
		//Check to see if the index is valid. 
		//Check if we're actually adding to front or back.
		if (index > count || index < 0) {
			throw new IllegalArgumentException("The given index is not valid.");
		} else if (index == count) {
			addRear(elem);
		} else if (index == 0) {
			addFront(elem);
		} else { //If no special conditions apply:
			//Make a new Node storing the element.
			Node newNode = new Node(elem);
			//Create a reference to iterate through each of the nodes in the list.
			Node currentNode = head;
			//Iterate through the SLL, from the beginning, to get to the desired index (i = index - 1).
			for (int i = 1; i < index; i++) {
				currentNode = currentNode.next;
			}
			//Make new Node refer to the one after it, so it doesn't get lost.
			newNode.next = currentNode.next;
			//Now place new Node in the correct spot in the list by referring to it from current Node.
			currentNode.next = newNode;
			//Add 1 Node.
			count++;
		}
	}
	
	/**
	 * This method deletes an element in the list.
	 * Updates count, and head and tail when necessary.
	 * 
	 * @throws IllegalArgumentException if the index is not valid.
	 * @param index The index which is to be deleted from the list.
	 * @return The element of the deleted Node.
	 */
	public T delete(int index) {
		//Check to see if index is valid.
		if (index >= count || index < 0) {
			throw new IllegalArgumentException("The given index is not valid.");
		}
		
		//Create a new node to be able to reference the Nodes up to the index.
		Node currentNode = head;
		//Iterate through the Nodes until you are at the index before the Node to delete.
		for (int i = 1; i < index; i++) {
			currentNode = currentNode.next;
		}
		//Save the element of the deleted node to be able to return it.
		T element = currentNode.next.element;
		//Special case if it is the last Node in the SLL
		if (index == count - 1) {
			tail = currentNode;
			currentNode.next = null;
		} else if (index == 0) {
			//Special case if it is the first Node in the SLL.
			head = currentNode.next;
		} else {
			//Otherwise, just skip over the Node and remove any chance of referencing it.
			currentNode.next = currentNode.next.next;
		}
		//Remove 1 Node
		count--;
		//Return the element of the deleted Node.
		return element;
	} 
	
	/**
	 * This method returns the element of the node at a desired index.
	 * 
	 * @throws IllegalArgumentException if the index is not valid.
	 * @param index The index of the desired Node.
	 * @return The element of the Node at the parameter index.
	 */
	public T get(int index) {
		//Check for valid index.
		if (index >= count || index < 0) {
			throw new IllegalArgumentException("The given index is not valid.");
		}
		//Create a reference Node to iterate through the SLL.
		Node currentNode = head;
		//Iterate through the SLL until you are at the desired index.
		for (int i = 1; i <= index; i++) {
			currentNode = currentNode.next;
		}
		//Return the element of the desired index.
		return currentNode.element;
	}

	public Node getHead() {
		return this.head;
	}

	public int getCount() {
		return this.count;
	}
	
	/**
	 * This method handles the swapping of two Nodes within the SLL.
	 * 
	 * @param index1 The first index which should be switched.
	 * @param index2 The second index which should be switched.
	 */
	public void swap(int index1, int index2) {
		//Check for input that doesn't make sense. 
		//If indices are in reverse order, run it again so index1 < index2.
		//If an index is not valid, throw an exception.
		//If the indices are equal, do nothing.
		if (index1 > index2) {
			swap(index2, index1);
		} else if(index1 < 0 || index2 >= count ) {
			throw new IllegalArgumentException("Both indices must be between 0 and " + (count - 1));
		}else if (index1 == index2) {
			return;
		}
		//Check for valid input that has special conditions.
		//There are 3 special conditions which require special methods.
		//(1) The indices are next to each other
		//(2) index1 is 0
		//(3) Both (1) and (2)
		if (index2 == 1 && index1 == 0) {
			swapHeadNeighbors();
		} else if(index2 - index1 == 1) {
			swapNeighbors(index1);
		} else if (index1 == 0) {
			swapHead(index2);
		} else {
			//Iterate through the array until nodeB is at index2 - 1.
			//If nodeB is at index1 - 1, move nodeA there.
			Node nodeA = head;
			Node nodeB = head;
			for (int i = 1; i < index2; i++) {
				nodeB = nodeB.next;
				if (i == index1 - 1) {
					nodeA = nodeB;
				}
			}
			//Is the node at index2 the tail?
			if (index2 == count - 1) {
				tail = nodeA.next;
			}
			//Rearrange:
			Node saveNode = nodeA.next.next;
			nodeA.next.next = nodeB.next.next;
			nodeB.next.next = saveNode;
			saveNode = nodeA.next;
			nodeA.next = nodeB.next;
			nodeB.next = saveNode;
		}
	}

	/**
	 * This method tells if the SLL is empty.
	 *
	 * @return true if it is empty; else false.
	 */
	public boolean isEmpty() {
		return (count == 0);
	}
	
	/**
	 * This private helper method is called by swap(x, x + 1)
	 * 
	 * @param index1 The first index which is being swapped.
	 */
	private void swapNeighbors(int index1) {
		Node nodeA = head;
		Node nodeB = head;
		//Iterate nodeA to index1 - 1, nodeB to index1 + 1 (which would be index2)
		for (int i = 1; i <= index1 + 1; i++) {
			nodeB = nodeB.next;
			if(i == index1 - 1) {
				nodeA = nodeB;
			}
		}
		//Is the second index the tail?
		if (index1 == count - 2) {
			tail = nodeA.next;
		}
		//Rearrange:
		nodeA.next.next = nodeB.next;
		nodeB.next = nodeA.next;
		nodeA.next = nodeB;
	}
	
	/**
	 * This private helper method is called by swap(0, x > 1).
	 * 
	 * @param index2 The second index which is being swapped.
	 */
	private void swapHead(int index2) {
		//iterate to index2 - 1.
		Node node = head;
		for (int i = 1; i < index2; i++) {
			node = node.next;
		}
		//Is index2 the tail?
		if (index2 == count - 1) {
			tail = head;
		}
		//Rearrange:
		Node saveNode = head.next;
		head.next = node.next.next;
		node.next.next = saveNode;
		saveNode = node.next;
		node.next = head;
		head = saveNode;
	}
	
	/**
	 * This private helper method is run when swap(0, 1) is run.
	 */
	private void swapHeadNeighbors() {
		Node nodeA = head.next;
		head.next = nodeA.next;
		nodeA.next = head;
		head = nodeA;
		//Does tail need to be updated as well?
		if (count == 2) {
			tail = head.next;
		}
	}
	
	/**
	 * This method returns a String representation of this SLL.
	 * The elements will be represented however their toString() method works.
	 * The string is formatted "[element1, element2, ..., elementN]".
	 * This method is limited to representing an average of 10 letters per Node.
	 * 
	 * @return a String representation of this DLL.
	 */
	public String toString() {
		int charLimit = 12 * count + 2;
		StringBuilder sb = new StringBuilder(charLimit);
		sb.append("[");
		Node currentNode = head;
		for (int i = 0; i < count; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(currentNode.toString());
			currentNode = currentNode.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * This inner class is for the individual nodes of the SLL class.
	 * 
	 * @author Devin Peevy
	 * @version 1.0
	 */
	class Node {
		/**
		 * The element stored in this Node.
		 */
		final private T element;

		/**
		 * The Node after this Node. Null if this Node is the last.
		 */
		private Node next;

		/**
		 * This constructor makes a new Node object storing an element.
		 *
		 * @param theElem the element to be stored in this new Node.
		 */
		public Node(T theElem) {
			element = theElem;
			next = null;
		}

		/**
		 * This method returns a String representation of the element stored in this Node.
		 */
		public String toString() {
			return element.toString();
		}

		public Node getNext() {
			return this.next;
		}
	}
}
