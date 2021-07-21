package lectures.part3fp

object WhatsAFunction extends App {

  //DREAM: use functions as first class elements
  //problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  //function types = Function1[A,B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  val stringConcatenator:  ((String, String) => String) = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  val functionTest: (Int) => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(a: Int): Function1[Int, Int] = new Function1[Int,Int] {
      override def apply(b: Int): Int = a + b
    }
  }



  //Function types Function2[A, B, R] === (A,B) => R

  println(stringConcatenator("James","Ferry"))
  val adder1 = functionTest(3)
  println(adder1(2))

  //ALL SCALA FUNCTIONS ARE OBJECTS
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
