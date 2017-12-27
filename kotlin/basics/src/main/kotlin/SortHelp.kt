package io.github.suzp1984.algorithms


inline fun <reified T> generateRandomArray(size: Int, start: T, end: T, noinline init: (Int) -> T) : Array<T> {
    return Array<T>(size, init)
}

fun <T> Array<T>.printItSelf() {
    print("[${this}]: ")
    forEach { print("${it} ") }
}

//fun <T> generateNearlyOrderedIntArray(array: Array<T>, swapTimes: Int) : Array<T> {
//
//}