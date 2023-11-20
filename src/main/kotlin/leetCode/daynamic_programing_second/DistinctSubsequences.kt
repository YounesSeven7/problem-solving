package leetCode.daynamic_programing_second

class DistinctSubsequences {
    fun numDistinct(s: String, t: String): Int {
        val n = s.length
        val m = t.length
        val dp = mutableMapOf<String, Int>()
        fun dfs(i: Int, j: Int): Int{
            if (n - i < m - j) return 0
            if (j == m) return 1
            val key = "$i,$j"
            if (dp.containsKey(key)) return dp[key]!!

            var sum = 0
            if (s[i] == t[j]) sum += dfs(i + 1, j + 1)
            sum += dfs(i + 1, j)
            dp[key] = sum

            return sum
        }
        return dfs(0, 0)
    }
}