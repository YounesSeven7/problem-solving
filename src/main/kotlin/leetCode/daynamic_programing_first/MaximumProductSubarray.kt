package leetCode.daynamic_programing_first

import kotlin.math.max

class MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        var res = nums[0]
        var curMin = 1
        var curMax = 1

        for (num in nums) {
            val temp = curMax
            curMax = maxOf(curMax * num, curMin * num, num)
            curMin = minOf(temp * num, curMin * num, num)
            res = maxOf(res, curMax)
        }

        return res
    }
}