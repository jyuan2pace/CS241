/** Screen.java -- a class to simplify Java output.
 *
 *  Author:  Joel C. Adams
 *  Version: 1.01, for Java: An Introduction to Computing 1/e.  All Rights Reserved.
 */

package ann.easyio;

import java.text.*;      // NumberFormat, DecimalFormat

public class Screen extends Object
{

 /** Default Screen constructor
  *  Returns nothing, but I am ready for use.
  */
 public Screen()
 {} 
  
 /** println() displays a newline.
  *  Precondition:  System.out is open;
  *  Postcondition: a newline has been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen println()
 {
   System.out.println();
   return this;
 } 

 /** print(Object) displays an object using its toString() method.
  *  Precondition:  obj has defined method toString()
  *  Postcondition: obj's String representation has been displayed.
  *  Return:        the receiver
  */
 public Screen print(Object obj)
 {
   System.out.print(obj.toString());
   return this;
 } 
  

 /** println(Object) displays an object using its toString() method.
  *  Precondition:  obj has defined method toString()
  *  Postcondition: obj's String representation has been displayed,
  *                   followed by a newline.
  *  Return:        the receiver
  */
 public Screen println(Object obj)
 {
   System.out.println(obj.toString());
   return this;
 } 
  
 /** print(char) displays a char.
  *  Precondition:  System.out is open;
  *                   value is a char.
  *  Postcondition: value has been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen print(char value)
 {
   System.out.print(value);
   return this;
 } 
  
 /** println(char) displays a char followed by a newline.
  *  Precondition:  System.out is open;
  *                   value is a char.
  *  Postcondition: value and a newline have been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen println(char value)
 {
   System.out.println(value);
   return this;
 } 
  
 /** print(string) displays a string.
  *  Precondition:  System.out is open;
  *                   value is a string.
  *  Postcondition: value has been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen print(String value)
 {
   System.out.print(value);
   return this;
 } 
  
 /** println(string) displays a string followed by a newline.
  * Precondition:  System.out is open;
  *                  value is a string.
  *  Postcondition: value and a newline have been appended to System.out.
  * Return:        the receiver
  */ 
 public Screen println(String value)
 {
   System.out.println(value);
   return this;
 } 
  
 /** print(boolean) displays a boolean.
  *  Precondition:  System.out is open;
  *                   value is a boolean.
  *  Postcondition: value has been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen print(boolean value)
 {
   System.out.print(value);
   return this;
 } 
  
 /** println(boolean) displays a boolean followed by a newline.
  *  Precondition:  System.out is open;
  *                   value is a boolean.
  *  Postcondition: value and a newline have been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen println(boolean value)
 {
  System.out.println(value);
  return this;
 } 
  
 /** print(byte) displays a byte.
  *  Precondition:  System.out is open;
  *                   value  is a byte.
  *  Postcondition: value has been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen print(byte value)
 {
   System.out.print(value);
   return this;
 } 
  
 /** println(byte) displays a byte followed by a newline.
  *  Precondition:  System.out is open;
  *                   value  is a byte.
  *  Postcondition: value and a newline have been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen println(byte value)
 {
   System.out.println(value);
   return this;
 } 

 /** print(short) displays a short.
  *  Precondition:  System.out is open;
  *                   value is a short.
  *  Postcondition: value has been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen print(short value)
 {
   System.out.print(value);
   return this;
 } 
  
 /** println(short) displays a short followed by a newline.
  *  Precondition:  System.out is open;
  *                   value is a short.
  *  Postcondition: value and a newline have been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen println(short value)
 {
   System.out.println(value);
   return this;
 } 

 /** print(int) displays an int.
  *  Precondition:  System.out is open;
  *                   value is an int.
  *  Postcondition: value has been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen print(int value)
 {
   System.out.print(value);
   return this;
 } 
  
 /** println(int) displays an int followed by a newline.
  *  Precondition:  System.out is open;
  *                   value is an int.
  *  Postcondition: value and a newline have been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen println(int value)
 {
   System.out.println(value);
   return this;
 } 

 /** print(long) displays a short.
  *  Precondition:  System.out is open;
  *                   value is a long.
  *  Postcondition: value has been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen print(long value)
 {
   System.out.print(value);
   return this;
 } 
  
 /** println(long) displays a long followed by a newline.
  *  Precondition:  System.out is open;
  *                   value is a long.
  *  Postcondition: value and a newline have been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen println(long value)
 {
   System.out.println(value);
   return this;
 } 
  
 /** print(float) displays a float.
  *  Precondition:  System.out is open;
  *                   value is a float.
  *  Postcondition: value has been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen print(float value)
 {
   System.out.print(value);
   return this;
 } 
  
 /** println(float) displays a float followed by a newline.
  *  Precondition:  System.out is open;
  *                   value is a float.
  *  Postcondition: value and a newline have been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen println(float value)
 {
   System.out.println(value);
   return this;
 } 
    
 /** print(double) displays a double.
  *  Precondition:  System.out is open;
  *                   value is a double.
  *  Postcondition: value has been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen print(double value)
 {
   System.out.print(value);
   return this;
 } 
  
 /** println(double) displays a double followed by a newline.
  *  Precondition:  System.out is open;
  *                   value is a double.
  *  Postcondition: value and a newline have been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen println(double value)
 {
   System.out.println(value);
   return this;
 } 

 /** printFormatted(double) displays a double using the default format.
  *  Receive:       value, a double.
  *  Precondition:  System.out is open;
  *                   value is a double.
  *  Postcondition: value has been appended to System.out.
  *  Return:        the receiver
  */ 
 public Screen printFormatted(double value)
 {
   System.out.print(defaultFormat.format(value));
   return this;
 } 

