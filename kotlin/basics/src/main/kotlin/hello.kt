import io.github.suzp1984.algorithms.UnionFind
import io.github.suzp1984.algorithms.UnionFind2
import io.github.suzp1984.algorithms.insertionSort
import io.github.suzp1984.algorithms.selectionSort
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
}