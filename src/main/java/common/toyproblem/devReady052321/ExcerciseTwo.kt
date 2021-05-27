package common.toyproblem.devReady052321

fun main() {
//    val input = listOf(0, 5, 4, 4, 5, 12).toIntArray()
//    val input = listOf(4,2,2,4,2).toIntArray()
//    val input = listOf(1,2,3,2).toIntArray()
    val input = listOf(4,4 ).toIntArray()


    println(" Excer two")
    val result = solution(input)
    println("   $result ")
}

fun solution(A: IntArray): Int {
    // write your code in Kotlin

    var longestCounter = 0

    for(k in 0 until A.size-1) {
        val num1 = A[k]
        val num2 = A[k+1]
        var currentIndex = k
        var counter = 0

        while(currentIndex < A.size) {
            if (A[currentIndex] == num1 || A[currentIndex] == num2) {
                counter++
            } else {
                break
            }
            currentIndex++
        }
        if (counter > longestCounter) {
            longestCounter = counter
        }
    }
    return longestCounter
}


class ExcerciseTwo {
}