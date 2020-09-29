/* Append2.java compares the time required to append 1 values at the end of
 *		An Array based List of size n
 *		A Linked List based List of size n
 *
 *  Author: Charles Hoot, for Hands On Java.
 *  Modified from code by : Joel Adams, for Hands On C++.
 */

import java.util.*;  //ArrayList and LinkedList
import ann.easyio.*;
import ann.util.*;

public class Append2 
{

	static Screen theScreen = new Screen();
	static Keyboard theKeyboard = new Keyboard();
	public static void main(String args[])
	{

		ann.util.Timer theTimer = new ann.util.Timer();         // create a timer

		theScreen.print("\nAppend Timing Test 2:\n"
       			+ " Enter the size of the list to append to: ");
		int n = theKeyboard.readInt();

		// Linked List Based List                                            
                                                    
		LinkedList aLinkedList = null;				     //declare it	

		aLinkedList = new LinkedList();         	     // build empty linked list
														 // append n values
														 //  to list
														 // start timer
		aLinkedList.add(1);                 			//  add one value to list
														// stop timer
		

		theScreen.println("\nAppending one value to a LinkedList took : "
		   + theTimer.getTime() + " seconds.");

		
		
		// Array Based List
		ArrayList anArrayList = null;				     //declare it
		anArrayList = new  ArrayList(n);                 // build empty list
														 // append n values
														 //  to list

                                                    
		theScreen.println("\nSize of ArrayList before append is : " +
			 anArrayList.size() + ".");
                                                    
	
														 // start timer
		anArrayList.add(1);                    			// add one value to list
														 // stop timer

		theScreen.println("\nSize of ArrayList after append is : " +
			 anArrayList.size() + ".");
                                                    
		
		

		theScreen.println("\n\nAppending one value to an ArrayList took : "
		   + theTimer.getTime() + " seconds.");
                                                    
	}
}//end of class

