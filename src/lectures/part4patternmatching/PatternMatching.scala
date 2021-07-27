package lectures.part4patternmatching

import scala.util.Random

object PatternMatching extends App {

  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "The One!"
    case 2 => "double or nothing"
    case 3 => "Triple threat"
    case _ => "Something else"
  }

  println(x)
  println(description)

  //1. Decompose Values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hy my name is $n and I cannot drink in the USA"
    case Person(n, a) => s"Hi my name is $n and I am $a years old!"
    case _ => "I dont know who i am..... who are you?"
  }

  println(greeting)

  /*
  1. cases are matched in order
  2. what if no cases match? == match error
  3. WHats the type of pattern match expression
  4. PM Workes really well with case classes
   */

  // Pattern matching on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }



}
