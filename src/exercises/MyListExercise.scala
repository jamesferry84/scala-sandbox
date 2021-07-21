package exercises

abstract class MyList {

  //describes a list of Integers
  //singly linked List

  /*
     method head = first element of the list
     method tail = remainder of the list
     method isEmpty = is this list empty
     method add(int) => new List with this element added
     override toString => a string representation of the list
   */

  abstract class MyList {
    def head: Int
    def tail: MyList
    def isEmpty: Boolean
    def add(num: Int): MyList
  }

  object EmptyList extends MyList {
    def head: Int = ???
    def tail: MyList = ???
    def isEmpty = true
    def add(num: Int) = new MyList(num, EmptyList)
  }

  class MyListImplementation extends MyList


}
