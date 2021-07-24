package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  //1. class parameters are fields
  val jim = new Person("Jim", 36)
  println(jim.name)

  //2. sensible toString
  println(jim.toString)

  //3. equals and hashcode implemented out of the box
  val jim2 = new Person("Jim", 36)
  println(jim == jim2)

  //4 case classes have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  //5 Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  //6 Case classes are serializable
  // Akka

  //7 Case classes have extractor patterns = Case classes can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  Expand mylist - use case classes and case objects
   */

}
