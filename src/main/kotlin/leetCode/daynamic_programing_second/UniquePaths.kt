package leetCode.daynamic_programing_second

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = IntArray(n) { 1 }
        repeat(m - 1) {
            for (j in n-1 downTo 1) {
                dp[j - 1] = dp[j] + dp[j - 1]
            }
        }
        return dp[0]
    }
}