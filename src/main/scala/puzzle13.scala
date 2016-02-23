import scala.io.Source

/**
  * Created by bpant on 23/12/15.
  */
object puzzle13 extends App {

  var familyMembers = Set.empty[String]
  var happiness = Map.empty[PersonCombination, Int]
  var happinessList = List.empty
  var list = permute(familyMembers.toList)
  var listWithMe = permute("Brij" :: familyMembers.toList)

  Source.fromInputStream(getClass.getResourceAsStream("puzzle13.txt")).getLines().foreach {
    i =>
      var array = i.substring(0, i.length - 1).split(" ")
      var p1 = array(0)
      var p2 = array(10)
      familyMembers += p1
      familyMembers += p2
      array(2) match {
        case "gain" => happiness += PersonCombination(p1, p2) -> Integer.parseInt(array(3))
        case "lose" => happiness += PersonCombination(p1, p2) -> -Integer.parseInt(array(3))
      }
  }
  //  var counts:List[Int] = for (perm <-list) yield findHappinessCountForEachCombination(perm)
  var counts: List[Int] = for (perm <- listWithMe) yield findHappinessCountForEachCombination(perm)

  def selections[A](xss: List[A]): List[(A, List[A])] = xss match {
    case Nil => Nil
    case x :: xs =>
      (x, xs) :: (for ((y, ys) <- selections(xs))
        yield (y, x :: ys))
  }

  /** Returns a list containing all permutations of the input list */
  def permute[A](xs: List[A]): List[List[A]] = xs match {
    case Nil => List(Nil)

    //special case lists of length 1 and 2 for better performance
    case t :: Nil => List(xs)
    case t :: u :: Nil => List(xs, List(u, t))

    case _ =>
      for ((y, ys) <- selections(xs); ps <- permute(ys))
        yield y :: ps
  }

  def findHappinessCountForEachCombination(perm: List[String]): Int = {
    var count = 0
    for (c <- 0 to perm.size - 1) {
      var s1 = perm.lift((c)).get
      var s2 = perm.lift((c + 1) % perm.size).get
      count += findHappinessCount(s1, s2)
    }
    count
  }

  def findHappinessCount(s1: String, s2: String): Int = {
    happiness.get(PersonCombination(s1, s2)).getOrElse(0) + happiness.get(PersonCombination(s2, s1)).getOrElse(0)
  }

  case class PersonCombination(p1: String, p2: String)
  println(counts.max)

  case class Happiness(happy: Boolean, count: Int)


}
