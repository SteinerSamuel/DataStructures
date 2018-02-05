import java.util.Arrays;

/**
 * @author Steiners
 *
 */

public final class ArrayBag<T> implements BagInterface<T>{

	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY=25;
	
	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag()
	{
		this (DEFAULT_CAPACITY);
	} // end default constructor
	
	
	/** 
	 * Creates an empty bag having a given capacity.
     * @param desiredCapacity  The integer capacity desired.
     */
	public ArrayBag(int desiredCapacity)
	{
		bag=(T[]) new Object[desiredCapacity];
		numberOfEntries=0;
	} // end constructor

	
	
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		if(numberOfEntries > 0){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public boolean add(T newEntry) {
		try{
			bag[numberOfEntries] = newEntry;
			numberOfEntries ++;
			return true;
		}
		catch (ArrayIndexOutOfBoundsException e){
			return false;
		}
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		boolean removed = false;
		for( int i = 0; i < bag.length; i++){			
			if(bag[i] == anEntry){
				bag[i] = null;
				numberOfEntries --;
				removed = true;
			}
		}
		return removed;
	}

	@Override
	public void clear() {
		Arrays.fill(bag, null);
		numberOfEntries = 0;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		for( int i = 0; i < bag.length; i++){			
			if(bag[i] == anEntry){
				frequency ++;
			}
		}
		return frequency;
	}

	@Override
	public boolean contains(T anEntry) {
		for( int i = 0; i < bag.length; i++){			
			if(bag[i] == anEntry){
				return true;
			}
		}
		return false;
	}

	@Override
	public T[] toArray() {
		if(isEmpty()){
			return null;
		}
		else{
			return bag;
		}
	}
	
}
