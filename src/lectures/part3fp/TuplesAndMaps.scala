package lectures.part3fp

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = (2, "Hello, scala") // Tuple2[Int,String] = (Int, String)

  println(aTuple._1) // prints 2
  println(aTuple.copy(_2 = "goodbye, java"))
  println(aTuple.swap) // ("Hello, scala", 2)

  //Maps - keys => values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555),"Daniel" -> 444, "JIM" -> 9000).withDefaultValue(-1)
  //a -> b is syntatic sugar for (a,b)
  println(phoneBook)

    //map operations
  println(phoneBook.contains("Jim"))
  println(phoneBook("Mary"))


  //add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phoneBook + newPairing
  println(newPhonebook)

  //functionals on maps
  //map, flatmap, filter

  println("To lower case " + phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  //filterKeys
  println(phoneBook.filterKeys(x => x.startsWith("J")))

  //mapValues
  println(phoneBook.mapValues(number => "0245-" + number))

  //conversions
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob","James","Angela","Daniel","Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
    1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 9000 when running println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2)) - overwrites
    2. overly simplified social network based on maps
      Person = String
      - add a person to the network
      - remove a person
      - friend (mutual)
      - unfriend (mutual)

      - number of friends of a person
      -person with most friends
      -how many people have 0 friends
      - if there is a social connection between two people (direct or not)
   */
}
