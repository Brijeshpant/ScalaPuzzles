import scala.io.Source

/**
  * Created by bpant on 22/12/15.
  */


object Puzzle1 extends App {

  //Part1
  def findFloor(input: String): Int = {
    var currentFloor = 0
    Source.fromInputStream(getClass.getResourceAsStream(input)).foreach {
      i =>
        i match {
          case '(' => currentFloor +=  1
          case ')' => currentFloor -=  1
        }
    }
    currentFloor
  }

  //part2
  def findBasement(input: String): Int = {
    var currentFloor = 0
    var basementPosition = 0
    var basementfound = false
    Source.fromInputStream(getClass.getResourceAsStream(input)).foreach{
      i => basementfound
        i match {
          case '(' => currentFloor += 1
          case ')' => currentFloor -= 1
        }
        if (currentFloor == -1 && !basementfound) {
          basementPosition +=  1
          basementfound = true
        }
        else if (!basementfound) basementPosition += 1
    }
    basementPosition
  }

  print(findBasement("/puzzle1.txt"))

}