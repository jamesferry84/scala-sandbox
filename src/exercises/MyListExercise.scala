package exercises

object MyListExercise extends App {

  val myemptylist = Empty
  println("myEmptyList= " + myemptylist.toString)

  val mylist = new MyListImplementation(1,new MyListImplementation(2, new MyListImplementation(3, Empty)))
  println("mylist = " + mylist.toString )
  val anotherNewList = mylist.add(4)
  println(anotherNewList.toString)



  abstract class MyList[+A] {
    def head[A]: A
    def tail[A]: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](num: B): MyList[B]
    def printElements: String
    def map[B](transformer: MyTransformer[A,B]): MyList[B]
    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
    def filter(predicate: MyPredicate[A]): MyList[A]
    override def toString: String = "[" + printElements + "]"
    //concatenation
    def ++[B >: A](list: MyList[B]): MyList[B]
  }

  case object Empty extends MyList {
    def head[A]: A = throw new NoSuchElementException
    def tail[A]: MyList[A] = throw new NoSuchElementException
    def isEmpty = true
    def map[B](transformer: MyTransformer[Nothing,B]): MyList[B] = Empty
    def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
    def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

    def add[B >: Nothing](element: B): MyList[B] = new MyListImplementation(element, Empty)
    def printElements: String = ""
    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  }

  case class MyListImplementation[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head[A]: A = head
    def tail[A]: MyList[A] = tail
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyList[B] = new MyListImplementation(element, this)
    def printElements: String = {
      if(t.isEmpty) "" + h
      else h + " " + t.printElements
    }
    def filter(predicate: MyPredicate[A]): MyList[A] = {
      if(predicate.test(h)) new MyListImplementation(h, t.filter(predicate))
      else t.filter(predicate)
    }

    def map[B](transformer: MyTransformer[A,B]): MyList[B] = {
      new MyListImplementation(transformer.transform(h), t.map(transformer))
    }

    /*
      [1,2] ++ [3,4,5]
      = new Cons(1, [2] ++ [3,4,5]
      = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
      = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5))))
     */
    def ++[B >: A](list: MyList[B]): MyList[B] = {
      new MyListImplementation[B](h, t ++ list)
    }


    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
      transformer.transform(h) ++ t.flatMap(transformer)
    }
  }

  trait MyPredicate[-T] {
    def test(value: T): Boolean
  }

  trait MyTransformer[-A,B] {
    def transform(elem: A): B
  }

  println(anotherNewList.map(new MyTransformer[Int,Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(anotherNewList.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println((mylist ++ anotherNewList).toString)
  println(mylist.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new MyListImplementation(elem, new MyListImplementation(elem + 1, Empty))
  }).toString)

}


