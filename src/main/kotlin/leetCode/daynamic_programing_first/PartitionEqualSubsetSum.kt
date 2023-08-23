package leetCode.daynamic_programing_first

class PartitionEqualSubsetSum {
    fun canPartition(nums: IntArray): Boolean {
        if (nums.sum() % 2 == 1) return false
        val target = nums.sum() / 2
        val dp = BooleanArray(target + 1)
        dp[0] = true

        for (num in nums) {
            for (i in target downTo 1) {
                if (i < num) break
                dp[i] = dp[i] || dp[i - num]
            }
        }
        return dp[target]
    }
}