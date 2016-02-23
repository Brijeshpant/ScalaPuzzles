import scala.io.Source
import scala.util.matching.Regex


/**
  * Created by bpant on 22/12/15.
  */

object puzzle8 extends App{
  //"daz\"zyyxddpwk"
  def scanFile(input: String) = {
    var count = 0
    def findRegexCount(r:Regex,s:String) = r.findAllIn(s).length
    val  scapeChar1 = "\\\\\\\\".r
    var scapeChar2 ="\\\"".r
//    var scapeChar3 ="\x".r
      Source.fromInputStream(getClass.getResourceAsStream(input)).getLines().foreach {
      i =>
        var totalCount = i.length
        var stripedString = i.substring(1,i.length -1).replaceAll("\"","\\\\t")
      //  var regexCount = 2+findRegexCount(scapeChar1,stripedString) + findRegexCount(scapeChar2,stripedString) +findRegexCount(new Regex("\\x",null),stripedString)
    //    var count1 =  totalCount - regexCount
        //count += count1
      //  var s= i.replace(scapeChar1,"\\")

//        var s1= i.replace(scapeChar2,'"')
//        var s2= i.replace(scapeChar3,"\\")
          print("ssss   "+stripedString)
    }
print(count)
  }
  scanFile("puzzle8.txt")
}
