package lectures.part1basics

object ByNameVsByValue extends App {


  def calledByValue(x: Long): Unit = {
      println("by value " + x) //  println("by name " + 112834738924L)
      println("by value " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name " + x) //  println("by name " + System.nanoTime())
    println("by name " + x)
  }

  calledByValue(System.nanoTime());
  calledByName(System.nanoTime());

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34)

  printFirst(34, infinite())
}
