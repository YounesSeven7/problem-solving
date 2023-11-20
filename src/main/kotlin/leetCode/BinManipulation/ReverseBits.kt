package leetCode.BinManipulation

class ReverseBits {
    fun reverseBits(n:Int):Int {
        var result = 0
        var n = n
        repeat(32) {
            result = result shl 1
            if (n and 1 == 1) result++
            n = n shr 1
        }
        return result
    }
}