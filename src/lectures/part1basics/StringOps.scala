package lectures.part1basics

import sun.nio.cs.ext.MacGreek

object StringOps extends App {

  val str: String = "Hello I am learning Scala"
  println(str.charAt(2))
  println(str.substring(0, 5))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))

  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  //Scala-specific: String Interpolators

  //S-Interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old!"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1}"
  println(greeting)
  println(anotherGreeting)

  //F-Interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  //raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
