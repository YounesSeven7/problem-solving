package leetCode.daynamic_programing_second

import kotlin.math.min

class TargetSum {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val dp = mutableMapOf<String, Int>()
        fun dfs(index: Int, total: Int):Int {
            if (index == nums.size && total == target) return 1
            if (index >= nums.size) return 0
            if (dp.containsKey("$index, $total")) return dp["$index, $total"]!!

            val add = dfs(index + 1, total + nums[index])
            val minus = dfs(index + 1, total - nums[index])
            dp["$index, $total"] = add + minus
            return add + minus
        }
        return dfs(0, 0)
    }
}