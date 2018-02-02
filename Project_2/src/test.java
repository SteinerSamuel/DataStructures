public class test {
	public static void main(String[] args){
		String[] contentsOfBag = {"One", "One", "Two", "One", "Three", "One"};
		BagInterface<String> aBag = new ArrayBag<>(contentsOfBag.length);
	    System.out.println("Testing an initially empty bag:");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    testIsEmpty(aBag, true);
	    
	    System.out.println("Adding " + contentsOfBag.length +
                " strings to an initially empty bag with" +
                " the capacity to hold more than " +
                contentsOfBag.length + " strings:");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    testAdd(aBag, contentsOfBag);
	    aBag.clear();
	    testIsEmpty(aBag, true);
	}
	
	private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult)
	{
      System.out.print("Testing isEmpty with ");
      if (correctResult)
         System.out.println("an empty bag:");
      else
         System.out.println("a bag that is not empty:");
      
      System.out.print("isEmpty finds the bag ");
      if (correctResult && aBag.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aBag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
		System.out.println();
	} // end testIsEmpty
	
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
         System.out.print(content[index] + " ");
		} // end for
      System.out.println();
      
	displayBag(aBag);
	} // end testAdd
	
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
}
