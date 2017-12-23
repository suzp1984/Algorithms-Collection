package io.github.suzp1984.algorithms

class UnionFind(size : Int) {
    val ids : Array<Int>

    init {
        ids = Array(size) { it }
    }

    private fun find(p : Int) : Int {
        if (p < 0 || p > ids.size)
            throw IllegalArgumentException("array out of scope")

        return ids[p]
    }

    fun isConnected(q : Int, p : Int) : Boolean {
        if (q >= 0 && q < ids.size &&
                p >= 0 && p < ids.size) {
            return ids[p] == ids[q]
        }

        throw IllegalArgumentException("array out of scope")
    }

    fun unionElements(p : Int, q : Int) {
        val pId = find(p)
        val qId = find(q)

        if (pId == qId) {
            return
        }

        ids.indices
                .filter { ids[it] == pId }
                .forEach { ids[it] = qId }
    }
}

class UnionFind2(size : Int) {
    private val ids : Array<Int>

    init {
        ids = Array(size) { it }
    }

    private fun find(p : Int) : Int {
        if (p < 0 || p > ids.size)
            throw IllegalArgumentException("array out of scope")

        var i = p
        while (i != ids[i]) i = ids[i]

        return i
    }

    fun isConnected(q : Int, p : Int) : Boolean {
        return find(q) == find(p)
    }

    fun unionElements(p : Int, q : Int) {
        val pId = find(p)
        val qId = find(q)

        if (pId == qId) {
            return
        }

        ids[pId] = qId
    }
}