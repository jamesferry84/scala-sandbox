package lectures.part2oop

object OOBasics extends App  {

  val count = new Counter(1)

}

// constructor
class Person(name: String, val age: Int) {
  // body
  val x = 2
  println( 1 + 3)

  //method
  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi, $name")
  }

  def greet(): Unit = {
    println(s"Hi, I am $name")
  }

  //multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

}

class Writer(firstName: String, surname: String, val birthYear: Int)  {
  def fullname(): String = {
    firstName + " " + surname
  }
}

class Novel(name: String, release: Int, author: Writer) {
  def authorAgeOnRelease(): Int = {
    release - author.birthYear
  }

  def isWrittenBy(): String = {
    author.fullname()
  }

  def copy(): Novel = {
    new Novel(this.name, this.release, this.author)
  }
}

class Counter(val number: Int) {


  def increment = new Counter(number + 1)

  def decrement(): Int = {
    number - 1
  }

  def increment(amount: Int): Int = {
    number + amount
  }

  def decrement(amount: Int): Int = {
    number - amount
  }
}

