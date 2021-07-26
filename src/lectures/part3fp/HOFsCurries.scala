package lectures.part3fp

object HOFsCurries extends App {


  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) return x
    else nTimes(f, n-1, f(x))
  }

  val one = 1
  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  //nTimesBetter(f,n) = x => f(f(f...(x)))
  //increment 10 = nTimesBetter(plusOne, 10) = x => plusOne(plusOne...(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val plusTen = nTimesBetter(plusOne,10)
  println(plusTen(1))

  //curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  //functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))
}
