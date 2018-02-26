/**
   A class of bags whose entries are stored in a chain of linked nodes.
	The bag is never full.
*/

public class LinkedBag<T> implements BagInterface<T>{


	private class Node 
	{
		private T    data; // Entry in bag
		private Node next; // Link to next node
	
		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
	} // end Node

	
	private Node firstNode;       // Reference to first node
	private int numberOfEntries;

	// Default constructor
	public LinkedBag() 
	{
		firstNode=null;
		numberOfEntries= 0;
	} // end default constructor
	
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries <= 0;
	}

	@Override
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry, firstNode);	
		firstNode = newNode;
		numberOfEntries ++;
		return true;
	}

	@Override
	public T remove() {
		if(!isEmpty()){
			T temp = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries --;
			return temp;
		}
		else{
			return null;
		}
	}

 	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry)
	{
		Node currentNode; 
		
		for (currentNode = firstNode;currentNode != null; currentNode = currentNode.next)
		{
			if (anEntry==currentNode.data)
				return currentNode;
		} // end while
		return currentNode;
	} // end getReferenceTo

	@Override
	public boolean remove(T anEntry) {
        boolean removed = false;
        Node currentNode;
        Node previousNode = null;

        for (currentNode = firstNode; currentNode != null; currentNode = currentNode.next){
            if (anEntry == currentNode.data) {
                if(previousNode == null){
                    firstNode = firstNode.next;
                    numberOfEntries --;
                    removed = true;
                }
                else{
                    previousNode.next = currentNode.next;
                    numberOfEntries --;
                    removed = true;
                }
            }
            previousNode = currentNode;
        }
        return removed;
	}

	@Override
	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
	    int freq = 0;
		for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next){
		    if (anEntry == currentNode.data){
		        freq ++;
            }
        }
		return freq;
	}

	@Override
	public boolean contains(T anEntry) {
		if(getReferenceTo(anEntry)== null) {
            return false;
        }
        else {
		    return true;
        }
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result= (T[])new Object[numberOfEntries];
		int i =0;// index of array
		
		for(Node current = firstNode; current != null; current = current.next){
		    try{
			    result[i] = current.data;
			    i ++;
            }
            catch (ArrayIndexOutOfBoundsException e){
		        System.out.print("Fix This");
            }
        }
		return result;
	}
	
}
