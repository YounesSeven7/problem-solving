package leetCode.medium

class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var gSum = Int.MIN_VALUE
        var lSum = 0
        for (i in 0..nums.size-1) {
            lSum += nums[i]
            gSum = Math.max(gSum, lSum)
            if (lSum < 0)
                lSum = 0
        }
        return gSum
    }
}