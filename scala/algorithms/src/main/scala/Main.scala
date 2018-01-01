package io.github.suzp1984.sort

import ElementSort.ElementSortImpl
import SortUtils.ArrayUtils
import SortUtils.arrayOf

import scala.util.Random

object Main {

  def main(args: Array[String]): Unit = {

    println("\n Selection Sort")
    val array0 = arrayOf[Int](10, Random.nextInt(10))
    array0.printSelf()
    array0.selectionSort()
    println("\n After Selection Sort")
    array0.printSelf()
  }
}
