package lectures.part2oop

object MethodNotations  extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 18) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck???"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and i like $favouriteMovie"
    def +(nickname: String) = this.name + " (" + nickname + ")"
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def learns(learning: String) : String = s"$name learns $learning"
    def learnsScala: String = learns("Scala")
    def apply(times: Int): String = s"$name watched $favouriteMovie $times times"
  }

  val mary = new Person("Mary", "Inception", 22)
  println(mary.likes("Inception"))
  println(mary likes "Inception")
  //infix notation || operation notation

  // "operators" in Scala

  val tom = new Person("Tom", "Fight Club")
  println(mary hangoutWith tom)

  //PREFIX NOTATION
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) // equivalent

  println(mary + "the rockstar")
  println(+mary.age)
  println(mary learnsScala)
  println(mary(2))

  /*
  1. Overload the + operator receives a string and returns person with nickname
      example: mary + " the rockstar" => new Person "Mary (the rockstar)"
  2. Add an age to the person class
      Add a unary + operator which increments value of age and returns new person
      +mary => mary with age incremented
  3. Add a "Learns" method in the Person class => "Mary learns Scala"
      Add a learnsScala method, calls learns method with "Scala" as parameter
      Use it in postfix notation
  4. Overload the apply method to receive a number and return string.
      mary.apply(2) => "Mary watched Inception 2 times"
   */

}
