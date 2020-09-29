/** Keyboard.java defines Keyboard, a class to simplify Java command-line input.
 *  Author:  Joel C. Adams
 *  Version: 1.01; for Java: An Introduction to Computing 1/e.  All Rights Reserved.
 *  Version History:
 *       Version 1.01 changes the argument to BufferedReader mark()
 *         in EatWhiteSpace() and peek() to handle Windows newlines.
 */

package ann.easyio;

import java.io.*;                                  // BufferedReader, ...

public class Keyboard extends Object
{
  /** Keyboard constructor
   *  Returns nothing, but I am initialized for use.
   */
  public Keyboard()
  {} 
  
  /** getChar retrieves the next char, white space or not.
   *  Precondition:  System.in is open.
   *  Postcondition: The read position has been advanced 1 char.
   *  Return:        the next character, white space or not.
   */  
  public char getChar()
  {
    int myValue = 0;
    try
    {
      myValue = myReader.read();
    } 
    catch (IOException e)
    {
      System.out.println(e);
    } 
  
    return (char) myValue;
  }    
    
  /** peekChar looks at the next char without reading it
   *  Precondition:  System.in is open.
   *  Postcondition: The read position has not advanced.
   *  Return:        the character in front of the read position.
   */
  public char peekChar()
  {
    int myValue = 0;
    try
    {
      myReader.mark(2);            // mark current read-position
      myValue = myReader.read();   // read a char
      myReader.reset();            // reset read-position to mark
    } 
    catch (IOException e)
    {
      System.out.println(e);
    } 
    
    return (char) myValue;
  } 

  /** EatWhiteSpace consumes white space chars
   *  Precondition:  0 or more white space chars lie before the read position.
   *  Postcondition: 0 white space chars lie before the read position.
   */
  public static void EatWhiteSpace()
  {
    int ch;
  
    try
    {
      for (;;)
      {
        myReader.mark(2);          // set mark in buffer
        ch = myReader.read();      // read a char
        if (ch < 1)                // if EOF, quit
          break;
        if (!java.lang.Character.isWhitespace((char)ch))
        {
          myReader.reset();        // if non-WS, move back to mark & quit
          break;
        } 
      } 
    } 
    catch (IOException e)
    {
      System.out.println(e);
    } 
  } 

  /** readChar reads the next non-white-space char.
   *  Precondition:  System.in is open and contains a non-white-space char.
   *  Postcondition: The read position has advanced beyond the next
   *                   non-white-space character.
   *  Return:        the next non-white-space character.
   */
  public char readChar()
  {
    EatWhiteSpace();               // eat leading white space
    return getChar();              // read the next char
  } 
  
  /** readWord reads the next 'word' (delimited by white space).
   *  Precondition: System.in is open and contains a 'word'.
   *  Postcondition: The read position has advanced beyond the next unbroken
   *                   sequence of non-white-space chars 
   *                   (skipping any leading white space).
   *  Return:        the next unbroken sequence of non-white-space chars.
   */
  public String readWord()
  {
    int ch;                        // input variable
    String myValue = "";           // myValue is initially empty
 
    this.EatWhiteSpace();          // eat leading white space
 
    for (;;)
    {
      ch = this.peekChar();        // check out next char
      if (ch < 1 || java.lang.Character.isWhitespace((char)ch)) 
        break;
      ch = this.getChar();
      myValue += (char) ch;        // append it to myValue
    } 
  
    return myValue;
}
  
  /** readLine reads from the read position until the next newline.
   *  Precondition:  System.in is open.
   *  Postcondition: The read position has advanced beyond the next 
   *                   newline char.
   *  Return:        the sequence of chars from the read position to 
   *                   that newline.
   */
   
  public String readLine()
  {
    String myValue = "";
    try
    {
      myValue = myReader.readLine();
    }  
    catch (IOException e)
    {
      System.out.println(e);
    } 
    
    return myValue;
  } 
  
  /** readBoolean tries to read the next word as a boolean value.
   *        
   *  Precondition:  System.in is open.
   *  Postcondition: The read position has advanced beyond the next word.
   *  Return:         the boolean equivalent of the next word
   *                    (true, TRUE, tRuE, ... == true; anything else == false).
   */
  public boolean readBoolean()
  {
    myString = readWord();
    return new Boolean(myString).booleanValue();
  } 
  
  /** readByte tries to read the next word as a byte-integer value.
   *  Precondition:  System.in is open and contains a byte value.
   *  Postcondition: The read position has advanced beyond the next word.
   *  Return:        the byte-int-equivalent of the next word.
   */
  public byte readByte()
  {
    myString = readWord();
    return Byte.parseByte(myString);
  } 
          
  /** readShort tries to read the next word as a short-integer value.
   *  Precondition:  System.in is open and contains a short value.
   *  Postcondition: The read position has advanced beyond the next word.
   *  Return:        the short-int-equivalent of the next word.
   */
  public short readShort()
  {
    myString = readWord();
    return Short.parseShort(myString);
  } 
          
  /** readInt tries to read the next word as an integer value.
   *  Precondition:  System.in is open and contains a base-10 int value.
   *  Postcondition: The read position has advanced beyond the next word.
   *  Return:        the int equivalent of the next word.
   */
  public int readInt()
  {
    myString = readWord();
    return Integer.parseInt(myString);
  } 
  
  /** readOctalInt tries to read the next word as an octal integer value.
   *  Precondition:  System.in is open and contains a base-8 int value.
   *  Postcondition: The read position has advanced beyond the next word.
   *  Return:        the base-8 int equivalent of the next word.
   */
  public int readOctalInt()
  {
    myString = readWord();
    return Integer.parseInt(myString, 8);
  } 
  
  /** readHexInt tries to read the next word as a hexadecimal integer value.
   *  Precondition:  System.in is open and contains a base-16 int value.
   *  Postcondition:  The read position has advanced beyond the next word.
   *  Return:        the base-16 int equivalent of the next word.
   */
  public int readHexInt()
  {
    myString = readWord();
    if (myString.length() >= 2 && myString.charAt(0) == '0' 
                             && myString.charAt(1) == 'x')
    return Integer.parseInt(myString.substring(2), 16);
    else
      return Integer.parseInt(myString, 16);
  } 
  
  /** readLong tries to read the next word as a long-int value.
   * Precondition:: System.in is open and contains a long value.
   * Postcondition:  The read position has advanced beyond the next word.
   * Return:       the long-int equivalent of the next word.
   */
  public long readLong()
  {
    myString = readWord();
    return Long.parseLong(myString);
  } 
  
  /** readFloat tries to read the next word as a float value.
   *  Precondition:  System.in is open and contains a float value.
   *  Postcondition: The read position has advanced beyond the next word.
   *  Return:        the float equivalent of the next word.
   *  NOTE: In earlier versions of Java that don't support parseFloat(),
   *        replace the return statement by:
   *           return Float.valueOf(myString).floatValue();
   */
  public double readFloat()
  {
    myString = readWord();
    return Float.parseFloat(myString);     
  } 
  
  /** readDouble tries to read the next word as a double value.
   *  Precondition:  System.in is open and contains a double value.
   *  Postcondition: The read position has advanced beyond the next word.
   *  Return:        the double equivalent of the next word.
   *  NOTE: In earlier versions of Java that don't support parseDouble(),
   *        replace the return statement by:
   *           return Double.valueOf(myString).doubleValue();
   */
  public double readDouble()
  {
    myString = readWord();
    return Double.parseDouble(myString);
  } 
  
  private static BufferedReader  myReader = new BufferedReader(
                                            new InputStreamReader(
                                                  System.in));;
  private static String          myString = "";

} 
