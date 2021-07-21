package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length) // this will crash with NULL POINTER EXCEPTION

  val aWeirdValue = throw new NullPointerException
}
