package io.github.suzp1984.algorithms

fun <T> Array<T>.swap(i : Int, j : Int) {
    val t = this[i]
    this[i] = this[j]
    this[j] = t
}

fun <T : Comparable<T>> Array<T>.selectionSort() {
    indices.forEach { i ->
        var minIndex = i
        (i + 1 until size)
                .asSequence()
                .filter { this[it] < this[minIndex] }
                .forEach { minIndex = it }

        swap(minIndex, i)
    }
}

fun <T : Comparable<T>> Array<T>.insertionSort() {
    (1 until size).forEach { i ->
        (i downTo 1)
                .asSequence()
                .takeWhile { this[it] < this[it - 1] }
                .forEach { swap(it, it - 1) }
    }
}

fun <T : Comparable<T>> Array<T>.improvedInsertionSort() {
    (1 until size).forEach { i ->
        val t = this[i]

        val seqIndex = (i downTo 1)
                .asSequence()
                .takeWhile { this[it-1] > t }

        seqIndex.forEach { this[it] = this[it-1] }

        val lastIndex = seqIndex.lastOrNull()
        if (lastIndex != null) this[lastIndex - 1] = t
    }
}


fun <T : Comparable<T>> Array<T>.bubbleSort() {
    (0 until size).forEach {
        (1 until size - it).forEach {
            if (this[it] < this[it-1]) {
                swap(it, it-1)
            }
        }
    }
}