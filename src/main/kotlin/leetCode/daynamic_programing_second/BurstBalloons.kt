package leetCode.daynamic_programing_second

class BurstBalloons {
    fun maxCoins(nums: IntArray): Int {
        val n = nums.size
        val dp = Array(n) { IntArray(n) }

        fun getValue(i: Int): Int {
            return if (i < 0 || i >= n) 1
            else nums[i]
        }

        fun dfs(l: Int, r: Int): Int{
            if (l < 0 || r >= n || l > r) return 0
            if (dp[l][r] != 0) return dp[l][r]
            var max = 0
            for (i in l..r) {
                val left = dfs(l, i - 1)
                val right = dfs(i + 1, r)
                val result = (getValue(l - 1) * nums[i] * getValue(r + 1)) + left + right
                max = maxOf(max, result)
            }
            dp[l][r] = max
            return max
        }
        return dfs(0, n - 1)
    }
}