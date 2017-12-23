import io.github.suzp1984.algorithms.UnionFind
import io.github.suzp1984.algorithms.UnionFind2

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
}