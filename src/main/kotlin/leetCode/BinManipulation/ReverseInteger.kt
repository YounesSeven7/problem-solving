package leetCode.BinManipulation

class ReverseInteger {
    fun reverse(x: Int): Int {
        var x = x
        var res = 0
        val max = Int.MAX_VALUE
        val min = Int.MIN_VALUE

        while (x != 0) {
            val currentDigit = x % 10
            x /= 10
            if (res > max / 10 || (res == max / 10 && currentDigit >= max % 10 )) return 0
            if (res < min / 10 || (res == min / 10 && currentDigit <= min % 10)) return 0
            res = (res * 10) + currentDigit
        }
        return res
    }
}