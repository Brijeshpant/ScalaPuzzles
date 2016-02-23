import scala.io.Source

/**
  * Created by bpant on 23/12/15.
  */
object puzzle23 extends App {

  var instructions: List[String] =List.empty

  Source.fromInputStream(getClass.getResourceAsStream("puzzle15.txt")).getLines().foreach {
    i =>
//      instructions += i

  }



}
