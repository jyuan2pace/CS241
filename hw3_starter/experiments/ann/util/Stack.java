/** Stack.java presents a Stack class whose integrity cannot be violated
 *  (unlike Java's Stack class). It is built using Java's standard LinkedList 
 *  class.  It is contained in the package ann.util.
 *  Attribute: A LinkedList to store the stack elements
 *  Methods:   Default constructor to construct an empty stack,
 *             isEmpty(), top(), pop(), push() 
 *  @author Joel Adams
 *  @version 1.01, for Java An Intro to Computing 1e.  All Rights Reserved.
 */

package ann.util;

import java.util.LinkedList;

public class Stack extends Object
{
/** Stack constructor
 *  Postcondition:  Empty stack is constructed.
 */
 public Stack()
 {
   myList = new LinkedList();
 }

/** Check if stack is empty
 *  Return: true if stack is empty, and false otherwise
 */
 public boolean isEmpty()
 {
   return myList.size() == 0;
 }

/** Top operation
 *  Return: Object at the top of the stack; null if stack is empty
 */
 public Object top()
 {
   if (myList.size() > 0)
     return myList.getLast();
   else
     return null;
 }

/** Push operation
 *  Receive:       Object value
 *  Postcondition: value has been added at the top of the stack
 */
 public void push(Object value)
 {
   myList.add(value);
 }

/** Pop operation
 *  Return:        Object at the top of the stack; null if stack is empty
 *  Postcondition: Value at the top of the stack has been removed.
 */
 public Object pop()
 {
   if (myList.size() > 0)
     return myList.removeLast();
   else
     return null;
 }

//--- Attribute variable
 private LinkedList myList;  // top of stack is at the back of myList
}

