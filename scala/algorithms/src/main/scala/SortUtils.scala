import scala.util.Random

object SortUtilsExtension {
  implicit class SortUtils[A] (val array: Array[A]) {
    def printSelf(): Unit = {
      array.foreach {println}
    }
  }

  def arrayOf[T: Manifest](size: Int, op: => T): Array[T] = {
    val array = new Array[T](size)
    (0 until  array.length).foreach { it =>
      array(it) = op
    }

    return array
  }
}
