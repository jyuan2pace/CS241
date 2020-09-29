/* Append1.java compares the time required to append n values at the end of *		An Array based List *		A Linked List based List * *  Author: Charles Hoot, for Hands On Java. *  Modified from code by : Joel Adams, for Hands On C++. */import java.util.*;  //ArrayList and LinkedListimport ann.easyio.*;import ann.util.*;public class Append1 {	static Screen theScreen = new Screen();	static Keyboard theKeyboard = new Keyboard();	public static void main(String args[])	{		ann.util.Timer theTimer = new ann.util.Timer();                        // create a timer			theScreen.print("\nAppend Timing Test 1:\n"       		+ " Enter the number of values you want to append: ");		int n = theKeyboard.readInt();		// Linked List Based List                                                                                                		LinkedList aLinkedList = null;				     //declare it			aLinkedList = new LinkedList();         	     // build empty linked list		theTimer.start();                                // start timer		for (int i = 0; i < n; i++)                      // append n values			aLinkedList.add(i);             //  to list		theTimer.stop();                                 // stop timer		theScreen.println("\nAppending " + n             // display time       + " values to a LinkedList took : "       + theTimer.getTime() + " seconds.");			// Array Based List		ArrayList anArrayList = null;				     // declare it		anArrayList = new ArrayList((int) n);            // build empty list		theTimer.start();                                // start timer		for (int i = 0; i < n; i++)                      // append n values			anArrayList.add(i);             //  to list		theTimer.stop();                                 // stop timer		theScreen.println("\nAppending " + n              // display time		   + " values to an ArrayList took : "		   + theTimer.getTime() + " seconds.");                                                    	}}//end of class