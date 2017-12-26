import io.github.suzp1984.algorithms.*
import java.util.*

fun main(args: Array<String>) {
    println("Hello world!")

    val union1 = UnionFind(10)

    union1.unionElements(1, 3)
    union1.unionElements(3, 5)

    println("1 and 5 is connected : ${union1.isConnected(1, 5)}")

    val union2 = UnionFind2(10)
    union2.unionElements(1, 3)
    union2.unionElements(3, 5)

    println("1 & 5 is connected : ${union2.isConnected(1, 5)}")

    val array1 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("Selection Sort")
    array1.forEach { print("${it} ") }
    println("\n ---after sort---")
    array1.selectionSort()
    array1.forEach { print("${it} ") }

    val array2 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nInsertion Sort")
    array2.forEach { print("${it} ") }
    array2.insertionSort()
    println("\n ---after sort---")
    array2.forEach { print("${it} ") }

    val array3 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nImproved Insertion Sort")
    array3.forEach { print("${it} ") }
    array3.improvedInsertionSort()
    println("\n ---after sort---")
    array3.forEach { print("${it} ") }

    val array4 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nBubble Sort")
    array4.forEach { print("${it} ") }
    array4.bubbleSort()
    println("\n -- after bubble sort ---")
    array4.forEach { print("${it} ") }

    val array5 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nMerge Sort")
    array5.forEach { print("${it} ") }
    array5.mergeSort()
    println("\n --- after merge sort ---")
    array5.forEach { print("${it} ") }

    val array6 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nBottom up Merge Sort")
    array6.forEach { print("${it} ") }
    array6.bottomUpMergeSort()
    println("\n --- after bottom up merge sort ---")
    array6.forEach { print("${it} ") }

    val array7 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nQuick Sort")
    array7.forEach { print("${it} ") }
    array7.quickSort()
    println("\n -- after quick sort ---")
    array7.forEach { print("${it} ") }

    val array8 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nRandom Quick Sort")
    array8.forEach { print("${it} ") }
    array8.quickSortRandom()
    println("\n --- after random quick sort ---")
    array8.forEach { print("${it} ") }

    val array9 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nDouble Partition Quick Sort")
    array9.forEach { print("${it} ") }
    array9.quickSortDoublePartition()
    println("\n --- after Double Partition quick sort ---")
    array9.forEach { print("${it} ") }

    val array10 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nTriple Partition Quick Sort")
    array10.forEach { print("${it} ") }
    array10.quickSortTriplePartition()
    println("\n --- after Triple Partition quick sort ---")
    array10.forEach { print("${it} ") }
}