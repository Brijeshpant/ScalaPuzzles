import scala.io.Source

/**
  * Created by bpant on 22/12/15.
  */
object puzzle2 extends App {

  def scanFile(input: String): Int = {
    var wrappingPaperArea = 0

    Source.fromInputStream(getClass.getResourceAsStream(input))
      .getLines().foreach {
      i =>
        var array = i.split('x')
        wrappingPaperArea += findSurfaceArea(Integer.parseInt(array(0)), Integer.parseInt(array(1)), Integer.parseInt(array(2)))
        +findAreaOfSmallestSize(Integer.parseInt(array(0)), Integer.parseInt(array(1)), Integer.parseInt(array(2)))
    }
    wrappingPaperArea
  }

  def findAreaOfSmallestSize(l: Int, w: Int, h: Int): Int = {
    List(l * w, w * h, h * l).min
  }

  def findSurfaceArea(h: Int, l: Int, w: Int): Int = {
    2 * l * w + 2 * w * h + 2 * h * l
  }

  def scanFileForRibbon(input: String): Int = {
    var wrappingPaperArea = 0

    Source.fromInputStream(getClass.getResourceAsStream(input)).getLines().foreach {
      i =>
        var array = i.split('x')
        wrappingPaperArea += ribbonArea(Integer.parseInt(array(0)), Integer.parseInt(array(1)), Integer.parseInt(array(2)))
    }
    wrappingPaperArea
  }

  //print(scanFile("puzzle2.txt"))

  def ribbonArea(i: Int, i1: Int, i2: Int): Int = {
    var sortetedList = List(i, i1, i2).sortWith((a, b) => a < b)
    val area = 2 * sortetedList(0) + 2 * sortetedList(1) + i * i1 * i2
    area
  }

  print(scanFileForRibbon("puzzle2.txt"))

}
