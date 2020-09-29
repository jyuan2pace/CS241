/** Queue.java presents a Queue of linked nodes built "from scratch"  whose 
 *  integrity cannot be violated (unlike Java's Queue class).  It is 
 *  contained in the package ann.util.
 *  Attribute: SinglyLinkedNodes to store references to the head and tail
 *             of the queuu and an int to store its size
 *  Methods:   Default constructor to construct an empty quwuw,
 *             isEmpty(), front(), add(), remove() 
 *  @author Joel Adams
 *  @version 1.01, for Java, An Intro to Computing 1e. All Rights Reserved.
 */

package ann.util;

import ann.util.SinglyLinkedNode;

public class Queue extends Object
{
/** Queueconstructor
 *  Postcondition:  Empty stack is constructed.
 */
 public Queue()
 {
   myHead = myTail = null;
   mySize = 0;
 }

/** Check if queue is empty
 *  Return: true if queue is empty, and false otherwise
 */
 public boolean isEmpty()
 {
   return mySize == 0;
 }

/** First operation
 *  Return: Object at the front of the queue; null if queue is empty
 */
 public Object first()
 {
   if ( isEmpty() )
     return null;
   else
     return myHead.getValue();
 }

/** Add operation
 *  Receive:       Object value
 *  Postcondition: value has been added at the back of the queue
 */
 public void add(Object obj)
 {
   SinglyLinkedNode newNode = new SinglyLinkedNode(obj);
   if ( isEmpty() )
     myHead = newNode;
   else
     myTail.setSuccessor(newNode);

   myTail = newNode;
   mySize++;
 }

/** Remove operation
 *  Return:        Object at the front of the queue; null if queue is empty
 *  Postcondition: Value at the front of the queue has been removed.
 */
 public Object remove()
 {
   Object result = null;
   if ( !isEmpty() )
   {
     result = myHead.getValue();
     myHead = myHead.getSuccessor();
     mySize--;
   }
   if ( isEmpty() )
     myTail = null;

   return result;
 }                                           

/** Size accessor
 *  Return: number of elements in the queue */
 public int getSize() { return mySize; }



/** Clear accessor
 *  Postcondition: All values have been removed from the queue. */
 public void clear()
 {
   myHead = myTail = null;
   mySize = 0;
 }

//--- String conversion for output purposes ---
 public String toString()
 {
   String result = "";
   for (SinglyLinkedNode current = myHead; 
        current != null; 
        current = current.getSuccessor() )
     result += (" " + current.getValue().toString() );

   return result;
 }

//--- Attribute variables ---
 private SinglyLinkedNode myHead, myTail;
 private int  mySize;
}
