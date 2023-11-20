package leetCode.daynamic_programing_second

class LongestCommonSubsequence {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val n = text1.length
        val m = text2.length
        val matrix = Array(n) { IntArray(m) { 0 } }

        fun getValue(i: Int, j: Int): Int {
            return if (i == -1 || j == -1) 0
            else matrix[i][j]
        }
        for (i in 0 until  n) {
            for (j in 0 until  m) {
                matrix[i][j] = if (text1[i] == text2[j]) 1 + getValue(i - 1, j - 1)
                else maxOf(
                    getValue(i - 1, j),
                    getValue(i, j - 1)
                )
            }
        }

        return matrix[n - 1][m - 1]
    }
}