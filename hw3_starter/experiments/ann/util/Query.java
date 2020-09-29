/** Query.java -- a class that provides query methods.
 *  Author:  Joel C. Adams
 *  Version: 1.01, for Java: An Introduction to Computing 1/e.  All Rights Reserved.
 */
package ann.util;

import ann.easyio.*;           // Keyboard, Screen

public class Query 
{
 /** moreValues() queries users if they have more values to enter.
  *  Return: true if user's response is 'y' or 'Y' and false otherwise
  */
  public static boolean moreValues()
  {
    Screen theScreen = new Screen();
    Keyboard theKeyboard = new Keyboard();
    theScreen.print("Do you have more values to enter (y or n)? ");
    char answer = theKeyboard.readChar();
    return (answer == 'y') || (answer == 'Y');
  }

 /** goOn() queries users if they wish to continue.
  *  Return: true if user's response is 'y' or 'Y' and false otherwise
  */
  public static boolean goOn()
  {
    Screen theScreen = new Screen();
    Keyboard theKeyboard = new Keyboard();
    theScreen.print("Do you wish to continue (y or n)? ");
    char answer = theKeyboard.readChar();
    return (answer == 'y') || (answer == 'Y');
  }

 /** done() queries users if they are finshed.
  *  Return: true if user's response is 'y' or 'Y' and false otherwise
  */
  public static boolean done()
  {
    Screen theScreen = new Screen();
    Keyboard theKeyboard = new Keyboard();
    theScreen.print("Are you finished (y or n)? ");
    char answer = theKeyboard.readChar();
    return (answer == 'y') || (answer == 'Y');
  }

}

