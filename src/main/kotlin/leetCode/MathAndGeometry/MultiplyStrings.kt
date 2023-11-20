package leetCode.MathAndGeometry

import kotlin.math.pow

class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"
        val n = num1.length
        val m = num2.length
        val arr = IntArray(n + m)
        val num1 = num1.reversed()
        val num2 = num2.reversed()
        var num = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                val result = (num1[i] - '0') * (num2[j] - '0')  + arr[i + j]
                arr[i + j + 1] += result / 10
                arr[i + j] = result % 10
            }
        }
        val stringBuilder = StringBuilder()
        for (i in arr.size - 1 downTo  0) {
            if (arr[i] == 0) continue
            for (j in i downTo 0) {
                stringBuilder.append(arr[j])
            }
            break
        }

        return stringBuilder.toString()
    }
}