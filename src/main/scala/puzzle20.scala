/**
  * Created by bpant on 23/12/15.
  */
object puzzle20 extends App {

  val input = 29000000

  def findPresentCountsForTheHouseNumber(n: Int) :Int= {
    var presentCount = 0
    var i = 1
    while ((i <= n)) {
      if ((n % i == 0)){
        presentCount += i *10
      }
      i += 1

    }
    presentCount
  }

  def findPresentCountsForTheHouseNumberWithRule2(n: Int) :Int= {
    var presentCount = 0
    var i = 1
    while ((i <= n)) {
      if ((n % i == 0 && n <= i*50)){
        presentCount += i *11
      }
      i += 1

    }
    presentCount
  }


  var presentCount = 0
  var count = 1
    while(presentCount < input){
//      presentCount= findPresentCountsForTheHouseNumber(count)
      presentCount= findPresentCountsForTheHouseNumberWithRule2(count)
      if(presentCount >= input)  {
        count
      }
      else
      count += 1
    }


println(count)
}
