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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		Arrays.fill(bag, null);
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
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
