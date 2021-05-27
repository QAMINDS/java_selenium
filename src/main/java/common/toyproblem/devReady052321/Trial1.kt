package common.toyproblem.devReady052321

class Trial1 {

    val listOne = listOf("a", "t")
}

fun main() {

    val t1 = Trial1()
    val list1 = t1.listOne

    for (k in 0 until list1.size) {
        println("                This is k: $k   and ${list1[k]} ")
    }

    for (t in 0..5) {
        println(" This is k: $t")
    }

    for (t in 0 until 5) {
        println("          This is k: $t")
    }

}