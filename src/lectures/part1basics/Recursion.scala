package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else
      {
        //println("Computing Factorial of " + n + " - I first need factorial of " + (n-1))
        val result = n * factorial(n-1)
        //println("Computed factorial of " + n)

        result
      }
  }

  //println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x-1, x * accumulator)
    }
    factorialHelper(n,1)
  }

  /*
  anotherFactorial(10) = factorialHelper(10,1)
  = factorialHelper(9, 10 * 1)
  = factorialHelper(8, 9 * 10 * 1)
  = factorialHelper(7, 8 * 9 * 10 * 1)
  = factorialHelper(6, 7 * 8 * 9 * 10 * 1)
  ...
  = factorialHelper(2, 3 * 4 * 5 * ... * 10 * 1)
  = factorialHelper(1, 2 * 3 * 4 * .. * 10 * 1)
   */
 // println(anotherFactorial(100))

  /*
  1. Concatenate a string n times
  2. IsPrime function that is tail recursive
  3. Fibonacci function, tail recursive
   */

  def concatenateString(myWord: String, times: Int): String = {
      if (times <= 0) ""
      else myWord + concatenateString(myWord, times - 1)
  }

  println(concatenateString("Three", 3))

  def isPrimeTail(n: Int): Boolean = {
    def isPrimeHelper(n: Int, accumulator: Int): Boolean = {
      if (n <= 1) true
      else n % accumulator != 0 && isPrimeHelper(n-1, accumulator)
    }
    isPrimeHelper(n, 1)
  }
}