 /** printFormatted(double, int) displays a double with a given number 
  *    of decimal digits.
  *  Receive:       value, a double, decimalDigits, an int.
  *  Precondition:  System.out is open; value is a double; decimalDigits > 0.
  *  Postcondition: value has been appended to System.out, with decimalDigits
  *                   right of the decimal.
  *  Return:        the receiver
  */ 
 public Screen printFormatted(double value, int decimalDigits)
 {
   DecimalFormat newFormat = new DecimalFormat();
   if (decimalDigits > 0)
   {
     newFormat.setMinimumFractionDigits(decimalDigits);
     newFormat.setMaximumFractionDigits(decimalDigits);
   } 
   System.out.print(newFormat.format(value));
   return this;
 } 

 /** printFormatted(double, int, int) displays a double with a given number of 
  *    places left and right of the decimal.
  *  Receive:       value, a double; integerPlaces, an int; 
  *                    decimalDigits, an int
  *  Precondition:  System.out is open; integerPlaces > 0 && decimalDigits > 0.
  *  Postcondition: value has been appended to System.out, with integerPlaces 
  *                   left of the decimal (leading zeros replaced by blanks),
  *                   and decimalDigits to the right of the decimal.
  *  Return:        the receiver
  */ 
 public Screen printFormatted(double value, int integerPlaces, 
                             int decimalDigits)
 {
   return printFormatted(value, integerPlaces, decimalDigits, ' ');
 } 

 /** printFormatted(double, int, int, char) displays a double with a given 
  *    number of integer and decimal places.
  *  Receive:       value, a double;  integerDigits, an int; 
  *                   decimalDigits, an int; fillChar, a char.
  *  Precondition:  System.out is open; integerPlaces > 0 && decimalDigits > 0.
  *  Postcondition: value has been appended to System.out, with integerDigits 
  *                   left of the decimal(leading zeros and separators replaced  
  *                   by fillChar), and decimalDigits to the right of 
  *                   the decimal.
  *  Return:        the receiver
  */ 
 public Screen printFormatted(double value, int integerDigits, 
                             int decimalDigits, char fillChar)
 {
   DecimalFormat newFormat = new DecimalFormat();
   if (integerDigits > 0 && decimalDigits > 0)
   {
     newFormat.setMinimumIntegerDigits(integerDigits);
     newFormat.setMinimumFractionDigits(decimalDigits);
     newFormat.setMaximumFractionDigits(decimalDigits);
   } 

   String stringValue = newFormat.format(value);
   char decimalSymbol =
                     newFormat.getDecimalFormatSymbols().getDecimalSeparator();
   int leastSignificantIntPosition = stringValue.indexOf(decimalSymbol)-1;
   StringBuffer formattedValue = new StringBuffer(stringValue);
   char thousandsSeparator = 
                     newFormat.getDecimalFormatSymbols().getGroupingSeparator(),
        ch;
   for (int i = 0; i < leastSignificantIntPosition; i++)
   {
     ch = formattedValue.charAt(i);
     if (ch != '0' && ch != thousandsSeparator) break;
     formattedValue.setCharAt(i, fillChar);
   } 

   System.out.print(formattedValue);
   return this;
 } 
 

 private static DecimalFormat defaultFormat = new DecimalFormat();
} 
