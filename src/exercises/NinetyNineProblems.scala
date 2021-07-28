package exercises

/**
  * Created by jamesferry on 24/07/2021.
  */
object NinetyNineProblems extends App {

  val testList = List(1,2,3,4,5)
  println(findLastElementOfList(testList))
  println(findPenultimateElementOfList(testList))

  def findLastElementOfList[A](list: List[A]) = {
    if (list.isEmpty) throw new NoSuchElementException
    else list.last
  }

  def findPenultimateElementOfList[A](list: List[A]) = {
    if (list.isEmpty) throw new NoSuchElementException
    else list.init.last
  }

  def problem3[A](n: Int, list: List[A]): A = {
    list(n)
  }
  println(problem3(2, testList))

  def problem4[A](list: List[A]): Int = {
    list.size
  }

  def problem4Manual[A](list: List[A]): Int = {

    def problem4Aux[A](list: List[A], acc: Int = 0): Int = {
      if(list.isEmpty) acc
      if (list.nonEmpty) problem4Aux(list.tail, acc + 1)
      else acc
    }

    problem4Aux(testList)
  }

  println(problem4(testList))
  println(problem4Manual(testList))

}
