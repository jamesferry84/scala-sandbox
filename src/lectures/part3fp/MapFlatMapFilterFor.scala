package lectures.part3fp

object MapFlatMapFilterFor extends App {

  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  //filter
  println(list.filter(_ % 2 == 0))

  //flatmap
  val toPair = (x: Int) => List(x , x+1)
  println(list.flatMap(toPair))

  val numbers = List(1,2,3,4)
  val letters = List('a','b','c','d')

  //iterating
  val combinations = numbers.flatMap(n => letters.map(c => "" + c + n))
  println(combinations)

  //foreach

  list.foreach(println)

  //for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- letters
  } yield ("" + c + n)

  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  //syntax overload
  list.map { x =>
    x * 2
  }

  /*
  1. Does MyList supports for comprehensions?
  2. Implement a small collection of at most ONE element - Maybe[+T]
      - map , flatMap, filter
   */

}
