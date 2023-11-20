package leetCode.BinManipulation

class SumOfTwoIntegers {
    fun getSum(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val temp = (a and b) shl 1
            a = a xor b
            b = temp
        }
        return a
    }
}