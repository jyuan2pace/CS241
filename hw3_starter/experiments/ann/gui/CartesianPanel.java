/** CartesianPanel.java is a widget for Cartesian systems.
 *  Author:  Joel C. Adams
 *  Version: 1.01, for Java: An Introduction to Computing 1/e.  All Rights Reserved.
 */

package ann.gui;

import java.awt.*;                          // Graphics, ...
import javax.swing.*;                       // JPanel, ...
import java.text.DecimalFormat;

public class CartesianPanel extends JPanel
{
 public final static int AXIS_MARGIN = 32,  // rows/columns at edge of axis
                         AXIS_GAP = 50;     // rows/columns btwn axis markings

 /** Default constructor
  *  Postcondition: I have been initialized:
  *                   lower-left  == (-4.0, -4.0);
  *                   upper-right == (4.0, 4.0).
  */
 public CartesianPanel()
 {
  this(-4.0, -4.0, 4.0, 4.0);
 }


 /** Explicit Point constructor
  *  Receive:       lowerLeft, upperRight, two Point values.
  *  Postcondition: I have been initialized:
  *                   lower-left  == lowerLeft;
  *                   upper-right == upperRight.
  */
public CartesianPanel(Point lowerLeft, Point upperRight)
 {
   this(lowerLeft.x, lowerLeft.y, upperRight.x, upperRight.y);
 }


 /** Explicit coordinate constructor
  *  Receive:       minX, minY, maxX, maxY, four double values.
  *  Postcondition: I have been initialized:
  *                   lower-left  == (minX, minY);
  *                   upper-right == (maxX, maxY).
  */
public CartesianPanel(double minX, double minY, double maxX, double maxY)
 {
   xMin = minX; yMin = minY;
   xMax = maxX; yMax = maxY;
   myXRange = xMax - xMin;
   myYRange = yMax - yMin;
   mySizeFactor = 400;

   int width, height;
   if (myXRange < myYRange)
   {
     width = round(mySizeFactor * myXRange / myYRange) + 2 * AXIS_MARGIN;
     height = mySizeFactor + 2 * AXIS_MARGIN;
   }
   else
   {  
     width = mySizeFactor + 2 * AXIS_MARGIN; 
     height = round(mySizeFactor * myYRange / myXRange) + 2 * AXIS_MARGIN;
   }
 
   setSize(width, height);
   setPreferredSize( new Dimension(width, height) );
   setMaximumSize( new Dimension(width, height) );
          
   setSizeDependentAttributes();
   myFormatter.setMaximumFractionDigits(3);
   myFormatter.setMinimumFractionDigits(1);
   myFormatter.setPositivePrefix("+");
 }

 /** Utility to initialize size-dependent attributes
  *  Precondition: I have a height accessible via getHeight(),
  *                 and a width accessible via getWidth().
  *  Postcondition: My size-dependent attributes: 
  *                   myRows, myLastRow, myColumns, myColumnsPerX,
  *                   myRowsPerY, xInterval, and yInterval
  *                 have been initialized.
  */

 private void setSizeDependentAttributes()
 {
   myRows = getHeight() - 2*AXIS_MARGIN; // - TITLE_ROWS;
   myLastRow = myRows - 1;
   myColumns = getWidth() - 2*AXIS_MARGIN;
   myColumnsPerX = (xMax - xMin) / myRows;
   myRowsPerY = (yMax - yMin) / myColumns;
   xInterval = (xMax - xMin) / (myColumns / AXIS_GAP);
   yInterval = (yMax - yMin) / (myRows / AXIS_GAP);
 }

 /** Map x-value to a grid column
  *  Receive: x, a double
  *  Return:  the grid column corresponding to x.
  */
 public int xToColumn(double x)
 {
   return AXIS_MARGIN + round((x-xMin) * myColumns / myXRange);
 }

 /** Map y-value to a grid row
  *  Receive: y, a double
  *  Return:  the grid row corresponding to y.
  */
 public int yToRow(double y)
 {
   return AXIS_MARGIN + myLastRow - round((y-yMin) * myRows / myYRange);
 }

 /** Get x-value corresponding to 1 grid column
  *  Return: the change in x per column.
  */
 public double deltaX()
 {
   return myXRange / myRows;
 }


 /** Get y-value corresponding to 1 grid row
  *  Return: the change in y per row.
  */
 public double deltaY()
 {
   return myYRange / myColumns;
 }

 /** Rounding method
  *  Receive: number, a double
  *  Return:  the nearest int to number.
  */
 public static int round(double number)
 {
   return (int) (number + 0.5);
 }

 /** Minimum x-value accessor
  *  Return: my minimum x-value
  */
 public double minX()
 {
   return xMin;
 }

 /** Minimum y-value accessor
  *  Return: my minimum y-value
  */
 public double minY()
 {
   return yMin;
 }

 /** Maximum x-value accessor
  *  Return: my maximum x-value
  */
 public double maxX()
 {
   return xMax;
 }

 /** Maximum y-value accessor
  *  Return: my maximum y-value
  */
 public double maxY()
 {
   return yMax;
 }

 /** Mutator for axis visibility
  *  Receive:       flag, a boolean value
  *  Postcondition: myAxisVisible == flag
  *                  && my axis is visible iff myAxisVisible.
  */
 public void setAxisVisible(boolean flag)
 {
   myAxisVisible = flag;
   repaint();
 }

 /** Accessor for axis visibility
  *  Return: myAxisVisible
  */
 public boolean getAxisVisible()
 {
   return myAxisVisible;
 }

