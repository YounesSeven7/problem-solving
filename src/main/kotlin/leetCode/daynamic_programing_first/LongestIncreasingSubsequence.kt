package leetCode.daynamic_programing_first

class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        var res = 1
        val arr = IntArray(nums.size) { 1 }
        for (i in nums.size - 2 downTo 0) {
            for (j in i + 1 until nums.size) {
                if (nums[i] < nums[j]) {
                    arr[i] = maxOf(arr[i],arr[j] + 1)
                    res = maxOf(res, arr[i])
                }
            }
        }
        return res
    }
}