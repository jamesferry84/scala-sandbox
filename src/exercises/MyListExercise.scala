package exercises

object MyListExercise extends App {

  val myemptylist = Empty
  println("myEmptyList= " + myemptylist.toString)

  val mylist = new Cons(1,new Cons(2, new Cons(3, Empty)))
  println("mylist = " + mylist.toString )
  val anotherNewList = mylist.add(4)
  println(anotherNewList.toString)



  abstract class MyList[+A] {
    def head[A]: A
    def tail[A]: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](num: B): MyList[B]
    def printElements: String
    def map[B](transformer: A => B): MyList[B]
    def flatMap[B](transformer: A => MyList[B]): MyList[B]
    def filter(predicate: A => Boolean): MyList[A]
    override def toString: String = "[" + printElements + "]"
    //concatenation
    def ++[B >: A](list: MyList[B]): MyList[B]

    def foreach(item: A => Unit): Unit
    def sort(compare: (A,A) => Int): MyList[A]
    def zipWith[B, C](list: MyList[B], x:(A,B) => C): MyList[C]
    def fold[B](start: B)(operator: (B,A) => B): B
  }

  case object Empty extends MyList {
    def head[A]: A = throw new NoSuchElementException
    def tail[A]: MyList[A] = throw new NoSuchElementException
    def isEmpty = true

    def map[B](transformer: Nothing => B): MyList[B] = Empty
    def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
    def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

    def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
    def printElements: String = ""
    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

    def foreach(item: Nothing => Unit): Unit = ()

    def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
    def zipWith[B,C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
      if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length!")
      else Empty
    }
    def fold[B](start: B)(operator: (B,Nothing) => B): B = start
  }

  case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head[A]: A = head
    def tail[A]: MyList[A] = tail
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyList[B] = new Cons(element, this)
    def printElements: String = {
      if(t.isEmpty) "" + h
      else h + " " + t.printElements
    }
    def filter(predicate: A => Boolean): MyList[A] = {
      if(predicate(h)) new Cons(h, t.filter(predicate))
      else t.filter(predicate)
    }

    def map[B](transformer: A => B): MyList[B] = {
      new Cons(transformer(h), t.map(transformer))
    }

    def foreach(f: A => Unit): Unit = {
      f(h)
      t.foreach(f)
    }

    def sort(compare: (A, A) => Int): MyList[A] = {
      def insert(x: A, sortedList: MyList[A]): MyList[A] = {
        if (sortedList.isEmpty) new Cons(x, Empty)
        else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
        else new Cons(sortedList.head, insert(x, sortedList.tail))
      }
      val sortedTail = t.sort(compare)
      insert(h, sortedTail)
    }

    override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
      if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
      else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
    }

    /*
      [1,2] ++ [3,4,5]
      = new Cons(1, [2] ++ [3,4,5]
      = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
      = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5))))
     */
    def ++[B >: A](list: MyList[B]): MyList[B] = {
      new Cons[B](h, t ++ list)
    }


    def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
      transformer(h) ++ t.flatMap(transformer)
    }

    def fold[B](start: B)(operator: (B, A) => B): B = {
      t.fold(operator(start,h))(operator)
    }
  }

  println(anotherNewList.map(_ * 2).toString)
  println(anotherNewList.filter(_ % 2 == 0).toString)
  println(mylist.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))).toString)

  println((mylist ++ anotherNewList).toString)
  println(mylist.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }).toString)

  mylist.foreach(println)
  //println(mylist.sort((x,y) => y - x))
  //println(anotherNewList.zipWith[String, String](mylist, _ + "-" + _))
  println(mylist.fold(0)(_ + _))
}


