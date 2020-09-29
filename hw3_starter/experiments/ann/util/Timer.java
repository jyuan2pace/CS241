/** Timer.java provides a simple 'stopwatch' timer for timing execution.
 *  Author:  Joel C. Adams
 *  Version: 1.01, for Java: An Introduction to Computing 1/e.  All Rights Reserved.
 */

package ann.util;

public class Timer extends Object
{
 public Timer()
 {
   running = false;
 }

 public void start()
 {
   if (!running)
   {
     running = true;
     startTime = System.currentTimeMillis();
   }
 }

 public void stop()
 {
   if (running)
   {
     stopTime = System.currentTimeMillis();
     running = false;
   }
 }

 public void reset()
 {
   startTime = System.currentTimeMillis();
 }

 public double getTime()
 {
   if (running)
     return (double)(System.currentTimeMillis() - startTime) / 1000;
   else
     return (double)(stopTime - startTime) / 1000;
 }

 public String toString()
 {
   return Double.toString( getTime() );
 }

 boolean running;    // true iff I am running
 long    startTime,  // time when start() msg received
         stopTime;   // time when stop() msg received
}
