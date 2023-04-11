package leetCode.medium

class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        var prefix = 1
        val arr = IntArray(nums.size)
        for (i in nums.indices) {
            arr[i] = prefix
            prefix *= nums[i]
        }
        var suffix = 1
        for (i in (nums.size-1) downTo 0) {
            arr[i] *= suffix
            suffix *= nums[i]
        }
        return arr
    }
}