package lectures.part2oop

object Objects extends App {

  //SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")

  //Scala object = SINGLETON INSTANCE
  object Person { //type + its only instance
    // "static" level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }
  class Person(val name: String) {
    // instance level functionality
  }
  //COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  //Scala object = SINGLETON INSTANCE
  val mary = new Person("mary")
  val john = new Person("john")
  println(mary == john)

  val bobby = Person(mary, john)

  //Scala Applications = Scala object with
  // def main(Args: Array[String]): Unit

}
