package io.github.suzp1984.algorithms

import java.util.*
import kotlin.math.min

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

private fun <T : Comparable<T>> Array<T>.__merge(l : Int, mid : Int, r : Int) {
    val aux = copyOfRange(l, r + 1)

    var i = l
    var j = mid + 1
    (l until r + 1).forEach {
        when {
            i > mid -> {
                this[it] = aux[j-l]
                j++
            }
            j > r -> {
                this[it] = aux[i-l]
                i++
            }
            aux[i-l] < aux[j-l] -> {
                this[it] = aux[i-l]
                i++
            }
            else -> {
                this[it] = aux[j-l]
                j++
            }
        }
    }
}

fun <T : Comparable<T>> Array<T>.mergeSort() {

    fun <T : Comparable<T>> Array<T>.__mergeSort(l : Int, r : Int) {
        if (l >= r) return

        val mid = l/2 + r/2
        __mergeSort(l, mid)
        __mergeSort(mid+1, r)
        __merge(l, mid, r)
    }

    __mergeSort(0, size-1)
}

fun <T : Comparable<T>> Array<T>.bottomUpMergeSort() {
    var sz = 1
    while (sz <= size) {
        var i = 0
        while (i + sz < size) {
            __merge(i, i + sz - 1, min(i + sz + sz - 1, size - 1))
            i += sz + sz
        }

        sz += sz
    }
}

fun <T : Comparable<T>> Array<T>.quickSort() {

    fun <T : Comparable<T>> Array<T>.__partition(l : Int, r : Int) : Int {
        val t = this[l]
        var j = l
        (l+1 until r+1).forEach {
            if (this[it] < t) {
                swap(++j, it)
            }
        }

        swap(l, j)
        return j
    }

    fun <T : Comparable<T>> Array<T>.__quickSort(l : Int, r : Int) {
        if (l >= r) return

        val p = __partition(l, r)
        __quickSort(l, p - 1)
        __quickSort(p + 1, r)
    }

    __quickSort(0, size-1)
}

fun <T : Comparable<T>> Array<T>.quickSortRandom() {
    fun <T : Comparable<T>> Array<T>.__partition(l : Int, r : Int) : Int {
        swap(l, Random().nextInt(r - l + 1) + l)

        val t = this[l]
        var j = l
        (l+1 until r+1).forEach {
            if (this[it] < t) {
                swap(++j, it)
            }
        }

        swap(l, j)
        return j
    }

    fun <T : Comparable<T>> Array<T>.__quickSort(l : Int, r : Int) {
        if (l >= r) return

        val p = __partition(l, r)
        __quickSort(l, p - 1)
        __quickSort(p + 1, r)
    }

    __quickSort(0, size-1)
}

fun <T : Comparable<T>> Array<T>.quickSortDoublePartition() {
    fun <T : Comparable<T>> Array<T>.__double_partition(l : Int, r : Int) : Int {
        swap(l, Random().nextInt(r - l + 1) + l)

        val t = this[l]
        var i = l + 1
        var j = r
        while (true) {
            while (i <= r && this[i] < t) i++
            while (j >= l + 1 && this[j] > t) j--
            if (i > j) break
            swap(i, j)
            i++
            j--
        }

        swap(l, j)

        return j
    }

    fun <T : Comparable<T>> Array<T>.__quickSort(l : Int, r : Int) {
        if (l >= r) return

        val p = __double_partition(l, r)
        __quickSort(l, p - 1)
        __quickSort(p + 1, r)
    }

    __quickSort(0, size-1)
}

fun <T : Comparable<T>> Array<T>.quickSortTriplePartition() {
    fun <T : Comparable<T>> Array<T>.__triple_partition(l : Int, r : Int) {
        if (l >= r) {
            return
        }

        swap(l, Random().nextInt(r - l + 1) + l)
        val t = this[l]
        var lt = l
        var gt = r + 1;
        var i = l + 1;
        while (i < gt) {
            if (this[i] < t) {
                swap(i, lt + 1)
                lt++
                i++
            } else if (this[i] > t) {
                swap(i, gt - 1)
                gt--
            } else {
                i++
            }
        }

        swap(l, lt)

        __triple_partition(l, lt - 1)
        __triple_partition(gt, r)
    }

    __triple_partition(0, size - 1)
}