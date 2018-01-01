package io.github.suzp1984.sort

object ElementSort {

  implicit class ElementSortImpl[A](val array: Array[A])(implicit evl: A => Ordered[A]) {

    def swap(x: Int, y: Int): Unit = {
      val t = array(x)
      array(x) = array(y)
      array(y) = t
    }

    def selectionSort(): Unit = {
      array.indices.foreach { i =>
        var minIndex = i
        (i + 1 until array.length).foreach { j =>
          if (array(j) < array(minIndex)) {
            minIndex = j
          }
        }

        swap(i, minIndex)
      }
    }
  }
}

