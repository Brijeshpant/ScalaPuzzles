import java.security.MessageDigest

/**
  * Created by bpant on 22/12/15.
  */
object puzzle4 extends App {

  val input = "bgvyzdsv"

  def scanForKey() = {
    var i=1
    while (!md5(input + i).startsWith("000000")) {
      i += 1
    }
    println(i)
  }

  def md5(s: String) = {
    val digest = MessageDigest.getInstance("MD5")
    digest.digest(s.getBytes).map("%02x".format(_)).mkString

  }
  scanForKey
}
