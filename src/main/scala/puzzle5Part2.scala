import scala.io.Source

/**
  * Created by bpant on 22/12/15.
  */
object puzzle5Part2 extends App {

  def isVowels(x: Char): Boolean = x.equals('a') || x.equals('e')||x.equals('i')||x.equals('o')|| x.equals('u')
  def hasConsecutiveChar(x:String) :Boolean = {
    var hs =false
    if(x.size == 0 ||x.tail.size == 0) hs = false
    else if(x.head.equals(x.charAt(1))) hs= true
    else hs =  hasConsecutiveChar(x.tail)
    hs
  }
  def hasValidStrings(s:String) = !(s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy"))

  def isNice(i: String) = {
      i.filter(x=>isVowels(x)).size >=3 && hasConsecutiveChar(i) && hasValidStrings(i)
  }


  def scanFile(input:String): Int = {
    var niceStrings = 0
    Source.fromFile(input).getLines().foreach {
      i =>
       if(isNice(i)) niceStrings +=  1
    }
    niceStrings
  }

    println(scanFile("/Users/bpant/work/xebia/techRaily/src/main/resources/puzzle5.txt"))
}
