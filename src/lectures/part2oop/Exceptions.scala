package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length) // this will crash with NULL POINTER EXCEPTION

  //Throwing Exceptions
  //val aWeirdValue: String = throw new NullPointerException

  //throwable classes extend the Throwable class
  //Exception and Error are the major Throwable subtypes

  //Catching Exception
  def getInt(withExceptions: Boolean): Int = {
    if(withExceptions) throw new RuntimeException("No int for you")
    else 4200
  }

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime exception")
  } finally {
    //code that will always get executed
    println("Finally....")
  }

  println(potentialFail)

  //How to define own exceptions
  class MyException ex
}
