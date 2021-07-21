package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit

  }

  //anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahahahha")
  }

  println(funnyAnimal.getClass)

}
