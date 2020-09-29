/** SinglyLinkedNode.java defines a class for singly linked nodes.
 *  Attributes: myValue to store a queue element
 *              mySuccessor to refer to the next node
 *  Methods:    constructors -- build a node to store a particular
 *              object and a handle for the successor (default null);
 *              accessors and mutators
 *  @author Joel Adams
 *  @version 1.01, for Java An Intro To Computing 1e.  All Rights Reserved.
 */
 
package ann.util;

public class SinglyLinkedNode
{
 //--- Constructors ---
 /** Construct a node containing a given Object and having a given successor
  *  Receive:       Object value and SinglyLinkedNode successor
  *  Postcondition: myValue == value and mySuccessor == successor
  */
  public SinglyLinkedNode(Object value, SinglyLinkedNode successor)
  {
    myValue = value;
    mySuccessor = successor;
  }

 /** Construct a node containing a given Object
  *  Receive:       Object value 
  *  Postcondition: myValue == value and mySuccessor == null
  */
  public SinglyLinkedNode(Object value)
  {
    this(value, null);
  }

 //--- Accessors and mutators---
 /** Access value stored in a node
  *  Return: myValue */
  public Object getValue()               { return myValue; }

 /** Access successor of a node
  *  Return: mySuccessor */
  public SinglyLinkedNode getSuccessor() { return mySuccessor; }

 /** Change value stored in a node
  *  Receive:       newValue
  *  PostCondition: myValue == newValue */
  public void setValue(Object newValue)
  { myValue = newValue; }

 /** Change successor of a node
  *  Receive:       newSuccessor
  *  PostCondition: mySuccessor == newSuccessor */
  public void setSuccessor(SinglyLinkedNode newSuccessor)
  { mySuccessor = newSuccessor; }

 //--- Attribute variables ---
  private SinglyLinkedNode mySuccessor;
  private Object           myValue;
}
