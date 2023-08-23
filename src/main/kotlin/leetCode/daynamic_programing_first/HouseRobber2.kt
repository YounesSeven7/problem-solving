package leetCode.daynamic_programing_first

class HouseRobber2 {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var rob1 = 0
        var rob2 = 0
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
        val arr1 = nums.copyOfRange(0, nums.size - 2)
        val arr2 = nums.copyOfRange(1, nums.size - 1)
        return Math.max(rob(arr1), rob(arr2))
    }
}