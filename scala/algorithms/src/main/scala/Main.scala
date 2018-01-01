import ElementSortExtension.ElementSort
import SortUtilsExtension.SortUtils
import SortUtilsExtension.arrayOf

import scala.collection.immutable
import scala.util.Random

object Main {

  def main(args: Array[String]): Unit = {

    val array0 = arrayOf(10, Random.nextInt(10))
    array0.printSelf()
  }
}
