/** A Matrix class that contains several useful operations:
 *   constructors, input/output, accessors, mutators, matrix operations
 *  Class Invariant:  myRows >= 0 && myColumns >= 0
 *  Author:  Joel C. Adams
 *  Version: 1.01, for Java: An Introduction to Computing 1/e.  All Rights Reserved.
 */

package ann.math;

import ann.easyio.*;  
import ann.util.Controller;

/** A Matrix class that contains several useful operations:
 *   constructors, input/output, accessors, mutators
 *  Class Invariant:  myRows >= 0 && myColumns >= 0
 */
public class Matrix
{
 //--- Constructors ---
 /** Default constructor
  *  Postcondition: myArray == null && myRows == 0 && myColums == 0
  */
 public Matrix()
 {
  myArray = null;
  myRows = 0;
  myColumns = 0;
 }
 
 /** Explicit-Value Constructor
  *  Receive:       integers rows and columns
  *  Precondition:  rows >= 0 && columns >= 0
  *  Postcondition: myArray is a rows X columns array of doubles &&
  *                 myRows == rows && myColums == columns
  */
 public Matrix(int rows, int columns)
 {
   if (rows < 0)
     Controller.fatal("Matrix.Matrix()", "invalid row parameter");
   else if (columns < 0)
     Controller.fatal("Matrix.Matrix()", "invalid column parameter");
   else
   {
     myArray = new double[rows][columns];
     myRows = rows;
     myColumns = columns;
   }
 }


 //--- Input/Output ---
 /** Input method
  *  Input:         integers rows and columns
  *  Precondition:  rows >= 0 && columns >= 0
  *  Postcondition: myArray is a rows X columns array of doubles &&
  *                 myRows == rows && myColums == columns
  */
 public void read()
 {
    Keyboard myKeyboard = new Keyboard();
    int rows = myKeyboard.readInt();
    int columns = myKeyboard.readInt();
  
    if ( (rows <= 0) || (myRows > 0 && rows != myRows) )
      Controller.fatal("Matrix.read()", "input row value is invalid");
    else if ( (columns <= 0) || (myColumns > 0 && columns != myColumns ) )
      Controller.fatal("Matrix.read()", "input column value is invalid");
    else
    {
      myArray = new double[rows][columns];
  
      for (int r = 0; r < rows; r++)
        for (int c = 0; c < columns; c++)
          myArray[r][c] = myKeyboard.readDouble();
  
      myRows = rows;
      myColumns = columns;
    }
  }
  
 /** To-string converter
  *  Return: a String representation of a matrix
  */
 public String toString()
 {
    String result = "";
  
    for (int r = 0; r < myRows; r++)
    {
      for (int c = 0; c < myColumns; c++)
        result += "\t" + myArray[r][c];
  
      result += "\n";
    }
  
    return result;
  }


 //--- Accessors and Mutators ---
 /** rows accessor
  *  Return: number of rows
  */
 public int rows()
 {
   return myRows;
 }
 
 /** columns accessor
  *  Return: number of columns
  */
 public int columns()
 {
   return myColumns;
 }

 /** Matrix element mutator
  *  Receive:       integers row and column, a double value
  *  Postcondition: myArray[row][column] == value
  */
 public void setElement(int row, int column, double value)
 {
   if (! isValid(row, column))
     Controller.fatal("Matrix.setElement()", 
                       "invalid [row][column] parameters");
 
   myArray[row][column] = value;
 }
 
 /** Matrix element accessor
  *  Receive: integers row and column
  *  Return:  myArray[row][column] == value
  */
 public double getElement(int row, int column)
 {
   if (! isValid(row, column))
     Controller.fatal("Matrix.getElement()", 
                      "invalid [row][column] parameters: ["
                      + row + "][" + column + "]");
 
   return myArray[row][column];
 }

 /** Private utility function to validate indices
  *  Receive: integers row and column
  *  Return:  true if the values of row and column are valid,
  *            false otherwise
  */
 private boolean isValid(int row, int column)
 {
   return 0 <= row && row < myRows
          && 0 <= column && column < myColumns;
 }
 

 //--- Matrix operations ---
 /** Matrix multiplication
  *  Receive:      Matrix mat2
  *  Precondition: # columns in current matrix == # rows in mat2
  *  Return:       product of current matrix with mat2 
  */
 public Matrix times(Matrix mat2)
 {
   if (columns() != mat2.rows())
     Controller.fatal("Matrix.times()", "myColumns: " + myColumns 
                      + " != mat2.rows(): " + mat2.rows());
 
   Matrix mat3 = new Matrix(myRows, mat2.columns());
 
   for (int i = 0; i < myRows; i++)
     for (int j = 0; j < mat2.columns(); j++)
     {
        double sum = 0.0;
        for (int k = 0; k < myColumns; k++)
          sum += myArray[i][k] * mat2.getElement(k, j);
        mat3.setElement(i, j, sum);
     }
 
   return mat3;
 }

 //--- Attributes ---
   private int         myRows;
   private int         myColumns;
   private double [][] myArray;
}
  
  
 
