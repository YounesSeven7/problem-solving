package leetCode.BinManipulation

class NumberOfOneBits {
    fun hammingWeight(n:Int):Int {
        var count = 0
        var n = n
        repeat(32) {
            if (n and 1 == 1) count++
            n = n shr 1
        }
        return count
    }
}