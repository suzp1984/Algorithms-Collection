package io.github.suzp1984.sort

import io.github.suzp1984.sort.SortUtils.arrayOf

import scala.util.Random

object Main {

  def main(args: Array[String]): Unit = {

    println("\n Selection Sort")
    val array0 = arrayOf[Int](10, Random.nextInt(10))
    array0.printSelf()
    array0.selectionSort()
    println("\n After Selection Sort")
    array0.printSelf()

    println("\n Insertio Sort")
    val array1 = arrayOf[Int](10, Random.nextInt(10))
    array1.printSelf()
    array1.insertionSort()
    println("\n After Insertion Sort")
    array1.printSelf()

    println("\n Improved Insertion Sort")
    val array2 = arrayOf[Int](10, Random.nextInt(10))
    array2.printSelf()
    array2.insertionSortImproved()
    println("\n After Improved Insertion Sort")
    array2.printSelf()

    println("\n Bubble Sort")
    val array3 = arrayOf[Int](10, Random.nextInt(10))
    array3.printSelf()
    array3.bubbleSort()
    println("\n After Bubble Sort")
    array3.printSelf()

    println("\n Merge Sort")
    val array4 = arrayOf(10, Random.nextInt(10))
    array4.printSelf()
    array4.mergeSort()
    println("\n After Merge Sort")
    array4.printSelf()

    println("\n Bottom up Merge Sort")
    val array5 = arrayOf(10, Random.nextInt(10))
    array5.printSelf()
    array5.bottomUpMergeSort()
    println("\n After Bottom Up Merge Sort")
    array5.printSelf()

    println("\n Quick Sort")
    val array6 = arrayOf(10, Random.nextInt(10))
    array6.printSelf()
    array6.quickSort()
    println("\n After Quick Sort")
    array6.printSelf()

    println("\n Random Quick Sort")
    val array7 = arrayOf(10, Random.nextInt(10))
    array7.printSelf()
    array7.randomQuickSort()
    println("\n After Random Quick Sort")
    array7.printSelf()

    println("\n Double Partition Quick Sort")
    val array8 = arrayOf(10, Random.nextInt(10))
    array8.printSelf()
    array8.doublePartitionQuickSort()
    println("\n After Double Partition Quick Sort")
    array8.printSelf()

    println("\n Triple Partition Quick Sort")
    val array9 = arrayOf(10, Random.nextInt(10))
    array9.printSelf()
    array9.triplePartitionQuickSort()
    println("\n After Triple Partition Quick Sort")
    array9.printSelf()
  }
}
