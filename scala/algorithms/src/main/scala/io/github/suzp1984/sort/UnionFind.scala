package io.github.suzp1984.sort

object UnionFindOne {
  class UnionFind(val n : Int) {
    val array = new Array[Int](n)
    array.indices.foreach { i =>
      array(i) = i
    }

    def find(p : Int): Int = {
      require(p >= 0 && p < n)
      array(p)
    }

    def isConnected(q : Int, p : Int) : Boolean = {
      require(q >= 0 && q < n)
      require(p >= 0 && p < n)

      array(p) == array(q)
    }

    def unionElements(q : Int, p : Int): Unit = {
      val pId = find(p)
      val qId = find(q)

      if (qId == pId) {
        return
      }

      array.indices.foreach { i =>
        if (array(i) == pId) {
          array(i) = qId
        }
      }
    }
  }
}
