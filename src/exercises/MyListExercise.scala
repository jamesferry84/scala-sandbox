package exercises

object MyListExercise extends App {

  val myemptylist = Empty
  println("myEmptyList= " + myemptylist.toString)

  val mylist = new MyListImplementation("A",new MyListImplementation(2, new MyListImplementation(3, Empty)))
  println("mylist = " + mylist.toString )
  val anotherNewList = mylist.add(4)
  println(anotherNewList.toString)



  abstract class MyList[+A] {
    def head[A]: A
    def tail[A]: MyList[A]
    def isEmpty: Boolean
    def add[A](num: A): MyList[A]
    def printElements: String
    override def toString: String = "[" + printElements + "]"
  }

  object Empty extends MyList {
    def head[A]: A = throw new NoSuchElementException
    def tail[A]: MyList[A] = throw new NoSuchElementException
    def isEmpty = true
    def add[A](element: A) = new MyListImplementation(element, Empty)
    def printElements: String = ""
  }

  class MyListImplementation[A](h: A, t: MyList[A]) extends MyList {
    def head[A]: A = head
    def tail[A]: MyList[A] = tail
    def isEmpty: Boolean = false
    def add[A](element: A) = new MyListImplementation(element, this)
    def printElements: String = {
      if(t.isEmpty) "" + h
      else h + " " + t.printElements
    }
  }

}


