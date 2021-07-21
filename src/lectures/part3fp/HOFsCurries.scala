package lectures.part3fp

object HOFsCurries extends App {


  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) return x
    else nTimes(f, n-1, f(x))
  }

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

}
