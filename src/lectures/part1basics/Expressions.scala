package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)
  var aVariable = 1
  val aWeirdValue = (aVariable = 3) // Unit === void

  println(aWeirdValue)

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "Goodbye"
  }

  //println is unit hello world is string
  //true
  // 42


}
