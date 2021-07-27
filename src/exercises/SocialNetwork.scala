package exercises

object SocialNetwork extends App {

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], person: String, friend: String): Map[String, Set[String]] = {
    val personsFriends = network(person)
    val othersFriends = network(friend)
    network + (person -> (personsFriends - friend)) + (friend -> (othersFriends - person))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }
    val unFriended = removeAux(network(person), network)
    unFriended - person
  }

  def numFriends(network: Map[String, Set[String]], person: String): Int = {
    network(person).size
  }

  def mostFriends(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }

  def numPeopleNoFriends(network: Map[String, Set[String]]): Int = {
    network.count(x => x._2.isEmpty)
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(add(empty,"Bob"), "Jim"), "Wenting")
  val jimbob = friend(network, "Jim", "Bob")
  val testNet = friend(jimbob, "Bob", "Wenting")
  println(testNet)
  println(numFriends(testNet, "Wenting"))
  println(mostFriends(testNet))
  println(numPeopleNoFriends(testNet))
 // println(friend(network, "Bob", "Mary"))
 // println(unfriend(network, "Bob", "Mary"))
}

