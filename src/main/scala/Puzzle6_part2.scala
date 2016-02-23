import scala.io.Source

/**
  * Created by bpant on 22/12/15.
  */
object Puzzle6_part2 extends App {

  def scanFile(input: String) = {

    var lights: Array[Array[Int]] = Array.fill[Int](1000, 1000)(0)

    def stringToDim(s: String): Dim = {
      var dim = s.split(",")
      Dim(Integer.parseInt(dim(0)), Integer.parseInt(dim(1)))
    }


    Source.fromInputStream(getClass.getResourceAsStream(input)).getLines().foreach {
      i =>
        processLine(lights, stringToDim _, i)
    }

    findLitCount(lights)
  }


  def findLitCount(lights: Array[Array[Int]]): Unit = {
    var countOfLights = 0
    for (row <- 0 until 1000) {
      for (column <- 0 until 1000) {
         countOfLights += lights(row)(column)
      }
    }
    println(countOfLights)
  }

  def processLine(lights: Array[Array[Int]], stringToDim: (String) => Dim, i: String): Unit = {
    var array = i.split(' ')
    array(0) match {
      case "turn" => {
        array(1) match {
          case "on" => updateBrightness(stringToDim(array(2)), stringToDim(array(4)), 1, lights)
          case "off" => updateBrightness(stringToDim(array(2)), stringToDim(array(4)), -1, lights)
        }
      }
      case "toggle" => updateBrightness(stringToDim(array(1)), stringToDim(array(3)), 2,lights)
    }
  }

  def updateBrightness(start: Dim, end: Dim, amount:Int,lights: Array[Array[Int]]): Unit = {
    for (row <- start.row to end.row) {
      for (column <- start.column to end.column) {
        if(lights(row)(column) > 0 || amount >0 )lights(row)(column) += amount
      }
    }
  }


  scanFile("puzzle6.txt")
  case class Dim(row: Int, column: Int)

}