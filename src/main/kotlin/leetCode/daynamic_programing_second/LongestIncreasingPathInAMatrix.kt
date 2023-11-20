package leetCode.daynamic_programing_second

class LongestIncreasingPathInAMatrix {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val m = matrix[0].size
        val dp = Array(matrix.size){ IntArray(matrix[0].size) }
        var max = 0
        fun dfs(i: Int, j: Int, prev: Int): Int{
            if (i < 0 || i >= n || j < 0 || j >= m || prev >= matrix[i][j]) return 0
            if (dp[i][j] != 0) return dp[i][j]

            val currentValue = matrix[i][j]
            val left = dfs(i, j - 1, currentValue)
            val top = dfs(i - 1, j, currentValue)
            val right = dfs(i, j + 1, currentValue)
            val bottom = dfs(i + 1, j, currentValue)
            dp[i][j] = maxOf(left, top, right, bottom) + 1

            return dp[i][j]
        }
        for (i in 0 until n)
            for (j in 0 until m)
                max = maxOf(max, dfs(i, j, Int.MIN_VALUE))
        return max
    }
}