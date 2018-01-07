package io.github.suzp1984.sort

object UnionFindOne {
  class UnionFind private (private val n : Int) {
    val ids = new Array[Int](n)
    ids.indices.foreach { i =>
      ids(i) = i
    }

    private def find(p : Int): Int = {
      require(p >= 0 && p < n)
      ids(p)
    }

    def isConnected(q : Int, p : Int) : Boolean = {
      require(q >= 0 && q < n)
      require(p >= 0 && p < n)

      ids(p) == ids(q)
    }

    def unionElements(q : Int, p : Int): Unit = {
      val pId = find(p)
      val qId = find(q)

      if (qId == pId) {
        return
      }

      ids.indices.foreach { i =>
        if (ids(i) == pId) {
          ids(i) = qId
        }
      }
    }
  }

  object UnionFind {
    def apply(n: Int): UnionFind = new UnionFind(n)
  }
}

object UnionFindTwo {
  class UnionFind private (private val n : Int) {
    val ids = new Array[Int](n)
    ids.indices.foreach { i =>
      ids(i) = i
    }

    private def find(p : Int): Int = {
      require(p >= 0 && p < n)
      var index = p
      while (index != ids(index)) {
        index = ids(index)
      }
      ids(index)
    }

    def isConnected(p: Int, q: Int) : Boolean = {
      ids(p) == ids(q)
    }

    def unionElements(q: Int, p : Int): Unit = {
      val pRoot = find(p)
      val qRoot = find(q)

      if (qRoot == pRoot) {
        return
      }

      ids(pRoot) = qRoot
    }
  }

  object UnionFind {
    def apply(n :Int): UnionFind = new UnionFind(n)
  }
}