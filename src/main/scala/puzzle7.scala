import scala.io.Source

/**
  * Created by bpant on 22/12/15.
  */
object puzzle7 extends App{
  case class Wire(var signal:Int)
  case class ACTION(in:Wire,out:Wire,action:String)
  var wires:Set[Wire] = Set.empty

  def scanFile(input: String) = {

    Source.fromFile(input).getLines().foreach {
      line =>
        var array = line.split(" ")
        line match {
          case "AND" if(line.contains(""))    =>
        }
    }

  }


 def and(wire1:Wire,wire2:Wire,output:Wire) ={
   output.signal = wire1.signal & wire2.signal
   output
  }

  def or(wire1:Wire,wire2:Wire,output:Wire) ={
   output.signal = wire1.signal | wire2.signal
   output
  }

  def rightShift(wire1:Wire,signal:Int,output:Wire) ={
   output.signal = wire1.signal >> signal
   output
  }


  def leftShift(wire1:Wire,signal:Int,output:Wire) ={
    output.signal = wire1.signal << signal
    output
  }

  def not(wire1:Wire,output:Wire) ={
    output.signal =  wire1.signal

  }
}
