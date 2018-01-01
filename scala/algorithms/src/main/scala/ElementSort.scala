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

    def insertionSort(): Unit = {
      (1 until array.length).foreach { i =>
        (i until 0 by -1).takeWhile { j =>
          val b = array(j) < array(j-1)
          if (b) {
            swap(j, j - 1)
          }

          b
        }
      }
    }

    def insertionSortImproved(): Unit = {
      (1 until array.length).foreach { i =>
        val temp = array(i)
        var index = i
        (i until 0 by -1).takeWhile { j =>
          val b = array(j-1) > temp
          if (b) {
            array(j) = array(j-1)
            index = j
          }
          b
        }

        array(index-1) = temp
      }
    }

    def bubbleSort(): Unit = {
      array.indices.foreach { i =>
        (1 until array.length - i).foreach { j =>
          if (array(j) < array(j-1)) {
            swap(j, j-1)
          }
        }
      }
    }
  }
}

