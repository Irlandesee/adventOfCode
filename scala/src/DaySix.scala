import scala.io.Source
import scala.io.Source._

object DaySix extends App{

  val fileName = "~/Documents/Github/adventOfCode/scala/src/input.txt"
  scala.io.Source.fromFile(fileName).getLines().foreach{
    line => println(line)
  }

}
