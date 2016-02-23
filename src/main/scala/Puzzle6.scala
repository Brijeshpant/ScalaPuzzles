import scala.io.Source

/**
  * Created by bpant on 22/12/15.
  */
object Puzzle6 extends App {

  def scanFile(input: String) = {

    var lights: Array[Array[Boolean]] = Array.fill[Boolean](1000, 1000)(false)

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


  def findLitCount(lights: Array[Array[Boolean]]): Unit = {
    var countOfLights = 0
    for (row <- 0 until 1000) {
      for (column <- 0 until 1000) {
        if (lights(row)(column)) countOfLights += 1
      }
    }
    println(countOfLights)
  }

  def processLine(lights: Array[Array[Boolean]], stringToDim: (String) => Dim, i: String): Unit = {
    var array = i.split(' ')
    array(0) match {
      case "turn" => {
        array(1) match {
          case "on" => turnOnOrOff(stringToDim(array(2)), stringToDim(array(4)), true, lights)
          case "off" => turnOnOrOff(stringToDim(array(2)), stringToDim(array(4)), false, lights)
        }
      }
      case "toggle" => toggle(stringToDim(array(1)), stringToDim(array(3)), lights)
    }
  }

  def toggle(start: Dim, end: Dim, lights: Array[Array[Boolean]]): Unit = {
    for (row <- start.row to end.row) {
      for (column <- start.column to end.column) {
        lights(row)(column) = !lights(row)(column)
      }
    }
  }

  def turnOnOrOff(start: Dim, end: Dim, on: Boolean, lights: Array[Array[Boolean]]): Unit = {
    for (row <- start.row to end.row) {
      for (column <- start.column to end.column) {
        lights(row)(column) = on
      }
    }

  }

  scanFile("puzzle6.txt")
  case class Dim(row: Int, column: Int)

}