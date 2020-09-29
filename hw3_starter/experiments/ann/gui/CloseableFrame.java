/** CloseableFrame.java
 *  Author:  Joel C. Adams
 *  Version: 1.01, for Java: An Introduction to Computing 1/e.  All Rights Reserved.
 */

package ann.gui;

import javax.swing.JFrame;
import java.awt.*;                  // WindowAdaptor
import java.awt.event.*;            // WindowEvent

public class CloseableFrame extends JFrame
{
  final static int DEFAULT_WIDTH  = 300;
  final static int DEFAULT_HEIGHT = 400;

  public CloseableFrame()
  {
    super();
    setTitle(getClass().getName());
    setup();
  } 
  
  public CloseableFrame(String title)
  {
    super(title);
    setup();
  } 
  
  private void setup()
  {
    addWindowListener(new WindowAdapter() 
                          {
                            public void windowClosing(WindowEvent event)
                            {
                              System.exit(0);
                            } 
                          } 
                     );

    addComponentListener(new ComponentAdapter()
                             {
                              public void componentResized(ComponentEvent event)
                              {
                                repaint();
                              } 
                             } 
                        );

    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
  } 
  
  public static void main(String [] args)
  {
    CloseableFrame testFrame1 = new CloseableFrame();
    testFrame1.setVisible(true);
  } 
} 
