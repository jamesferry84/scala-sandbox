package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x = 36
  println(x)

  //VALS ARE IMMUTABLE

  val someText: String = "Hiya!"
  val moreText: String = "goodbye"

  val trueOrFalse: Boolean = true
  val character: Char = 'c'
  val aShort: Short = 1234
  val aLong: Long = 12345678901112L
  val aFloat: Float = 2.0f
  val aDouble: Double = 33.14

  //variables
  var aVariable: Int = 4
  aVariable = 8 // side Effects
}
