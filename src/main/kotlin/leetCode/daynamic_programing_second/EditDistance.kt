package leetCode.daynamic_programing_second

class EditDistance {
    fun minDistance(word1: String, word2: String): Int {
        val n = word1.length
        val m = word2.length

        val dp = Array(n + 1){ IntArray(m + 1) }
        for (i in 0 until n) dp[i][m] = n - i
        for (j in 0 until m) dp[n][j] = m - j

        fun editDistance(i: Int, j: Int): Int{
            if (word1[i] == word2[j]) return dp[i + 1][j + 1]
            val insert = dp[i][ j + 1]
            val delete = dp[i + 1][j]
            val replace = dp[i + 1][j + 1]
            return minOf(insert, delete, replace) + 1
        }

        for (i in n - 1 downTo 0) {
            for (j in m - 1 downTo 0) {
                dp[i][j] = editDistance(i, j)
            }
        }
        return dp[0][0]
    }
}