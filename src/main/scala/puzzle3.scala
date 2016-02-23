import scala.io.Source

/**
  * Created by bpant on 22/12/15.
  */
object puzzle3 extends App {

  var gridOfHouses: Set[Position] = Set.empty
  def updateCurrentPosition(i: Char, c: Position): Position = {
    var currentPosition = c
    i match {
      case '^' => currentPosition = currentPosition.copy(y = currentPosition.y + 1)
      case 'v' => currentPosition = currentPosition.copy(y = currentPosition.y - 1)
      case '>' => currentPosition = currentPosition.copy(x = currentPosition.x + 1)
      case '<' => currentPosition = currentPosition.copy(x = currentPosition.x - 1)
    }
    currentPosition
  }


  def findDeliveredHouses(input: String): Int = {
    var position = 0
    var currentPositionSanta = Position(0, 0)
    var currentPositionRoboSanta = Position(0, 0)
    gridOfHouses += currentPositionSanta
    Source.fromInputStream(getClass.getResourceAsStream(input)).foreach {
      i =>
        currentPositionSanta = updateCurrentPosition(i, currentPositionSanta)
        gridOfHouses += currentPositionSanta
    }
    gridOfHouses.size
  }


  def findDeliveredHousesWithRobo(input: String): Int = {
    var position = 0
    var currentPositionSanta = Position(0, 0)
    var currentPositionRoboSanta = Position(0, 0)
    gridOfHouses += currentPositionSanta

    Source.fromInputStream(getClass.getResourceAsStream(input)).foreach {
      i =>
        if ((position / 2) * 2 == position) {
          currentPositionSanta = updateCurrentPosition(i, currentPositionSanta)
          gridOfHouses += currentPositionSanta
        }
        else {
          currentPositionRoboSanta = updateCurrentPosition(i, currentPositionRoboSanta)
          gridOfHouses += currentPositionRoboSanta
        }
        position += 1
    }
    gridOfHouses.size
  }

  case class Position(x: Int, y: Int)

  println(findDeliveredHouses("puzzzle3.txt"))
}