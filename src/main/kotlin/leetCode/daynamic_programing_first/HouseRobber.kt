package leetCode.daynamic_programing_first

class HouseRobber {
    fun rob(nums: IntArray): Int {
        var rob1 = 0
        var rob2 = 0
        for (i in nums.indices) {
            val temp = Math.max(rob1 + nums[i], rob2)
            rob1 = rob2
            rob2 = temp
        }
        return rob2
    }
}