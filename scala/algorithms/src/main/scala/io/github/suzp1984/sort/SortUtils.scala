package io.github.suzp1984.sort

object SortUtils {

  implicit class ArrayUtils[A] (val array: Array[A]) {

    def printSelf(): Unit = {
      array.foreach { it => print(it + " ")}
    }
  }

  def arrayOf[T: Manifest](size: Int, op: => T): Array[T] = {
    val array = new Array[T](size)
    array.indices.foreach { it =>
      array(it) = op
    }

    array
  }
}
