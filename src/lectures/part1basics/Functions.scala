package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = {
    42
  }

  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello",3))

  //WHEN YOU NEED LOOPS, USE RECURSION

  def greeting(name: String, age: Int): String = {
    s"Hi, my name is $name and my age is $age"
  }

  println(greeting("James", 36))

  def factorial(num: Int): Int = {
    if (num <= 0) 1
    else num * factorial(num-1)
  }

  println(factorial(5))

  def fibonacci(num: Int): Int = {
    if (num <= 2) 1
    else fibonacci(num - 1) + fibonacci(num - 2)
  }

  println(fibonacci(7))

  def isPrime(num: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else num % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(num / 2)
  }

  println(isPrime(31))
}
