/** Formula.java defines useful mathematical functions.
 *  Contents: factorial for BigIntegers
 *  Author:  Joel C. Adams
 *  Version: 1.01, for Java: An Introduction to Computing 1/e.  All Rights Reserved.
 */

package ann.math;

import java.math.BigInteger;
import ann.util.Controller;

public class Formula
{
 final static BigInteger ZERO = new BigInteger("0");

  /** factorial() computes n!, given a nonnegative BigInteger. 
   *  Receive:      n, a BigInteger
   *  Precondition: n >= 0
   *  Return:       n! = 1 * 2 * ... * (n-1) * n
   */
  public static BigInteger factorial(BigInteger n)
  {
    if(n.compareTo(ZERO) < 0)                     // check precondition
    {
      System.err.println("\n*** factorial(n): invalid argument "
                         + n + "received");
      System.exit(1);
    }
    final BigInteger ONE = new BigInteger("1");   // constant 1
    BigInteger product = new BigInteger("1");

    for (BigInteger count = new BigInteger("2");                                 
                    count.compareTo(n) <= 0; 
	              count = count.add(ONE))
      product = product.multiply(count); 

    return product;
  }

  /** summation(long n) computes the sum of the integers from 1 to n 
   *    using Gauss' formula. 
   *  Receive:      n, a long
   *  Precondition: n > 0
   *  Return:       the long value = 1 + 2 + ... + n
   */

  public static long summation(long n)
  {
    if (n > 0)
      return n * (n+1) / 2;
    else
    {
      Controller.fatal("summation(n)", "non-positive n received");
      return 0;
    }
  }

}

 
