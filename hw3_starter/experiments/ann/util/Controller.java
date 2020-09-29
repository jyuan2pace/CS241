/** Controller.java -- a class used to control execution.
 *  Contents: pause() and fatal()
 *  Author:  Joel C. Adams
 *  Version: 1.01, for Java: An Introduction to Computing 1/e.  All Rights Reserved.
 */

package ann.util;
import java.lang.*;

public class Controller
{
 /** pause(n) pauses program execution for n seconds.
  *  Receive:       seconds, a double value
  *  Precondition:  seconds > 0.
  *  Postcondition: secconds time has elapsed since invocation.
  */
 public static void pause(double seconds)
 {
   final long START_TIME = System.currentTimeMillis();
   if (seconds > 0)
   {
     long currentTime = 0,
          milliSeconds = (long)(1000 * seconds + 0.5);
 
     do
       currentTime = System.currentTimeMillis();
     while((currentTime - START_TIME) <= milliSeconds);
   }
   else
     fatal("pause(n):", "negative n received");    
  }


 /** fatal(methodName, diagnostic) displays a diagnostic error message
  *   for methodName and terminates execution.
  *  Receive:       methodName, the name of the method where the error
  *                 occurred, and diagnostic, a message explaining the problem
  *  Output:        an error message containing methodName and diagnostic
  *  Postcondition: Execution has been terminated.
  */
 public static void fatal(String methodName, String diagnostic)
 {
   System.err.println("\n*** " + methodName + ": " + diagnostic);
   System.err.flush();
   System.exit(1);
 }

}

