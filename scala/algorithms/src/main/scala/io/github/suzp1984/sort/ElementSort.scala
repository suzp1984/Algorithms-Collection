package io.github.suzp1984.sort

import scala.util.Random

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

    private def __partition(l : Int, r : Int): Int = {
      val v = array(l)
      var j = l
      (l+1 to r).foreach { i =>
        if (array(i) < v) {
          j += 1
          swap(j, i)
        }
      }

      swap(l, j)
      j
    }

    private def __quickSort(l: Int, r: Int): Unit = {
      if (l >= r) {
        return
      }

      val p = __partition(l, r)
      __quickSort(l, p - 1)
      __quickSort(p + 1, r)
    }

    def quickSort(): Unit = {
      __quickSort(0, array.length-1)
    }

    private def __randomPartition(l: Int, r: Int): Int = {
      swap(l, Random.nextInt(r-l+1)+l)

      __partition(l, r)
    }

    private def __randomQuickSort(l: Int, r: Int): Unit = {
      if (l >= r) {
        return
      }

      val p = __randomPartition(l, r)
      __randomQuickSort(l, p - 1)
      __randomQuickSort(p + 1, r)
    }

    def randomQuickSort(): Unit = {
      __randomQuickSort(0, array.length-1)
    }

    private def __doublePartition(l: Int, r: Int): Int = {
      swap(l, Random.nextInt(r-l+1)+l)

      val v = array(l)
      var i = l+1
      var j = r
      var b = true
      while (b) {
        while (i <= r && array(i) < v) i += 1
        while (j >= l + 1 && array(j) > v) j -= 1

        if (i > j) {
          b = false
        } else {
          swap(i, j)
          i += 1
          j -= 1
        }
      }

      swap(l, j)
      j
    }

    private def __doublePartitionQuickSort(l: Int, r: Int): Unit = {
      if (l >= r) {
        return
      }

      val p = __doublePartition(l, r)
      __doublePartitionQuickSort(l, p - 1)
      __doublePartitionQuickSort(p + 1, r)
    }

    def doublePartitionQuickSort(): Unit = {
      __doublePartitionQuickSort(0, array.length-1)
    }

    private def __triplePartitionQuickSort(l: Int, r: Int): Unit = {
      if (l >= r) {
        return
      }

      swap(l, Random.nextInt(r-l+1)+l)
      val v = array(l)
      var lt = l
      var gt = r+1
      var i = l+1

      while (i < gt) {
        if (array(i) < v) {
          swap(i, lt+1)
          lt += 1
          i += 1
        } else if (array(i) > v) {
          swap(i, gt-1)
          gt -= 1
        } else {
          i += 1
        }
      }
      swap(l, lt)

      __triplePartitionQuickSort(l, lt - 1)
      __triplePartitionQuickSort(gt, r)
    }

    def triplePartitionQuickSort(): Unit = {
      __triplePartitionQuickSort(0, array.length-1)
    }
  }
}
