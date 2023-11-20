package leetCode.daynamic_programing_second

class InterleavingString {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val n = s1.length
        val m = s2.length
        if (n + m != s3.length) return false
        val dp = BooleanArray(m + 1)
        dp[m] = true
        for (i in n downTo 0) {
            for (j in m downTo 0) {
                if (i == n && j == m) continue
                val bottom = i < n && s1[i] == s3[i + j] && dp[j]
                val left = j < m && s2[j] == s3[i + j] && dp[j + 1]
                dp[j] = bottom || left
            }
        }
        return dp[0]
    }
}