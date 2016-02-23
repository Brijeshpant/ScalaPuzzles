import scala.io.Source

/**
  * Created by bpant on 23/12/15.
  */
object puzzle15 extends App {

  var input = 2503
  var cookiesProperty: Map[String, Properties] = Map.empty

  Source.fromInputStream(getClass.getResourceAsStream("puzzle15.txt")).getLines().foreach {
    i =>
      val replacedColon: String = i.replace(":", "")
      val array = i.replace(":", "").replace(",", "").split(" ")
      cookiesProperty += array(0).substring(0, array(0).length - 1) ->
        Properties(Integer.parseInt(array(2)), Integer.parseInt(array(4)), Integer.parseInt(array(6)), Integer.parseInt(array(8)), Integer.parseInt(array(10)))

  }
  val cookies = cookiesProperty.keySet.toArray

  def receipeWithoutCalories: Set[Int] = {
    var scores: Set[Int] = Set.empty

    for (i <- 1 to 100) {
      for (j <- 1 to 100 - i) {
        for (k <- 1 to 100 - (i + j)) {
          for (l <- 1 to 100 - (i + j + k)) {

            var capacity = i * cookiesProperty.get(cookies(0)).get.capacity + j * cookiesProperty.get(cookies(1)).get.capacity + k * cookiesProperty.get(cookies(2)).get.capacity + l * cookiesProperty.get(cookies(3)).get.capacity
            var durability = i * cookiesProperty.get(cookies(0)).get.durability + j * cookiesProperty.get(cookies(1)).get.durability + k * cookiesProperty.get(cookies(2)).get.durability + l * cookiesProperty.get(cookies(3)).get.durability
            var flavor = i * cookiesProperty.get(cookies(0)).get.flavor + j * cookiesProperty.get(cookies(1)).get.flavor + k * cookiesProperty.get(cookies(2)).get.flavor + l * cookiesProperty.get(cookies(3)).get.flavor
            var texture = i * cookiesProperty.get(cookies(0)).get.texture + j * cookiesProperty.get(cookies(1)).get.texture + k * cookiesProperty.get(cookies(2)).get.texture + l * cookiesProperty.get(cookies(3)).get.texture
            var score: Int = 0
            if (capacity > 0 && durability > 0 && flavor > 0 && texture > 0) score = capacity * durability * flavor * texture
            scores += score
          }
        }

      }
    }
    scores
  }
  println("Highest score is -------------" + receipeWithoutCalories.max)
  println("Highest score with calories is -------------" + receipeWithCalories.max)

  def receipeWithCalories: Set[Int] = {
    var scores:Set[Int]=  Set.empty

    for (i <- 1 to 100) {
      for (j <- 1 to 100 - i) {
        for (k <- 1 to 100 - (i + j)) {
          for (l <- 1 to 100 - (i + j + k)) {

            var capacity = i * cookiesProperty.get(cookies(0)).get.capacity + j * cookiesProperty.get(cookies(1)).get.capacity + k * cookiesProperty.get(cookies(2)).get.capacity + l * cookiesProperty.get(cookies(3)).get.capacity
            var durability = i * cookiesProperty.get(cookies(0)).get.durability + j * cookiesProperty.get(cookies(1)).get.durability + k * cookiesProperty.get(cookies(2)).get.durability + l * cookiesProperty.get(cookies(3)).get.durability
            var flavor = i * cookiesProperty.get(cookies(0)).get.flavor + j * cookiesProperty.get(cookies(1)).get.flavor + k * cookiesProperty.get(cookies(2)).get.flavor + l * cookiesProperty.get(cookies(3)).get.flavor
            var texture = i * cookiesProperty.get(cookies(0)).get.texture + j * cookiesProperty.get(cookies(1)).get.texture + k * cookiesProperty.get(cookies(2)).get.texture + l * cookiesProperty.get(cookies(3)).get.texture
            var calories = i * cookiesProperty.get(cookies(0)).get.calories + j * cookiesProperty.get(cookies(1)).get.calories + k * cookiesProperty.get(cookies(2)).get.calories + l * cookiesProperty.get(cookies(3)).get.calories
            var score: Int = 0
            if (capacity > 0 && durability > 0 && flavor > 0 && texture > 0 && calories == 500) score = capacity * durability * flavor * texture
            scores += score
          }
        }

      }
    }
    scores
  }


  case class Properties(capacity: Int, durability: Int, flavor: Int, texture: Int, calories: Int)

}
