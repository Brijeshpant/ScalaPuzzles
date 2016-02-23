/**
  * Created by bpant on 23/12/15.
  */
import scala.util.control.Breaks._

object puzzle11 extends App{
  val oldPassword = "zzzzzz"

  var c = 'a'

 def findNextValidPassword(w:String):String = {
    var tryPassword = next(w)
   if(straightThree(tryPassword) && twoInRow(tryPassword) && !checkForIOL(tryPassword)) tryPassword
   else findNextValidPassword(tryPassword)

 }

  def next(s:String) :String ={
    var length = s.length()
    var c = s.charAt(length - 1)
    if(c == 'z'){
      if(length > 1)  {
        next(s.substring(0, length - 1)) + "a"
      }
      else "a"
    }
     else{
      var p = c.toInt
      p += 1
      s.substring(0, length - 1) +  p.toChar
    }
  }
  def straightThree(s:String) ={
    var flag =false
    breakable{
      for (c <- 0 to s.length -3) {
        if(s(c).toInt +1 == s(c+1).toInt && s(c).toInt +2 == s(c+2).toInt ) {
          flag =true
          break
        }
      }
    }
    flag
    }

  def twoInRow(s:String) :Boolean={
    var countOfTwoInRow = 0
    var lastFound = -1
      for (c <- 0 to s.length -2) {
        if(s(c).toInt == s(c+1) && lastFound != c) {
          countOfTwoInRow +=1
          lastFound = c+1
      }
    }
    countOfTwoInRow >= 2
  }

  def checkForIOL(s:String) = s.contains('i') || s.contains('o') || s.contains('l')



  println(findNextValidPassword(findNextValidPassword("hxbxwxba")))
//  println(next(oldPassword))
}
