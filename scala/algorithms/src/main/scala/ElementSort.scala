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

    private def __merge(l : Int, mid : Int, r : Int): Unit = {
      val aux = array.slice(l, r + 1)
      var i = l
      var j = mid + 1
      (l to r).foreach { k =>
        if (i > mid) {
          array(k) = aux(j-l)
          j += 1
        } else if (j > r) {
          array(k) = aux(i-l)
          i += 1
        } else if (aux(i - l) < aux(j - l)) {
          array(k) = aux(i-l)
          i += 1
        } else {
          array(k) = aux(j-l)
          j += 1
        }
      }
    }

    private def __mergeSort(l : Int, r : Int): Unit = {
      if (l >= r) {
        return
      }

      val mid = l/2 + r/2
      __mergeSort(l, mid)
      __mergeSort(mid+1, r)
      __merge(l, mid, r)
    }

    def mergeSort(): Unit = {
      __mergeSort(0, array.length - 1)
    }

    def bottomUpMergeSort(): Unit = {
      var sz = 1
      while (sz <= array.length) {
        var i = 0
        while (i + sz < array.length) {
          __merge(i, i+sz-1, Math min(i + sz + sz - 1, array.length - 1))
          i += sz + sz
        }
        sz += sz
      }
    }
  }
}

