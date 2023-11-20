package leetCode.BinManipulation

class CountingBits {
    fun countBits(n: Int): IntArray {
        val arr = IntArray(n + 1)
        if (arr.size == 1) return arr
        arr[1] = 1
        for (i in 2 until arr.size) {
            arr[i] = arr[i / 2] + i % 2
        }
        return arr
    }
}