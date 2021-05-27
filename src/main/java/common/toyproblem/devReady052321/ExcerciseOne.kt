package common.toyproblem.devReady052321

fun main() {
    val input = 1
    val result = solution(input)
    println(" $input   $result")
}

fun solution(N: Int): Int {
    // write your code in Kotlin
    if (N == 1) return 0
    val numberLength = N.toString().toCharArray().size
    var number = "1"

    for (k in 0 until numberLength-1) {
        number = "${number}0"
    }

    return number.toInt()
}

class ExcerciseOne {
}


