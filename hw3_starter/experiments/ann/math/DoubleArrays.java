/** DoubleArrays.java defines operations for arrays of double values.
 *  Author:  Joel C. Adams
 *  Version: 1.01, for Java: An Introduction to Computing 1/e.  All Rights Reserved.
 */

package ann.math;

import ann.util.Controller;
import ann.easyio.*;         // Keyboard, Screen

public class DoubleArrays
{
 /** Read values from the Keyboard into an array
  *  Precondition: Keyboard contains an int n,
  *                 followed by n double values.
  *  Input:        the values from Keyboard
  *  Return:       the n input values in a double array
  */
  public static double [] readArray()
  {
    Screen theScreen = new Screen();
    theScreen.print("Enter the number of values you wish to store: ");
    Keyboard theKeyboard = new Keyboard();
    int size = theKeyboard.readInt();       // read n, the number of values

    double [] result = new double[size];    // allocate array of size n

    for (int i = 0; i < size; i++)          // read n values into result
    {
      theScreen.print("Enter value " + i + ": ");
      result[i] = theKeyboard.readDouble();
    }

    return result;
  }

 /** Sum the values in an array of doubles
  *  Receive: double [] array
  *  Return:  the sum of the values in array
  */
  public static double sum(double [] array)
  {
    double result = 0.0;
    for (int i = 0; i < array.length; i++)
      result += array[i];
    return result;
  }

 /** find the average of the values in an array of doubles
  *  Receive:      double [] array
  *  Precondition: array.length > 0.
  *  Return:       the average of the values in array
  */
  public static double average(double [] array)
  {
    if (array.length <= 0)
      Controller.fatal("DoubleArrays.average()", "array is empty!");

    return sum(array) / array.length;
  }

 /** check two arrays for equality
  *  Receive: double [] a1, double [] a2
  *  Return:  true iff a1 and a2 contain exactly the same elements
  */
  public static boolean equals(double [] a1, double [] a2)
  {
    if (a1.length == a2.length)
    {
      for (int i = 0; i < a1.length; i++)
        if (!(a1[i] == a2[i]))
          return false;
     
      return true;
    }
    else
      return false;
  }

}    
