import scala.io.Source

/**
  * Created by bpant on 23/12/15.
  */
object puzzle14 extends App {

  var input = 2503
  var flyingReindeers = Set.empty[Reindeer]
  var distanceCovered: Set[Int] = for (reindeer <- flyingReindeers) yield calculateDistanceCovered(reindeer)

  def calculateDistanceCovered(reindeer: Reindeer) = {
    var time = 0
    var distance = 0
    while (time <= input) {
      if (input - time > reindeer.flyTime) {
        distance += reindeer.speed * reindeer.flyTime
      }
      else distance += reindeer.speed * (input - time)
      time += reindeer.flyTime + reindeer.rest
    }
    distance
  }

  case class Reindeer(name: String, speed: Int, flyTime: Int, rest: Int)

  Source.fromInputStream(getClass.getResourceAsStream("puzzle14.txt")).getLines().foreach {
    i =>
      var array = i.substring(0, i.length - 1).split(" ")
      flyingReindeers += Reindeer(array(0), Integer.parseInt(array(3)), Integer.parseInt(array(6)), Integer.parseInt(array(13)))

  }

  case class PersonCombination(p1: String, p2: String)

  case class Happiness(happy: Boolean, count: Int)
  println(distanceCovered.max)

}
