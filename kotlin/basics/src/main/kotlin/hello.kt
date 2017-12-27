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
    array1.printItSelf()
    println("\n ---after sort---")
    array1.selectionSort()
    array1.printItSelf()

    val array2 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nInsertion Sort")
    array2.printItSelf()
    array2.insertionSort()
    println("\n ---after sort---")
    array2.printItSelf()

    val array3 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nImproved Insertion Sort")
    array3.printItSelf()
    array3.improvedInsertionSort()
    println("\n ---after sort---")
    array3.printItSelf()

    val array4 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nBubble Sort")
    array4.printItSelf()
    array4.bubbleSort()
    println("\n -- after bubble sort ---")
    array4.printItSelf()

    val array5 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nMerge Sort")
    array5.printItSelf()
    array5.mergeSort()
    println("\n --- after merge sort ---")
    array5.printItSelf()

    val array6 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nBottom up Merge Sort")
    array6.printItSelf()
    array6.bottomUpMergeSort()
    println("\n --- after bottom up merge sort ---")
    array6.printItSelf()

    val array7 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nQuick Sort")
    array7.printItSelf()
    array7.quickSort()
    println("\n -- after quick sort ---")
    array7.printItSelf()

    val array8 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nRandom Quick Sort")
    array8.printItSelf()
    array8.quickSortRandom()
    println("\n --- after random quick sort ---")
    array8.printItSelf()

    val array9 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nDouble Partition Quick Sort")
    array9.printItSelf()
    array9.quickSortDoublePartition()
    println("\n --- after Double Partition quick sort ---")
    array9.printItSelf()

    val array10 = Array<Int>(10) {
        Random().nextInt(10)
    }
    println("\nTriple Partition Quick Sort")
    array10.printItSelf()
    array10.quickSortTriplePartition()
    println("\n --- after Triple Partition quick sort ---")
    array10.printItSelf()
}