 /** Mutator for axis values using coordinates
  *  Receive:       minX, minY, maxX, maxY, all double values.
  *  Postcondition: my axes and size-dependent variables and display
  *                  have been updated according to the parameter values.
  */
 public void resetAxis(double minX, double minY, double maxX, double maxY)
 {
   xMin = minX; yMin = minY;
   xMax = maxX; yMax = maxY;
   myXRange = xMax - xMin;
   myYRange = yMax - yMin;
   setSizeDependentAttributes();
   repaint();
 }

 /** Mutator for axis values using Points
  *  Receive:       lowerLeft, upperRight, two Point values.
  *  Postcondition: my axes and size-dependent variables and display
  *                  have been updated according to the parameter values.
  */
 public void resetAxis(Point lowerLeft, Point upperRight)
 {
   resetAxis(lowerLeft.x, lowerLeft.y, upperRight.x, upperRight.y);
 }

 /** Method to draw my axes
  *  Receive:       pen, a Graphics object.
  *  Postcondition: I have been drawn, showing axes iff myAxisVisible.
  */
 public void paintComponent(Graphics pen)
 {
   super.paintComponent(pen);

   int rows = getHeight() - 2*AXIS_MARGIN,      // - TITLE_ROWS,
       columns = getWidth() - 2*AXIS_MARGIN;

   if (rows < columns)
     mySizeFactor = round(mySizeFactor * (double)rows/myRows);
   else  
     mySizeFactor = round(mySizeFactor * (double)columns/myColumns);

   if (myXRange < myYRange)
     setSize(round(mySizeFactor * myXRange / myYRange) + 2 * AXIS_MARGIN, 
              mySizeFactor + 2 * AXIS_MARGIN);
   else
     setSize(mySizeFactor + 2 * AXIS_MARGIN, 
             round(mySizeFactor * myYRange / myXRange) + 2 * AXIS_MARGIN);

   setSizeDependentAttributes();
  
   if (myAxisVisible)
   {
     pen.drawLine(xToColumn(xMin), yToRow(0),                       // x-axis
                   xToColumn(xMax), yToRow(0));
     for (double x = xInterval; x < xMax-xInterval/4; x += xInterval)
     {
        pen.drawLine(xToColumn(x), yToRow(0)+5,
                      xToColumn(x), yToRow(0)-5);
        pen.drawString(myFormatter.format(x), xToColumn(x)-15, yToRow(0)+18 );
     }

     pen.drawLine(xToColumn(xMax), yToRow(0)+5, xToColumn(xMax), yToRow(0)-5);
     pen.drawString(myFormatter.format(xMax), xToColumn(xMax)-15, yToRow(0)-12);

     for (double x = -xInterval; x > xMin+xInterval/4; x -= xInterval)
     {
        pen.drawLine(xToColumn(x), yToRow(0)+5,
                      xToColumn(x), yToRow(0)-5);
        pen.drawString(myFormatter.format(x), xToColumn(x)-15, yToRow(0)+18 );
     }

     pen.drawLine(xToColumn(xMin), yToRow(0)+5, xToColumn(xMin), yToRow(0)-5);
     pen.drawString(myFormatter.format(xMin), xToColumn(xMin)-15, yToRow(0)-12);

     pen.drawLine(xToColumn(0), yToRow(yMin),                      // y-axis
                 xToColumn(0), yToRow(yMax) );
     for (double y = yInterval; y < yMax-yInterval/4; y += yInterval)
     {
        pen.drawLine(xToColumn(0)-5, yToRow(y),
                     xToColumn(0)+5, yToRow(y));
        pen.drawString(myFormatter.format(y), xToColumn(0)+10, yToRow(y)+5 );
     }
     pen.drawLine(xToColumn(0)-5, yToRow(yMax), xToColumn(0)+5, yToRow(yMax));
     pen.drawString(myFormatter.format(yMax), xToColumn(0)-30, yToRow(yMax)+5);

     for (double y = -yInterval; y > yMin+yInterval/4; y -= yInterval)
     {
        pen.drawLine(xToColumn(0)-5, yToRow(y),
                     xToColumn(0)+5, yToRow(y));
        pen.drawString(myFormatter.format(y), xToColumn(0)+10, yToRow(y)+5 );
     }
     pen.drawLine(xToColumn(0)-5, yToRow(yMin), xToColumn(0)+5, yToRow(yMin));
     pen.drawString(myFormatter.format(yMin), xToColumn(0)-30, yToRow(yMin)+5);

   }
 }

 /** Method to "clear" the grid of anything that has been drawn on me
  *   (except for my axes).
  *  Postcondition: I have just a set of axes showing.
  */
 public void clear()
 {
   this.repaint();
 }


 /** Method to mutate my pen/drawing color
  *  Receive:       newColor, a Color value
  *  Postcondition: myPenColor = newColor
  */
 public void setPenColor(Color newColor)
 {
   myPenColor = newColor;
 }

 /** Accessor to retrieve my current pen/drawing color
  *  Return: myPenColor
  */
 public Color getPenColor()
 {
   return myPenColor;
 }

//--- Attribute variables
 private double xMin, yMin,               // minimum axis values 
                xMax, yMax,               // maximum axis values 
                myColumnsPerX, myRowsPerY, // # columns/rows per x/y
                xInterval, yInterval,     // x/y-values btwn axis markings
                myXRange, myYRange;       // total range of x/y values
 private int    myRows, myColumns,        // number of rows/columns in graph 
                myLastRow,                // # of last row 
                mySizeFactor;             // factor for calc-ing "size" of graph
 private boolean myAxisVisible = true;    // flag for axis visibility
 private Color myPenColor = Color.black;  // drawing color
 private DecimalFormat myFormatter 
                = new DecimalFormat();    // formatter for axis labels
}


