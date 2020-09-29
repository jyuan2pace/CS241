/* Prepend2.java compares the time required to prepend 1 values at the end of
 *		An Array based List of size n
 *		A Linked List based List of size n
 *
 *  Author: Charles Hoot, for Hands On Java.
 *  Modified from code by : Joel Adams, for Hands On C++.
 */

import java.util.*;  //ArrayList and LinkedList
import ann.easyio.*;
import ann.util.*;

public class Prepend2 
{


	static Screen theScreen = new Screen();
	static Keyboard theKeyboard = new Keyboard();
	

	public static void main(String args[])
	{
	
		ann.util.Timer theTimer = new ann.util.Timer();         // create a timer
		
		theScreen.print("\nPrepend Timing Test 2:\n"
       			+ " Enter the size of the list to prepend to: ");
		int n = theKeyboard.readInt();

		// Linked List Based List                                            
                                                    
		LinkedList aLinkedList = null;				     //declare it	

		aLinkedList = new LinkedList();         	         // build empty linked list
														 // prepend n values
														 //  to list
														 // start timer
		aLinkedList.add(0, 1);              //  add one value to list
														 // stop timer
		

		theScreen.println("\nPrepending one value to a LinkedList took : "
		   + theTimer.getTime() + " seconds.");

		
		
		// Array Based List  
		ArrayList anArrayList = null;				     //declare it
		anArrayList = new ArrayList(n);                  // build empty list
														 // prepend n values
														 //  to list
														 // start timer
		anArrayList.add(0, 1);              //  add one value to list
														 // stop timer
		
		

		theScreen.println("\nPrepending one value to an ArrayList took : "
		   + theTimer.getTime() + " seconds.");
                                                    
	}
}//end of class


